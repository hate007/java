<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting Page</title>
</head>
<body>
    <h2>Welcome, 
        <% 
            String userName = request.getParameter("userName");
            if (userName != null && !userName.isEmpty()) {
                out.print(userName);
            } else {
                out.print("Guest");
            }
        %>
    !</h2>
    <h3>Current Time on Server: <%= new java.util.Date() %></h3>

    <form action="my.jsp" method="post">
        Enter your name: <input type="text" name="userName">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
