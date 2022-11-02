<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 02/11/2022
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  User user = (User) session.getAttribute("user");
%>
<html>
<head>
    <title>edit profile</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
  <link rel="stylesheet" href="profileSettings.css">
</head>
<body>
<div class="container bootstrap snippets bootdey">
  <h1 class="text-primary">Edit Profile</h1>
  <hr>
  <div class="row">
    <!-- left column -->
    <div class="col-md-3">
      <div class="text-center">
        <img src="https://bootdey.com/img/Content/avatar/avatar7.png" class="avatar img-circle img-thumbnail" alt="avatar">
        <h6>Upload a different photo...</h6>
        <input type="file" class="form-control">
        <div class="btn">
          <form action="deleteAccount" method="post">
            <button style="color: red" type="submit" name="delete">Delete Account</button>
          </form>

        </div>

      </div>
    </div>

    <!-- edit form column -->
    <div class="col-md-9 personal-info">
      <div class="alert alert-info alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a>
        <i class="fa fa-coffee"></i>
        This is an <strong>.alert</strong>. Use this to show important messages to the user.
      </div>
      <h3>Personal info</h3>

      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">First name:</label>
          <div class="col-lg-8">
            <input class="form-control" type="text" value=<%= user.getFirst_name() %>>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Last name:</label>
          <div class="col-lg-8">
            <input class="form-control" type="text" value=<%= user.getLast_name() %>>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Email:</label>
          <div class="col-lg-8">
            <input class="form-control" type="text" value=<%= user.getEmail() %>>
          </div>
        </div>

        <div class="btn">
          <button type="submit" name="save-changes">Save changes</button>
        </div>
      </form>
    </div>
  </div>
</div>
<hr>
</body>
</html>
