package interview.supriya.dao;

import interview.supriya.user.Person;

public interface DAO {

	void createListing(Person person);

	boolean userHasAccount(Person person);

	void createUserAndListing(Person person);

}
