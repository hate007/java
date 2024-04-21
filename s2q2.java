import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Request Information</title></head><body>");

        out.println("<h2>Client Information:</h2>");
        out.println("<p>IP Address: " + request.getRemoteAddr() + "</p>");
        out.println("<p>Browser Type: " + request.getHeader("User-Agent") + "</p>");

        out.println("<h2>Server Information:</h2>");
        out.println("<p>Server Name: " + request.getServerName() + "</p>");
        out.println("<p>Server Port: " + request.getServerPort() + "</p>");
        out.println("<p>Servlets Loaded:</p>");
           Iterator<String> servletNames = getServletContext().getServletRegistrations().keySet().iterator();
        while (servletNames.hasNext()) {
           String servletName = servletNames.next();
           out.println("<p>- " + servletName + "</p>");
        }
        out.println("</body></html>");
    }
}

// <web-app>
// 	<servlet>
// 		<servlet-name>info</servlet-name>
// 		<servlet-class>RequestInfoServlet</servlet-class>
// 	</servlet>
// 	<servlet-mapping>
// 		<servlet-name>info</servlet-name>
// 		<url-pattern>/info</url-pattern>
// 	</servlet-mapping>
// </web-app>
