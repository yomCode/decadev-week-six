package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Post;
import postDao.PostDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static postDao.PostDao.fetchPost;

@WebServlet(urlPatterns = "/postController")
public class postController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<Post> postList = fetchPost();
        RequestDispatcher rd = request.getRequestDispatcher("feeds.jsp");
        rd.forward(request, response);

        for(Post post : postList){

            out.println("<h4>" + "'" + post.getPost_text().toString() + "'" + "</h4>");

        }



    }
}
