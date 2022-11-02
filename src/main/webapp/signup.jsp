<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 31/10/2022
  Time: 07:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Controller.Keys" %>
<%@ page import="java.util.Objects"%>
<html>
<head>
    <title>sign up</title>
  <link rel="stylesheet" href="signup.css">
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<div class="container" id="wrap">
  <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class=”alert-danger”>
        <%= Objects.toString(request.getAttribute(Keys.ERROR), "") %>
      </div>
      <form action="signupServlet" method="post" accept-charset="utf-8" class="form" role="form">
        <legend>Sign Up</legend>
        <h4>It's free and always will be.</h4>
        <div class="row">
          <div class="col-xs-6 col-md-6">
            <input type="text" name="firstname" value="" class="form-control input-lg"
                   placeholder="First Name" required />
          </div>
          <div class="col-xs-6 col-md-6">
            <input type="text" name="lastname" value="" class="form-control input-lg"
                   placeholder="Last Name" required />
          </div>
        </div>
        <input type="text" name="email" value="" class="form-control input-lg" placeholder="Your Email" />
        <input type="password" name="password" value="" class="form-control input-lg"
              placeholder="Password" required />
        <label>Birth Date</label>
        <div class="row">
          <input type="date" name = "date_of_birth" class="dob" required>
          </div>
        <span class="help-block">By clicking Create my account, you agree to our Terms and that you have read
                        our Data Use Policy, including our Cookie Use.</span>
        <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">
          Create my account</button>
      </form>
    </div>
  </div>
</div>
</div>

<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>
</html>
