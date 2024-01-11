package edu.jsp.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	
	private static final int POOL_SIZE=5;
	
	private static String dburl="jdbc:postgresql://localhost:5432/employees";
	private static String user="postgres";
	private static String password="root";
	
	private static List<Connection> connections=new ArrayList<>();
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			
			for (int i = 0; i < POOL_SIZE; i++) {
				connections.add(createConnection());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection createConnection() {
		
		try {
			Connection 	connection=DriverManager.getConnection(dburl,user,password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public static void receiveConnection(Connection connection) {
		if(connections.size()<POOL_SIZE) {
			connections.add(connection);
		}else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		if(!connections.isEmpty()) {
			return connections.remove(0);
		}else {
			return createConnection();
		}
		
	}

}
