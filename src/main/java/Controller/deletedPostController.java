package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Post;
import postDao.PostDao;

import java.io.IOException;

import static postDao.PostDao.deletePost;

@WebServlet(urlPatterns = "/delete-Post")
public class deletedPostController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Post post = new Post();

        Integer id = Integer.valueOf(request.getParameter("post_id"));

        if(deletePost(id)  ){
            RequestDispatcher rd = request.getRequestDispatcher("/welcome");
            rd.forward(request, response);
        }

    }
}
