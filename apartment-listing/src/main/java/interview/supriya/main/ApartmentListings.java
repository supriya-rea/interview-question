package interview.supriya.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class ApartmentListings {

	public static void main(String[] args) throws SQLException  {
		PersonDatabase db = new PersonDatabase();
		Server server = new Server(8080);
		String webappDirLocation = "src/main/webapp/";
		WebAppContext context = new WebAppContext();
		context.setContextPath("/");
		context.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
		context.setResourceBase(webappDirLocation);
	 
		context.setParentLoaderPriority(true);
	 
	    server.setHandler(context);
	 
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	

	
	
	

}
