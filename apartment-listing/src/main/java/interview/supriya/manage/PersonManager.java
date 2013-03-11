package interview.supriya.manage;

import interview.supriya.dao.DAO;
import interview.supriya.user.Person;

public class PersonManager {
	private DAO personDAO;

	public PersonManager(DAO personDAO) {
		this.personDAO = personDAO;
	}

	public void createNewListing(Person person) {
		if(!personDAO.userHasAccount(person)) {
			personDAO.createUserAndListing(person);
		} else {
			personDAO.createListing(person);
		}
		// TODO Auto-generated method stub
		
	}

	public Person getListingsForPerson(Person person) {
		// TODO Auto-generated method stub
		return person;
	}

	public boolean userHasAccount(Person person) {
		// TODO Auto-generated method stub
		return personDAO.userHasAccount(person);
	}

}
