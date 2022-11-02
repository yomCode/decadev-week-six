package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import UserDao.UserRegistrationDao;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import static models.DB_Connection.getConnection;

@WebServlet(name = "signupServlet", value = "/signupServlet")
public class registrationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Date date_of_birth = Date.valueOf(request.getParameter("date_of_birth"));


        User newUser = new User(firstname, lastname, email, password, date_of_birth);

        UserRegistrationDao userDB = new UserRegistrationDao(getConnection());

        if (userDB.saveUser(newUser)) {
            response.sendRedirect("index.jsp");
        } else {
//            String errorMsg = "User Available";
//            HttpSession regSession = request.getSession();
//            regSession.setAttribute("RegError", errorMsg);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signup.jsp");
            request.setAttribute(Keys.ERROR, "Something wrong! Please, try again!");
            requestDispatcher.forward(request, response);
//            response.sendRedirect("signup.jsp");


        }
    }
}
