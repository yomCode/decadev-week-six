package UserDao;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistrationDao {
    Connection connection;

    public UserRegistrationDao(Connection connection) {
        this.connection = connection;
    }

    public Boolean saveUser(User user){
        boolean insertSuccessful;
        try{
            String query = "INSERT INTO users(first_name, last_name, email, password, date_of_birth) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDate(5, user.getDate_of_birth());

           insertSuccessful = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return insertSuccessful;
    }

}
