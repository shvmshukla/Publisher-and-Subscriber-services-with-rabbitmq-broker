package rnd.web.service.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {

	public static void main(String[] args) throws Exception {

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
		context.setContextPath("/");

		Server server = new Server(9999);
		server.setHandler(context);

		context.setResourceBase(System.getProperty("java.io.tmpdir"));

		ServletHolder servletHolder = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		servletHolder.setInitParameter("jersey.config.server.provider.packages", "com.ibm.mdm.sample.rest");

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.destroy();
		}

	}

}