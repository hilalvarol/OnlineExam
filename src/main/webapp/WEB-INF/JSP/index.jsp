<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome To Quiz</title>
    <link rel="stylesheet" href="/index.css">

</head>
<body>

<div class="container">
    <h2>Login </h2>
    <div class="login-page">
        <small>Please enter your email and password to log in</small>
        <hr>
        <form action="/login" method="post">
            <label for="email">Email</label>
            <input class="inputV" type="email" id="email" name="email" required></br>
            <label for="password">Password</label>
            <input class="inputV" type="password" id="password" name="password" required></br>
            <input type="submit" id="login" value="Login" >
        </form>
    </div>
</div>

</body>
</html>
