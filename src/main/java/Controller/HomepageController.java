package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.User;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static models.DB_Connection.getConnection;

@WebServlet(urlPatterns = "/post")
public class HomepageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User user_in_session = (User)session.getAttribute("user");

        String post_text =  request.getParameter("post_text");
       Integer user_id = null;

        String query = "SELECT * FROM users WHERE email = " + "'"+ user_in_session.getEmail() +"'";
        try {
            PreparedStatement ps = getConnection().prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user_id = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement ps = getConnection().prepareStatement("INSERT INTO posts(post_content, user_id) VALUES(?, ?)");
            ps.setString(1, post_text);
            ps.setInt(2, user_id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/welcome");
        rd.forward(request, response);

    }
}
