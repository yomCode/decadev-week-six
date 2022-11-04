package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Login;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static UserDao.UserLoginDao.loginSuccessful;
import static models.DB_Connection.getConnection;

@WebServlet(urlPatterns = "/login")
public class loginController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

       String email =  request.getParameter("email");
       String password = request.getParameter("password");

        Login login = new Login(email, password);
        User user = new User();

        if(loginSuccessful(login)){
            HttpSession session = request.getSession(true);

            String query = "SELECT * FROM users where email = " + "'" + email + "'";

            try {
                PreparedStatement ps = getConnection().prepareStatement(query);

                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    user.setId(rs.getInt(1));
                    user.setFirst_name(rs.getString(2));
                    user.setLast_name(rs.getString(3));
                    user.setEmail(rs.getString(4));
                    user.setPassword(rs.getString(5));
                    user.setDate_of_birth(rs.getDate(6));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            session.setAttribute("user", user);

//            response.sendRedirect(request.getContextPath() + "/welcome");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/welcome");
            requestDispatcher.forward(request, response);
        }else{
            out.println("<font color=red size=5> Login Failed!!<br>");
            out.println("<a href=index.jsp> Try Again!");
        }

    }
}
