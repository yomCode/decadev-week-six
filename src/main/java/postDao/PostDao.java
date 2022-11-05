package postDao;

import jakarta.servlet.http.HttpSession;
import models.Post;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static models.DB_Connection.getConnection;

public class PostDao {


    public static Boolean recordPost(Post post, User user){
            Boolean isAdded;
        try{

            String query = "INSERT INTO posts(user_id, post_content) VALUES (?, ?)";

            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(user.getId()));
            preparedStatement.setString(2, post.getPost_text());

            isAdded = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdded;
    }


    public static List<Post> fetchPost(){
        String query = "SELECT * FROM posts";

        List<Post> posts = new ArrayList<>();

        try {
            PreparedStatement ps = getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();



            while(rs.next()){
                Post post = new Post();

                post.setId(rs.getInt(1));
                post.setPost_text(rs.getString(2));
                post.setAuthor_id(rs.getInt(3));
                post.setCreation_dateTime(rs.getDate(4));

                posts.add(post);
            }
            System.out.println(posts);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return posts;

    }


    public static boolean deletePost(Integer id){
        Boolean isDeleted = null;

        String query = "DELETE FROM posts WHERE post_id =" + id;

        try {
            PreparedStatement ps = getConnection().prepareStatement(query);

            isDeleted = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

        }
        return isDeleted;

    }


}
