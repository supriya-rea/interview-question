package interview.supriya.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interview.supriya.main.PersonDatabase;
import interview.supriya.user.Listing;
import interview.supriya.user.Person;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PersonDAOTest {
	
	@Test
	public void checkDatabaseCreatedProperly() throws SQLException {
		PersonDatabase db = new PersonDatabase();
		Connection connection = db.getConnection();
		DAO personDAO = new PersonDAO(connection);
		Person person = new Person("test@test.com");
		Listing listing = new Listing("suburb1", 1.0, new LocalDate());
		person.newListing(listing);
		personDAO.createListing(person);
		PreparedStatement stat = connection.prepareStatement("Select * from LISTING where personEmail = ?");
		stat.setString(1, person.getEmail());
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			assertEquals(person.getEmail(),rs.getString(1));
			assertEquals(new Double(person.getNewListing().getPrice()).toString(),new Double(rs.getDouble(2)).toString());
			assertEquals(person.getNewListing().getSuburb(), rs.getString(3));
			assertEquals(person.getNewListing().getDate().toDate().getTime(), rs.getDate(4).getTime());
		}
	}
	

}
