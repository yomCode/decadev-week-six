package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Comment;
import models.Post;
import models.User;
import postDao.CommentDao;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/comment")
public class commentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");

        Post post = new Post();

       post.setId(Integer.valueOf(request.getParameter("post_id")));
        Comment comment = new Comment();

       comment.setContent(request.getParameter("comment_content"));

       comment.setAuthor(request.getParameter("author"));


    if(CommentDao.recordPostComment(post, user, comment)){

        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        rd.forward(request, response);
    }

    }
}
