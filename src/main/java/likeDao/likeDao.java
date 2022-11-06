package likeDao;

import models.Like;
import models.Post;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static models.DB_Connection.getConnection;

public class likeDao {

    public static Boolean recordLikes(Integer user_id, Integer post_id){
        Boolean isRecorded = null;
        String query = "INSERT INTO likes(user_id, post_id) VALUES (?, ?)";

        try {
            PreparedStatement ps = getConnection().prepareStatement(query);
            ps.setInt(1, user_id);
            ps.setInt(2, post_id);

            isRecorded = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("You cannot like twice!");
        }
        return isRecorded;
    }

    public static Boolean deleteLike(User user){
Boolean isDeleted = null;
        String query = "DELETE FROM likes where user_id =" + user.getId();

        try{
            PreparedStatement ps = getConnection().prepareStatement(query);

           isDeleted = ps.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isDeleted;

    }


    public static List<Like> fetchAllLikes(Post post){
        List<Like> likes = new ArrayList<>();
        String query = "SELECT * FROM likes where post_id= " + post.getId();

        try {
            PreparedStatement ps = getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Like like = new Like();

                like.setId(rs.getInt(1));
                like.setUser_id(rs.getInt(2));
                like.setPost_id(rs.getInt(3));
                like.setLikeDate(rs.getDate(4));

                likes.add(like);

            }

            post.setLikes(likes);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return likes;
    }


}
