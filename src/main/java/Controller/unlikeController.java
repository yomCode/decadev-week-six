package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.User;

import java.io.IOException;

import static likeDao.likeDao.deleteLike;

@WebServlet(urlPatterns = "/unlike")
public class unlikeController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setId(Integer.valueOf(request.getParameter("user_id")));

        if(deleteLike(user)){
            RequestDispatcher rd = request.getRequestDispatcher("/welcome");
            rd.forward(request, response);

        }

    }
}
