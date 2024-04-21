<%@ page language="java" %>
<%@ include file="s12q1a.jsp" %>

<%
    int number = Integer.parseInt(request.getParameter("number"));
    boolean isPerfect = checkPerfectNumber(number);
%>

<html>
<head>
    <title>Perfect Number Checker</title>
</head>
<body>
    <h1>Perfect Number Checker</h1>
    <p>The number <%= number %> is 
    <% if (isPerfect) { %>
        a perfect number.
    <% } else { %>
        not a perfect number.
    <% } %>
    </p>
</body>
</html>
