package interview.supriya.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("create")
public class PersonController {
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newTodo(@FormParam("email") String email,
	      @FormParam("isForAccomodation") String isForAccomodation,
	      @FormParam("suburb") String suburb,
	      @Context HttpServletResponse servletResponse) throws IOException {
	    
	    
	    servletResponse.sendRedirect("../createListing.html");
	  }
}
