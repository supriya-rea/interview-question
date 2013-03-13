package interview.supriya.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import interview.supriya.user.Person; 

public class PersonDAO implements DAO {
	private Connection connection;

	public PersonDAO(Connection conn) {
		this.connection = conn;
	}
	public void createListing(Person person) throws SQLException {
		String sql = "Insert into LISTING values(?,?,?,?)";
		PreparedStatement stat = connection.prepareStatement(sql);
		stat.setString(1,person.getEmail());
		stat.setDouble(2, person.getNewListing().getPrice());
		stat.setString(3, person.getNewListing().getSuburb());
		java.sql.Date sqlDate = new Date(person.getNewListing().getDate().toDate().getTime());
		stat.setDate(4,sqlDate );
		stat.execute();
	}

	public boolean userHasAccount(Person person){
		return true;
		
	}

	public void createUserAndListing(Person person) {
		
	}


}
