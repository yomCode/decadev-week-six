package postDao;

import models.Comment;
import models.Post;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static models.DB_Connection.getConnection;

public class CommentDao {

    public static boolean recordPostComment(Post post, User user, Comment comment){
        Boolean isAdded = null;

        String query = "INSERT INTO comments(post_id, user_id, comment_text) VALUES(?, ?, ?)";


        try{
            PreparedStatement ps = getConnection().prepareStatement(query);

            ps.setInt(1, post.getId());
            ps.setInt(2, user.getId());
            ps.setString(3, comment.getContent());

            isAdded = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdded;

    }


    public static List<Comment> fetchComment(Post post){

        String query = "SELECT * FROM comments WHERE post_id = " + post.getId();
        List<Comment> comments = new ArrayList<>();


        try {
            PreparedStatement ps = getConnection().prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Comment comment = new Comment();

                comment.setId(rs.getInt(1));
                comment.setContent(rs.getString(2));
                comment.setUser_id(rs.getInt(3));
                comment.setPost_id(rs.getInt(4));
                comment.setCreation_date(rs.getDate(5));

                comments.add(comment);

            }
            post.setComments(comments);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return comments;
    }



}
