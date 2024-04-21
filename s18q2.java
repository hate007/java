import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentDetailsServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        int seatNo = Integer.parseInt(request.getParameter("seatNo"));
        String studName = request.getParameter("studName");
        String className = request.getParameter("className");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

        double percentage = (totalMarks / 500.0) * 100;
        
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }

        out.println("<html>");
        out.println("<head><title>Student Details</title></head>");
        out.println("<body>");
        out.println("<h2>Student Details</h2>");
        out.println("<p>Seat No: " + seatNo + "</p>");
        out.println("<p>Student Name: " + studName + "</p>");
        out.println("<p>Class: " + className + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
