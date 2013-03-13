package interview.supriya.user;

import interview.supriya.dao.DAO;
import interview.supriya.dao.MockDAO;
import interview.supriya.manage.PersonManager;

import org.joda.time.LocalDate;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class ApartmentListingStep {
	DAO personDAO = new MockDAO();
	PersonManager manager = new PersonManager(personDAO);
	
	
	Person person = null;
	Listing listing = null;
	@Given("^I am an existing user looking for accomodation$")
	public void I_am_an_existing_user_looking_for_accomodation() {
		person = new Person("supriya.joshi@socgen.com");
		person.isLookingForAccomodation(true);
		
	}
	@When("^I give details for apartment listing$")
	public void I_give_details_for_apartment_listing() {
		String suburb = "Suburb1";
		double price = 100;
		LocalDate date = new LocalDate();
		listing = new Listing(suburb, price, date);
		person.newListing(listing);
		manager.createNewListing(person);
	}

	@Then("^the listing is created.$")
	public void the_listing_is_created() {
		
	}
	@Given("^I am not an existing user$")
	public void I_am_not_an_existing_user() {
		person = new Person("supriya.joshi1@socgen.com");
		assertTrue(!manager.userHasAccount(person));
	}

	@And("^I am looking for an accomodation$")
	public void I_am_looking_for_an_accomodation() {
		person.isLookingForAccomodation(true);
	}
	

	@When("^I give details for an apartment listing$")
	public void I_give_details_for_an_apartment_listing() {
		String suburb = "Suburb1";
		double price = 100;
		LocalDate date = new LocalDate();
		listing = new Listing(suburb, price, date);
		person.newListing(listing);
		
	}

	@Then("^my account is created$")
	public void my_account_is_created() {
		manager.createNewListing(person);
		assertTrue(manager.userHasAccount(person));
	}

	@And("^the listing is also created.$")
	public void the_listed_is_also_created() {
		Person listPerson = manager.getListingsForPerson(person);
		assertEquals(listing, listPerson.getNewListing());
	}


	

}
