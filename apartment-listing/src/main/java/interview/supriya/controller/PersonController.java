package interview.supriya.controller;

import interview.supriya.dao.DAO;
import interview.supriya.dao.MockDAO;
import interview.supriya.manage.PersonManager;
import interview.supriya.user.Listing;
import interview.supriya.user.Person;

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

import org.joda.time.LocalDate;

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
	      @FormParam("accoCheck") String isForAccomodation,
	      @FormParam("suburb") String suburb,
	      @Context HttpServletResponse servletResponse) throws IOException {
		DAO dao = new MockDAO();
		PersonManager manager = new PersonManager(dao);
		Person person = new Person(email);
		Listing listing = new Listing(suburb, 0, new LocalDate());
		person.newListing(listing);
		manager.createNewListing(person);
		
	
		
	    
	    servletResponse.sendRedirect("../createListing.html");
	  }
}
