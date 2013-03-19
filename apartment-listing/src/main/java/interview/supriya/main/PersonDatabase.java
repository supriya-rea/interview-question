package interview.supriya.main;


import org.hsqldb.server.Server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonDatabase {
    private String dburl = "jdbc:hsqldb:mem:test";
    private String username="SA";
    private String password = "";
    private String driver = "org.hsqldb.jdbc.JDBCDriver";
    private Connection connection;
    Server hsqlServer;
    public PersonDatabase() throws SQLException {
      if(connection == null || connection.isClosed()) {
    	  createConnection();
      }
      
     
     }
    public void createConnection() {
    	 try {
    			Class.forName(driver);
    			
    			connection = DriverManager.getConnection(dburl,username,password);
    			createDBSchema(connection);
    			
    			
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
    public void createDBSchema(Connection connection) throws SQLException {
   // String sqlListing="drop table LISTING IF EXISTS\r\n;";
    String createListing = "create table IF NOT EXISTS LISTING( "+
"personEmail varchar(128) not null,"+
"price double,"+
"suburb varchar(256),"+
"entryDate date);";
    
	//connection.prepareStatement(sqlListing).execute();
	connection.prepareStatement(createListing).execute();
 
    }

	public void shutDown() {
		hsqlServer.shutdown();
	}
	public Connection getConnection() {
		if(connection == null) {
			throw new IllegalArgumentException("Connection is null");
		}
		return connection;
	}
}
