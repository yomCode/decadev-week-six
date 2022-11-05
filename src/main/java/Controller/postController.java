package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Post;
import models.User;
import postDao.PostDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import static postDao.PostDao.fetchPost;

@WebServlet(urlPatterns = "/postController")
public class postController extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//  HttpSession session = request.getSession(true);
// String post_id = request.getParameter("post_id");

  RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
  rd.forward(request, response);

 }
}
