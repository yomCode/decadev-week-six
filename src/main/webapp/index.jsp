<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300i,400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div class="container">
    <div class="row align-items-center justify-content-center vh-100">
        <div class="col-md-7">
<%--            <img src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg" class="w-50">--%>
            <h1 class="text-logo">Facebook Mini</h1>
            <h3>Facebook helps you connect and share with the people in your life.</h3>
        </div>
        <div class="col-md-5">
            <form action=login method="post" class="login-form">
                <div class="error_msg"></div>
                <div class="mb-3">
                    <input type="email" name="email" class="form-control" placeholder="Email address or phone number"
                           required>
                </div>
                <div class="mb-3">
                    <input type="password" name="password" class="form-control" placeholder="Password"
                           required>
                </div>
                <button type="submit" class="btn btn-custom btn-lg btn-block mt-3">Login</button>
                <div class="text-center pt-3 pb-3">
                    <a href="#" class="">Forgotten password?</a>
                    <hr>
                    <a href="signup.jsp">
                        <button type="button" class="btn btn-success btn-lg mt-3">Create New Account</button>
                    </a>
                    </div>
            </form>
            <p class="pt-3 text-center"><b>Create a Page</b> for a celebrity, band or business.</p>
        </div>
    </div>
</div>

<%--<form action="hello-servlet" method="post">--%>
<%--    <input type="text" name="email">--%>
<%--    <input type="password" name="password">--%>
<%--    <button type="submit">login</button>--%>
<%--</form>--%>
</body>
</html>