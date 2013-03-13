package interview.supriya.dao;

import java.sql.SQLException;

import interview.supriya.user.Person;

public interface DAO {

	void createListing(Person person) throws SQLException;

	boolean userHasAccount(Person person);

	void createUserAndListing(Person person);

}
