package interview.supriya.user;

import java.util.ArrayList;
import java.util.List;

import interview.supriya.dao.DAO;

public class MockDAO implements DAO {
	List<Person> persons = new ArrayList<Person>();
	
	public void createListing(Person person) {
		if(persons.contains(person)) {
			Person addPerson = persons.get(persons.indexOf(person));
			addPerson.newListing(person.getNewListing());
		}
		
	}

	public boolean userHasAccount(Person person) {
		// TODO Auto-generated method stub
		return persons.contains(person);
	}

	public void createUserAndListing(Person person) {
		persons.add(person);
		
	}

}
