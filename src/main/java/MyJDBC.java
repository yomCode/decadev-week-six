import java.sql.*;

public class MyJDBC {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/facebook_mini", "root", "1234");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while(resultSet.next()){
            System.out.println(resultSet.getString("first_name"));
        }

    }
}
