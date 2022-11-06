<%@ page import="postDao.PostDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="postDao.CommentDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="models.*" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 30/10/2022
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("user");
%>
<html>
<head>
    <title>Welcome</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="welcome.css">
</head>
<body>
<div class="container bootstrap snippets bootdey">
    <div class="row">
        <div class="panel">
            <div class="cover-photo">
                <div class="fb-timeline-img">
                    <img src="background.jpeg." alt="https://bootdey.com/img/Content/bg1.jpg">
                </div>
                <div class="fb-name">
                    <h2><%= user.getFirst_name() + " " + user.getLast_name() + " " %><a href="profileSetting.jsp"><i class='bx bx-edit'></i></a> </h2>
                </div>
            </div>
            <div class="panel-body">
                <div class="profile-thumb">
                    <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                </div>
                <a href="#" class="fb-user-mail"><%= user.getEmail() %></a>
                <div class="log-out">
                    <form action="logout" method="post">
                        <button type="submit" name="logout" >Log Out</button>
                    </form>
                </div>
                <div class="panel profile-info">
                    <form action=post method="post">
                        <textarea style="color:#171616 ; border-style: solid; border-color: #2525b6 " class="form-control input-lg p-text-area" name="post_text" id="" cols="5" rows="10" placeholder="What's on your mind today?" required></textarea><br>
                        <button type="submit" class="post-btn">Post</button>
                    </form>
                </div>
            </div>
        </div>


<%--=======================================================================================================================--%>
        <%
            List<Post> posts = PostDao.fetchPost();

        for (int i = posts.size()-1; i>=0; i--) { %>

        <%
            List<Comment>  postForComment = CommentDao.fetchComment(posts.get(i));
            List<Like> postLikes = likeDao.likeDao.fetchAllLikes(posts.get(i));

        String query = "SELECT * FROM users WHERE" + "'" + posts.get(i).getAuthor_id() + "'" +  "=" + "user_id";
            PreparedStatement ps = DB_Connection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                posts.get(i).setAuthor(rs.getString(2) + " " + rs.getString(3));

            }
        %>

        <%--=======================================================================================================================--%>
            <div class="space">
                <div class="row d-flex justify-content-center">
                    <div class="col-md-12 col-lg-10 col-xl-8">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex flex-start align-items-center">
                                    <img class="rounded-circle shadow-1-strong me-3"
                                         src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(19).webp" alt="avatar" width="60"
                                         height="60" />
                                    <div>
                                        <h6 class="fw-bold text-primary mb-1"><%= posts.get(i).getAuthor() %></h6>
                                        <p class="text-muted small mb-0">
                                            <%= posts.get(i).getCreation_dateTime() %>
                                        </p>
                                    </div>
                                </div>


                                <p class="mt-3 mb-4 pb-2">
                                    <%= posts.get(i).getPost_text()  %>
                                </p>

                                <div class="small d-flex justify-content-start">

                                    <form action=likes method="post">
                                        <input type="hidden" name="post_id" value=<%= posts.get(i).getId() %>>
                                        <input type="hidden" name="user_id" value=<%= user.getId() %>>
<%--                                        <%for(Like like : postLikes){--%>

<%--                                        if(like.getUser_id() != user.getId()){%>--%>

                                        <button type="submit" class="d-flex naked-btn">
                                            <p class="mb-0"><%= postLikes.size() + " " %>   Like</p>
                                        </button>
                                    </form>

<%--                                    <%}else {%>--%>

<%--                                        <form action=unlike method="post">--%>
<%--                                        <input type="hidden" name="post_id" value=<%= posts.get(i).getId() %>>--%>
<%--                                    <input type="hidden" name="user_id" value=<%= user.getId() %>>--%>
<%--                                    <button type="submit" class="d-flex naked-btn">--%>
<%--                                        <p class="mb-0"><%= postLikes.size() + " " %>   Like</p>--%>
<%--                                    </button>--%>
<%--                                    </form>--%>

<%--                                    <%}%>--%>

<%--                                    <%}%>--%>



                                    <%--=======================================================================================================================--%>

                                    <button type="button" onclick='showComments()' class="d-flex me-3 naked-btn post-btn" >
                                        <p class="mb-0"> <%= postForComment.size() + " " %>  Comment</p>
                                    </button>

                                    <%if(posts.get(i).getAuthor_id() == user.getId()){%>
                                        <form action="delete-Post" method="post">
                                                <input type="hidden" name="post_id" value=<%= posts.get(i).getId() %>>
                                            <button type="submit" class="d-flex naked-btn delete-btn" >
                                                Delete post
                                            </button>
                                        </form>
                                    <%}%>

                                </div>
                            </div>
<%--                         Comment   ==================--%>
                            <div class="card-footer py-3 border-0" style="background-color: #f8f9fa;">
                                <div class="d-flex flex-start w-100">
                                    <div class="form-outline w-100">

                                        <section class="comment-section">
                                            <% for(Comment comment : postForComment){

                                                try {
                                                    String query1 = "SELECT * FROM users WHERE user_id =" + comment.getUser_id();
                                                    PreparedStatement ps1 = DB_Connection.getConnection().prepareStatement(query1);

                                                    ResultSet rs1 = ps1.executeQuery();

                                                    while(rs1.next()){
                                                        comment.setAuthor(rs1.getString(2) + " " + rs1.getString(3));
                                                    }

                                                } catch (SQLException e) {
                                                    throw new RuntimeException(e);
                                                }

                                            %>

                                            <div style="border: #1d1db0; border-style: dotted; margin-bottom: 1rem;  border-radius: 0.5rem; padding: 1rem">
                                                <img class="rounded-circle shadow-1-strong me-3"
                                                     src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(19).webp" alt="avatar" width="40"
                                                     height="40" />
                                                <div>
                                                    <p style="color: #006fff">
                                                        <%
                                                    if(comment.getUser_id() != user.getId()) {%>
                                                       <%= comment.getAuthor()%>
                                                    <%}else{%>
                                                        You
                                                        <%}%>
                                                    </p>
                                                </div>
                                                <div style="margin-top: -1rem">
                                                    <p style="color: black"> <%= comment.getContent() %>  </p>
                                                </div>
                                            </div>

                                            <%}%>
                                        </section>

                                        <form action=comment method="post">
                                            <textarea class="form-control" id="textAreaExample" rows="1"
                                                      style="background: #fff;" name="comment_content"></textarea>
                                            <label class="form-label" for="textAreaExample">Message</label>

                                            <div class="float-end mt-2 pt-1">
                                                <input type="hidden" name="post_id" value="<%= posts.get(i).getId() %>">
                                                <input type="hidden" name="author" value="<%= user.getFirst_name() + " " + user.getLast_name() %>">
                                                <button type="submit" class="btn btn-primary btn-sm">Post comment</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <%}%>
    </div>
    </div>
</div>
<script src="welcome.js"></script>
</body>
</html>
