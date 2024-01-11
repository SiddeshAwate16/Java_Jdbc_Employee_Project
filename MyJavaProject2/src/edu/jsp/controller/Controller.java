package edu.jsp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.jsp.connectionPool.ConnectionPool;
import edu.jsp.model.EmployeeNotFoundException;
import edu.jsp.model.Employees;
import edu.jsp.model.SortByGender;
import edu.jsp.model.SortById;
import edu.jsp.model.SortByName;
import edu.jsp.model.SortByNumber;
import edu.jsp.model.SortBySal;

public class Controller  {
	
	private static List<Employees> employees=new ArrayList<>();
	
		
	public Employees saveEmployees(Employees employee) {
		int id=employee.getId();
		String name=employee.getName();
		long number=employee.getNumber();
		String gender=employee.getGender();
		double salary=employee.getSalary();
		
		//step 3
		Connection connection=ConnectionPool.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement("INSERT INTO employees VALUES(?,?,?,?,?)");
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setLong(3, number);
			statement.setString(4, gender);
			statement.setDouble(5, salary);
		
		//step 4
		int result=statement.executeUpdate();
		System.out.println("Employee Saved ");
		System.out.println(result+"Row Affected");
		
		statement.close();
		ConnectionPool.receiveConnection(connection);
		return employee;
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public Employees removeEmployees(int id ) {
		
		Connection connection=ConnectionPool.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement("DELETE FROM employees WHERE id=?");
			statement.setInt(1, id);
			
			int result=statement.executeUpdate();
			System.out.println("Result" + result);
			
			if(result>0) {
				System.out.println("Employee Deleted");
			}else {
				System.out.println("Something Went Wrong");
			}
			
			statement.close();
			ConnectionPool.receiveConnection(connection);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			return null;
		}
		
	
	
	public List<Employees> getAllEmployees(String colName){
		//Step 3	
				Connection connection=ConnectionPool.getConnection();
				try {
					PreparedStatement statement=connection.prepareStatement("SELECT * FROM employees ORDER BY "+ colName);
					
				ResultSet result=statement.executeQuery();
				while(result.next()) {
					System.out.println("Employee Id" + result.getInt(1));
					System.out.println("Employee Name" + result.getString(2));
					System.out.println("Employee Number" + result.getLong(3));
					System.out.println("Employee Gender" + result.getString(4));
					System.out.println("Employee Salary" + result.getDouble(5));	
				}
				
				statement.close();
				ConnectionPool.receiveConnection(connection);
				return employees;
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
	}
	public List<Employees> getAllEmployee(){
		//Step 3	
		Connection connection=ConnectionPool.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement("SELECT * FROM employees");
			
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				System.out.println("Employee Id" + result.getInt(1));
				System.out.println("Employee Name" + result.getString(2));
				System.out.println("Employee Number" + result.getLong(3));
				System.out.println("Employee Gender" + result.getString(4));
				System.out.println("Employee Salary" + result.getDouble(5));	
			}
			
			statement.close();
			ConnectionPool.receiveConnection(connection);
			return employees;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Employees searchEmployee(int id) {
		
		//Step 3
		Connection connection=ConnectionPool.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement("SELECT id FROM employees WHERE id=?");
			statement.setInt(1, id);
			
		//Step 4	
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				System.out.println("Employee Id" + result.getInt(1));
				System.out.println("Employee Name" + result.getString(2));
				System.out.println("Employee Number" + result.getLong(3));
				System.out.println("Employee Gender" + result.getString(4));
				System.out.println("Employee Salary" + result.getDouble(5));
			}
			
			statement.close();
			ConnectionPool.receiveConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
}
	
	public Employees updateAll(int id,String name,long number,String gender,double salary) {
		
		Connection connection=ConnectionPool.getConnection();
		
		try {
			PreparedStatement statement=connection.prepareStatement("UPDATE employees SET id=?,name=?,number=?,gender=?,salary=?");
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setLong(3, number);
			statement.setString(4, gender);
			statement.setDouble(5, salary);
			
			int result=statement.executeUpdate();
			
			if(result>0) {
				System.out.println("Employee Updated");
				System.out.println("Row Affected");
			}
			
			statement.close();
			ConnectionPool.receiveConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
public Employees updateName(int id,String name) {
		
		Connection connection=ConnectionPool.getConnection();
		
		try {
			PreparedStatement statement=connection.prepareStatement("UPDATE employees SET name=? WHERE id=?");
			statement.setString(1, name);
			statement.setInt(2, id);
			
			int result=statement.executeUpdate();
			
			if(result>0) {
				System.out.println("Employee Name Updated");
				System.out.println("Row Affected");
			}
			
			statement.close();
			ConnectionPool.receiveConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

public Employees updateNumber(int id,long number) {
	
	Connection connection=ConnectionPool.getConnection();
	
	try {
		PreparedStatement statement=connection.prepareStatement("UPDATE employees SET number=? WHERE id=?");
		statement.setLong(1, number);
		statement.setInt(2, id);
		
		int result=statement.executeUpdate();
		
		if(result>0) {
			System.out.println("Employee Number Updated");
			System.out.println("Row Affected");
		}
		
		statement.close();
		ConnectionPool.receiveConnection(connection);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public Employees updateGender(int id,String gender) {
	
	Connection connection=ConnectionPool.getConnection();
	
	try {
		PreparedStatement statement=connection.prepareStatement("UPDATE employees SET gender=? WHERE id=?");
		statement.setString(1, gender);
		statement.setInt(2, id);
		
		int result=statement.executeUpdate();
		
		if(result>0) {
			System.out.println("Employee Gender Updated");
			System.out.println("Row Affected");
		}
		statement.close();
		ConnectionPool.receiveConnection(connection);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public Employees updateSalary(int id,double salary) {
	
	Connection connection=ConnectionPool.getConnection();
	
	try {
		PreparedStatement statement=connection.prepareStatement("UPDATE employees SET salary=? WHERE id=?");
		statement.setDouble(1, salary);
		statement.setInt(2, id);
		
		int result=statement.executeUpdate();
		
		if(result>0) {
			System.out.println("Employee Salary Updated");
			System.out.println("Row Affected");
		}
		
		statement.close();
		ConnectionPool.receiveConnection(connection);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public void sort(String colName) {
	Connection connection=ConnectionPool.getConnection();
	try {
	PreparedStatement statement=connection.prepareStatement("SELECT * FROM employees ORDER BY "+ colName);
	
	ResultSet result=statement.executeQuery();
	while(result.next()) {
		System.out.println("Employee Id" + result.getInt(1));
		System.out.println("Employee Name" + result.getString(2));
		System.out.println("Employee Number" + result.getLong(3));
		System.out.println("Employee Gender" + result.getString(4));
		System.out.println("Employee Salary" + result.getDouble(5));
		System.out.println("--------------------------------------");
	}
	
	statement.close();
	ConnectionPool.receiveConnection(connection);
	
	} catch (SQLException e) {
	e.printStackTrace();
	}

}
}
