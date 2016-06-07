package model.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectionPool {
	private static DataSource dataSource;
	
	public static synchronized Connection getConnection() {
		if (dataSource == null) {
			try {
				InitialContext initContext = new InitialContext();
				dataSource = (DataSource)initContext.lookup("jdbc/EnjoyCooking");
			} catch (NamingException e) {
				System.out.println("Cannot find the data source 'jdbc/EnjoyCooking'.");
				e.printStackTrace();
			}
		}
		
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Cannot establish connection");
			return null;
		}
	}
}