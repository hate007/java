import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CustomerSearchServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Customer Search</title></head><body>");
        out.println("<h2>Customer Search</h2>");
        out.println("<form method=\"post\">");
        out.println("Enter Customer Number: <input type=\"text\" name=\"customerNumber\"><br>");
        out.println("<input type=\"submit\" value=\"Search\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String customerNumber = request.getParameter("customerNumber");
    String customerDetails = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>Customer Details</title></head><body>");
    out.println("<h2>Customer Details</h2>");

    try {
         Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "123");
        pstmt = conn.prepareStatement("SELECT * FROM customer WHERE no = ?");
        int customerNumberInt = Integer.parseInt(customerNumber);
        pstmt.setInt(1, customerNumberInt);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            customerDetails = rs.getString("name") + ", " + rs.getString("purchase");
        }
    } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
        out.println("Exception occurred: " + e.getMessage());
    }
    
    if (customerDetails != null) {
        out.println("<p>" + customerDetails + "</p>");
    } else {
        out.println("<p>Customer with number " + customerNumber + " not found.</p>");
    }
    
    out.println("</body></html>");
}
}