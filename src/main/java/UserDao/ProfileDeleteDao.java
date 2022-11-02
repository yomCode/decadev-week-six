package UserDao;

import models.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static models.DB_Connection.getConnection;

public class ProfileDeleteDao {

   public static Boolean isDeleted(User user){
        Boolean deletedSuccessfully;

        String user_email = user.getEmail();
        String query = "DELETE FROM users WHERE email = " + "'" + user_email + "'";

        try {
            PreparedStatement ps = getConnection().prepareStatement(query);

            deletedSuccessfully =  ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return deletedSuccessfully;
    }



}
