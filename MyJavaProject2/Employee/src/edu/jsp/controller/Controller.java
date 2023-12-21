package edu.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import edu.jsp.model.EmployeeNotFoundException;
import edu.jsp.model.Employees;

public class Controller {
	
	private List<Employees> employees=new ArrayList<>();
	
	public Employees saveEmployees(Employees employee) {
		if(employee != null) {
			employees.add(employee);
			return employee;
		}else {
			return null;
		}
	}
	
	public Employees removeEmployees(Employees employee) {
		if(employee != null) {
			for(Employees emp1:employees) {
				if(employee.getId()==emp1.getId()) {
					employees.remove(employee);
					return employee;
				}
			}
			throw new EmployeeNotFoundException();
		}else {
			return null;
		}
	}
	
	public List<Employees> getEmployees(){
		return employees;
	}
	
	public Employees getEmployees(int id) {
		for (Employees employee : employees) {
			if(employee.getId()==id) {
				return employee;
			}
			throw new EmployeeNotFoundException();
		} 
			return null;	
	}
	
	public Employees updateEmployees(int id) {
		for(Employees employee:employees) {
			if(employee.getId()==id) {
				return employee;
			}
			throw new EmployeeNotFoundException();
		}
		return null;
	}
}

	
	

	

