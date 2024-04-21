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
    
    if (inputString != null && !inputString.isEmpty()) {
        int stringLength = inputString.length();
        
        String reversedString = "";
        for (int i = stringLength - 1; i >= 0; i--) {
            reversedString += inputString.charAt(i); 
        }
        out.println("<p>Reversed String: " + reversedString + "</p>");
    } else {
        out.println("<p>Please enter a valid string.</p>");
    }
}
%>

</body>
</html>
