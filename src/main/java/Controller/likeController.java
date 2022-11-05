package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static likeDao.likeDao.recordLikes;

@WebServlet(urlPatterns = "/likes")
public class likeController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer post_id = Integer.valueOf(request.getParameter("post_id"));
        Integer user_id = Integer.valueOf(request.getParameter("user_id"));

       if(recordLikes(user_id, post_id)){

           RequestDispatcher rd = request.getRequestDispatcher("welcome");
           rd.forward(request, response);
       }


    }
}
