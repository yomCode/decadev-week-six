package postDao;

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
        Post post = new Post();
        List<Post> posts = new ArrayList<>();

        String query = "SELECT * FROM posts";
        String query2 = "SELECT * FROM users WHERE user_id = " + "'" + post.getId() + "'";

        try {
            PreparedStatement ps = getConnection().prepareStatement(query);
            PreparedStatement ps2 = getConnection().prepareStatement(query2);
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();

            while(rs.next()){

                post.setId(rs.getInt(1));
                post.setPost_text(rs.getString(2));
                post.setAuthor(rs2.getString(2) + rs2.getString(3));
                post.setCreation_dateTime(rs.getDate(4));

                posts.add(post);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return posts;

    }


}
