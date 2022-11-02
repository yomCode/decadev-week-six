<%@ page import="models.User" %><%--
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
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="welcome.css">
</head>
<body>
<div class="container bootstrap snippets bootdey">
    <div class="row">
        <div class="panel">
            <div class="cover-photo">
                <div class="fb-timeline-img">
                    <img src="https://bootdey.com/img/Content/bg1.jpg" alt="">
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
                    <button type="submit" name="logout" >Log Out</button>
                </div>

            </div>
        </div>

        <div class="panel profile-info">
            <form action=post method="post">
                <textarea  style="color:black ; " class="form-control input-lg p-text-area" name="post_text" id="" cols="100" rows="10" placeholder="What's on your mind today?"></textarea><br>
            <button type="submit" class="post-btn">Post</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
