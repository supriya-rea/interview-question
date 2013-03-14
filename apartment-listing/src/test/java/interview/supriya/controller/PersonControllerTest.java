package interview.supriya.controller;

import interview.supriya.controller.exception.ApplicationCriticalException;
import interview.supriya.main.PersonDatabase;
import interview.supriya.user.Person;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	@Test
	public void createNewListing() throws IOException, SQLException {
		PersonController controller = new PersonController();
		
			Person person = controller.newListing("test@test.com", "Koramangala", "110");
			PersonDatabase database = new PersonDatabase();
			Connection con = database.getConnection();
			PreparedStatement stat = con.prepareStatement("Select * from LISTING where personEmail = ?");
					stat.setString(1,"test@test.com");
					ResultSet rs = stat.executeQuery();
					while(rs.next()) {
						assertEquals(person.getEmail(),rs.getString(1));
						assertEquals(new Double(person.getNewListing().getPrice()).toString(),new Double(rs.getDouble(2)).toString());
						assertEquals(person.getNewListing().getSuburb(), rs.getString(3));
						assertEquals(person.getNewListing().getDate().toDate().getTime(), rs.getDate(4).getTime());
					}
	}
}
