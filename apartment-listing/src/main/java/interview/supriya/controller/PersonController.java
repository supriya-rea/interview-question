package interview.supriya.controller;

import interview.supriya.controller.exception.ApplicationCriticalException;
import interview.supriya.dao.DAO;
import interview.supriya.dao.MockDAO;
import interview.supriya.dao.PersonDAO;
import interview.supriya.main.PersonDatabase;
import interview.supriya.manage.PersonManager;
import interview.supriya.user.Listing;
import interview.supriya.user.Person;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Person newListing(@FormParam("email") String email,
	      @FormParam("suburb") String suburb,
	      @FormParam("price") String price) throws IOException, SQLException {
		 List<String> errors = new ArrayList<String>();
		 if (email == null || email.equals("")) {
			 errors.add("email is not a valid email address");
		 } 
		 if (suburb == null || suburb.equals("")) {
			 errors.add("Suburb must be provided");
		 }
		 if(!validPrice(price)) {
			 errors.add("Price should be valid numeric");
		 }
		 if (!errors.isEmpty()) {
			 throw new ApplicationCriticalException(errors);
		 }
		  

		PersonDatabase database = new PersonDatabase();
		
		double priceVal = 0;
		DAO dao = new PersonDAO(database.getConnection());
		if(validPrice(price)) {
			priceVal = new Double(price);
		}
		PersonManager manager = new PersonManager(dao);
		Person person = new Person(email);
		Listing listing = new Listing(suburb, priceVal, new LocalDate());
		person.newListing(listing);
		manager.createNewListing(person);
		
		 return person;
	
	  }


	public boolean validPrice(String price) {
		if(price.matches("\\d+.\\d{1,2}") || price.matches("\\d+")) {
			return true;
		}
		return false;
	}
}
