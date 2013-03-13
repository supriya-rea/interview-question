package interview.supriya.user;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UserInputStep {
	WebDriver driver = null;
	
	@Before
	public void setUp() {
	 System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	 driver = new FirefoxDriver();
	}
	
	@Given("^I am on the apartment listing home page$")
	public void I_am_on_the_apartment_listing_home_page() {
		setUp();
	   driver.get("http://localhost:8080/index.html"); 
	}

	@When("^I enter all the required details$")
	public void enterDetails() {
		WebElement ele = driver.findElement(By.id("email"));
		ele.sendKeys("supriya.joshi@gmail.com");
		Select selectSuburbs = new Select(driver.findElement(By.id("suburbs")));
		selectSuburbs.selectByValue("Koramangala");
	    driver.findElement(By.id("price")).sendKeys("11");
	}
	
	@When("^I enter all the details except email$")
	public void  enterAlldetailsExceptEmail() {
		WebElement ele = driver.findElement(By.id("email"));
		ele.sendKeys("");
		Select selectSuburbs = new Select(driver.findElement(By.id("suburbs")));
		selectSuburbs.selectByValue("Koramangala");
		
	    driver.findElement(By.id("price")).sendKeys("11");
	   	
	}
	
	@When("^I enter all the details except selecting a suburb$")
	public void forgetSuburb() {
		WebElement ele = driver.findElement(By.id("email"));
		ele.sendKeys("supriya.joshi@gmail.com");
		driver.findElement(By.id("price")).sendKeys("11");
	}
	
	@When("^I enter all the details except the price$")
	public void forgetPrice() {
		WebElement ele = driver.findElement(By.id("email"));
		ele.sendKeys("supriya.joshi@gmail.com");
		Select selectSuburbs = new Select(driver.findElement(By.id("suburbs")));
		selectSuburbs.selectByValue("Koramangala");
	}
	@And("^click 'Create Listing'$")
	public void clickListing() {
		 driver.findElement(By.id("create-button")).click();
	}
	@Then("^I see an error message for email (.*?)$")
	public void testForEmailerror(String error) {
		assertEquals(error, driver.findElement(By.cssSelector("span#email_span")).getText());
		driver.quit();
	}
	@Then("^I see an error message for suburb (.*?)$")
	public void testSuburbError(String error) {
		assertEquals(error, driver.findElement(By.cssSelector("span#suburbs_span")).getText());
		driver.quit();
	}
	@Then("^I see an error message for price (.*?)$")
	public void testPriceError(String error) {
		assertEquals(error, driver.findElement(By.cssSelector("span#price_span")).getText());
		driver.quit();
	}
	@Then("^I see the message 'Listing created successfully'$")
	public void I_see_the_message_Listing_created_successfully() {
		assertEquals(1, driver.findElement(By.id("my-table")).findElements(By.tagName("tr")).size());
	    driver.quit();
	}
	
	@After
	public void tearDown() {	
		 driver.quit();
	}
	
	

}
