
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserServelet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        String myresponse = "{ \"status\": \"ok\",\"status\": \"ok\"}";
        response.getWriter().println(myresponse);
    }
}
