<html>
<head>
    <title>Calculate Sum of First and Last Digit</title>
</head>
<body>

<form method="post">
    <label for="number">Enter a number:</label>
    <input type="text" id="number" name="number" required>
    <button type="submit">Calculate</button>
</form>

<% 
if (request.getMethod().equalsIgnoreCase("post")) {
    try {
        String numberStr = request.getParameter("number");
        int number = Integer.parseInt(numberStr);
        int firstDigit = Integer.parseInt(String.valueOf(numberStr.charAt(0)));
        int lastDigit = Integer.parseInt(String.valueOf(numberStr.charAt(numberStr.length() - 1)));
        int sum = firstDigit + lastDigit;

        out.println("<p style='color:red; font-size:18px;'>Sum of first and last digit: " + sum + "</p>");

    } catch (NumberFormatException e) {
        out.println("<p style='color:red;'>Please enter a valid number.</p>");
    }
}
%>

</body>
</html>
