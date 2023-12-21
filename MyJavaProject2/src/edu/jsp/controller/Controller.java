package edu.jsp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.jsp.model.EmployeeNotFoundException;
import edu.jsp.model.Employees;
import edu.jsp.model.SortByGender;
import edu.jsp.model.SortById;
import edu.jsp.model.SortByName;
import edu.jsp.model.SortByNumber;
import edu.jsp.model.SortBySal;

public class Controller  {
	
	private List<Employees> employees=new ArrayList<>();
		
	public Employees saveEmployees(Employees employee) {
		if(employee != null) {
			employees.add(employee);
			return employee;
		}else {
			return null;
		}
	}
	
	public Employees removeEmployees(Employees employee ) {
		if(employee != null) {
			for(Employees employee1:employees) {
				if(employee.getId()==employee1.getId()) {
					employees.remove(employee);
					return employee;
				}
			}
			throw new EmployeeNotFoundException();
		}else {
			return null;
		}
		
	}
	
	public List<Employees> getAllEmployees(){
		return employees;
		
	}
	
	public Employees searchEmployee(int id) {
		if(employees !=null) {
		for(Employees employee:employees) {
			if(employee.getId()==id) {
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}else {
		return null;
	}
}


public List<Employees> sortedEmployees(Comparator<Employees> comparator){
	
	if(comparator instanceof SortById) {
		Collections.sort(employees, comparator);
		return employees;	
	}
	else if(comparator instanceof SortByName) {
		Collections.sort(employees, comparator);
		return employees;	
	}
	else if(comparator instanceof SortByNumber) {
		Collections.sort(employees, comparator);
		return employees;	
	}
	else if(comparator instanceof SortByGender) {
		Collections.sort(employees, comparator);
		return employees;	
	}
	else if(comparator instanceof SortBySal) {
		Collections.sort(employees, comparator);
		return employees;	
	}else {
		return employees;
	}
}





}
