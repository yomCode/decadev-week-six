package UserDao;

import models.Login;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static models.DB_Connection.getConnection;

public class UserLoginDao {


    public static Boolean loginSuccessful(Login login){
        getConnection();

        Boolean isDetailsCorrect;

        try{
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, login.getEmail());
            preparedStatement.setString(2, login.getPassword());

           ResultSet resultSet = preparedStatement.executeQuery();

            isDetailsCorrect = resultSet.next();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isDetailsCorrect;
    }





}
