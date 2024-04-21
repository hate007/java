import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitCounterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Visit Counter</title></head>");
        out.println("<body>");

        Cookie[] cookies = request.getCookies();
        int visitCount = 0;
        boolean isNewVisitor = true;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                    isNewVisitor = false;
                    break;
                }
            }
        }

        if (isNewVisitor) {
            out.println("<h2>Welcome, you are visiting the page for the first time!</h2>");
        } else {
            out.println("<h2>Welcome back! You have visited this page " + visitCount + " times.</h2>");
        }

        visitCount++;
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(visitCookie);

        out.println("</body></html>");
        out.close();
    }
}