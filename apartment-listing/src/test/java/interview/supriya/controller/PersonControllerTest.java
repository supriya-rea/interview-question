package interview.supriya.controller;

import interview.supriya.controller.exception.ApplicationCriticalException;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PersonControllerTest {

	@Test
	public void validatePriceWithAlphaNumeric() {
		PersonController controller = new PersonController();
		assertTrue(!controller.validPrice("A.2"));
		assertTrue(!controller.validPrice("2.2222"));
		assertTrue(!controller.validPrice("2.221"));
		
	}
	@Test
	public void validatePriceWithValidnumber() {
		PersonController controller = new PersonController();
		assertTrue(controller.validPrice("2.2"));
		assertTrue(controller.validPrice("2"));
	}
	
	@Test
	public void validateForErrors() {
		PersonController controller = new PersonController();
		try {
			controller.newListing("", null, "awe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationCriticalException e) {
			assertEquals(3, e.getErrors().size());
			assertEquals("email is not a valid email address", e.getErrors().get(0));
		}
	}
}
