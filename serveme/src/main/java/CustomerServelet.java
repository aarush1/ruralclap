import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class CustomerServelet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

        ArrayList<Customer> myresponse = new ArrayList<>();
        Customer C1 = new Customer();
        Customer C2 = new Customer();
        C1.name = "Aarush";
        C1.age = 25;
        C2.name = "Rooh";
        C2.age = 22;

        myresponse.add(C1);
        myresponse.add(C2);

        //java object to JSON
       String myjson = convertJavatoJSON(myresponse);
       response.getWriter().println(myjson);

    }

    private String convertJavatoJSON(Object myresponse) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(myresponse);
        return json;

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        //getBody(request,response);
        Jedis jedis = new Jedis("localhost");//basic redis to store strings
       // jedis.set("key", "value");
        String value = jedis.get("key");
        System.out.println(value);




    }
    private void getBody(HttpServletRequest request,HttpServletResponse response) throws IOException {

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append(System.lineSeparator());
        }
        String data = buffer.toString();
        System.out.println(data);
        String myresponse = "{ \"Response Status\": \"Done\"}";
        response.getWriter().println(myresponse);

    }
}