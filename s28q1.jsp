<html>
<head>
    <title>Reverse a String</title>
</head>
<body>

<form method="post">
    <label for="inputString">Enter a string to reverse:</label>
    <input type="text" id="inputString" name="inputString" required>
    <button type="submit">Reverse</button>
</form>

<% 

if (request.getMethod().equalsIgnoreCase("post")) {

    String inputString = request.getParameter("inputString");
    if (inputString != null) {
        String reversedString = new StringBuilder(inputString).reverse().toString();
        out.println("<p>Reversed String: " + reversedString + "</p>");
    }
}
%>

</body>
</html>
