package Controller;

import UserDao.ProfileDeleteDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.User;

import java.io.IOException;

import static UserDao.ProfileDeleteDao.isDeleted;

@WebServlet(urlPatterns = "/deleteAccount")
public class deleteAccountController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");

        if(isDeleted(user)){
            session.invalidate();

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        }

    }
}
