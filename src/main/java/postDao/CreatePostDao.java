package postDao;

import models.DB_Connection;
import models.Post;
import models.User;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static models.DB_Connection.getConnection;

public class CreatePostDao {


    public static Boolean insertPost(Post post, User user){
            Boolean isAdded;
        try{
            getConnection();

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



}
