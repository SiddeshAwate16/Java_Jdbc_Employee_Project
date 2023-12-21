package edu.jsp.model;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException() {
		super("Employee don't Exist");
	}

}
