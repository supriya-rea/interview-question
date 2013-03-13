package interview.supriya.user;

import java.util.List;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UserInputStep {
	
	@Given("^I am on the apartment listing home page$")
	public void I_am_on_the_apartment_listing_home_page() {
	//   driver.get("http://localhost:8080/index.html"); 
	}

	@When("^I enter details |Email|IsAccomodationRequired|Suburb|Price|Date|$")
	public void I_enter_details_Email_IsAccomodationRequired_Suburb_Price_Date(List<InputRecord> arg1) {
		InputRecord record = arg1.get(0);
		
	    	    
	}

	@Then("^I see the message 'Listing created successfully'$")
	public void I_see_the_message_Listing_created_successfully() {
	    // Express the Regexp above with the code you wish you had
	}
	
	class InputRecord {
		public String email;
		public String isAccomodationRequired;
		public String suburb;
		public String price;
		public String date;
	}

}
