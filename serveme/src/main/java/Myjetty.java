
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;

    public class Myjetty {
        private Server server;

        public void configure() throws Exception {
            server = new Server();
            ServerConnector connector = new ServerConnector(server);
            connector.setPort(18090);
            server.setConnectors(new Connector[] {connector});

            ServletHandler servletHandler = new ServletHandler();
            //only once for get put or post
            servletHandler.addServletWithMapping(CustomerServelet.class, "/getCustomers");
            servletHandler.addServletWithMapping(UserServelet.class, "/status");

            ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
            context.setServletHandler(servletHandler);

            server.start();
        }

        public static void main(String[] args) throws Exception {
//            .configure();

            Myjetty myjetty = new Myjetty();
            myjetty.configure();
        }
    }





