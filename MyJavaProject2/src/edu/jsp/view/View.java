package edu.jsp.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import edu.jsp.controller.Controller;
import edu.jsp.model.Employees;
import edu.jsp.model.SortByGender;
import edu.jsp.model.SortById;
import edu.jsp.model.SortByName;
import edu.jsp.model.SortByNumber;
import edu.jsp.model.SortBySal;

public class View {
	
	Scanner scanner = new Scanner(System.in);
	
	Controller control=new Controller();
	
	boolean value=true;
	
	public static void main(String[] args) {
		View view=new View();
		
		while(view.value) {
			view.display();
		}
	}
	
	
	public void display() {
		System.out.println("-----------Welcome---------------\n"+
							"Enter your choice\n"+
							"1.Save Employee \n"+
							"2.Delete Employee \n"+
							"3.Get All Employees Details \n"+
							"4.Get Employee By Id\n"+
							"5.Update Employee details\n"+
							"6.Exits");
		
		int choice=scanner.nextInt();
		
		switch (choice) {
		case 1:
			saveEmployees();
			break;
		case 2:
			removeEmployee();
			break;
		case 3:
			getAllEmployees();
			break;
		case 4:
			getEmployeeId();
			break;
		case 5:
			updateEmployee();
			break;
		case 6:
			value=false;
			System.out.println("Thank You !");
			break;

		default:
			System.out.println("Something Went Wrong !!!");
			break;
		}
	}
	
	public void saveEmployees() {
		System.out.println("Enter Employee Id : ");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter Employee Name : ");
		String name=scanner.next();
		
		System.out.println("Enter Employee Number :  ");
		long number=scanner.nextLong();
		
		System.out.println("Enter Employee Gender : ");
		String gender=scanner.next();
		
		System.out.println("Enter Employee Salary : ");
		double sal=scanner.nextDouble();
		
		Employees employee=new Employees(id,name,number,gender,sal);
		
		if (control.saveEmployees(employee) != null) {
			System.out.println("Employee Saved\n");
		}else {
			System.out.println("Something Went Wrong!!!....");
			
		}
		
	}
	
	public void getAllEmployees() {
		if(control.getAllEmployees().isEmpty()){
			System.out.println("No employees are been registed in");
			return;
		}
		
		sortedEmployees();
		
		for(Employees emp:control.getAllEmployees()) {
			System.out.println("Employee id= \n"+ emp.getId());
			System.out.println("Employee Name= \n"+ emp.getName());
			System.out.println("Employee Salary= \n"+ emp.getSalary());
			System.out.println("Employee Contact= \n"+ emp.getNumber());
			System.out.println("Employee Gender= \n"+ emp.getGender());
			System.out.println("----------------------------------------");
		}
	}
			
		
	
	public void getEmployeeId() {
		System.out.println("Enter the Id you Want : ");
		int id=scanner.nextInt();
		
		Employees emp;
		if((emp=control.searchEmployee(id)) != null) {
			System.out.println("Employee id= \n"+ emp.getId());
			System.out.println("Employee Name= \n"+ emp.getName());
			System.out.println("Employee Salary= \n"+ emp.getSalary());
			System.out.println("Employee Contact= \n"+ emp.getNumber());
			System.out.println("Employee Gender= \n"+ emp.getGender());
			
		}
		else {
			System.out.println("Employee not found");
		}

		}
	
	public void removeEmployee() {
		System.out.println("Enter Employee Id : ");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter Employee Name : ");
		String name=scanner.next();
		
		System.out.println("Enter Employee Number :  ");
		long number=scanner.nextLong();
		
		System.out.println("Enter Employee Gender : ");
		String gender=scanner.next();
		
		System.out.println("Enter Employee Salary : ");
		double sal=scanner.nextDouble();
		scanner.nextLine();
		
		Employees employee=new Employees(id,name,number,gender,sal);
		
		if(control.getAllEmployees() != null) {
			for(Employees emp1:control.getAllEmployees() ) {
				if(employee.getId()==emp1.getId()) {
					if(employee.getName().equalsIgnoreCase(emp1.getName())) {
						if(employee.getNumber()==emp1.getNumber()) {
							if(employee.getGender().equalsIgnoreCase(emp1.getGender())) {
								if(employee.getSalary()==emp1.getSalary()) {
									control.removeEmployees(employee);
									System.out.println("Employee delete");
									return ;
								}
							}
						}
					}	
				}else {
					System.out.println("Employee Not Found!!!");
				}
			}
		}else {
			System.out.println("Something Went Wrong!!!...");
		}
		
	}
	
	public void updateEmployee() {
		
		getAllEmployees();
		
		System.out.println("Enter the Employee Id you want to update : \n");
		int Id=scanner.nextInt();
		
		if(control.getAllEmployees() != null) {
			for(Employees emp1:control.getAllEmployees()) {
				if(Id==emp1.getId()) {
					
					Employees emp=emp1;
					
					System.out.println("Enter What to update : \n"+
										"1.Id : \n"+
										"2.Name : \n"+
										"3. Number : \n"+
										"4.Gender : \n"+
										"5.Salary : \n"+
										"6.Update all");
					
					int choice1=scanner.nextInt();
					scanner.nextLine();
					
					switch (choice1) {
					case 1:{
						System.out.println("Enter New Id\n");
						int Id2=scanner.nextInt();
						 emp.setId(scanner.nextInt());
						break;
					}
					case 2:{
						System.out.println("Enter New Name\n");
						String name=scanner.nextLine();
						emp.setName(scanner.nextLine());
						break;
					}
					case 3:{
						System.out.println("Enter New Number :  ");
						long number=scanner.nextLong();
						emp.setNumber(scanner.nextLong());
						break;
					}
					case 4:{
						System.out.println("Enter New Gender : ");
						String gender=scanner.next();
						emp.setGender(scanner.nextLine());
						break;
					}
					case 5:{
						System.out.println("Enter New Salary : ");
						double sal=scanner.nextDouble();
						emp.setSalary(scanner.nextDouble());
						break;
					}
					case 6:{
						System.out.println("Enter Employee Id : ");
						int id1=scanner.nextInt();
						scanner.nextLine();
						
						System.out.println("Enter Employee Name : ");
						String name=scanner.next();
						
						System.out.println("Enter Employee Number :  ");
						long number=scanner.nextLong();
						
						System.out.println("Enter Employee Gender : ");
						String gender=scanner.next();
						
						System.out.println("Enter Employee Salary : ");
						double sal=scanner.nextDouble();
						scanner.nextLine();
						
						emp.setId(id1);
						emp.setName(name);
						emp.setNumber(number);
						emp.setGender(gender);
						emp.setSalary(sal); 
					}
					System.out.println("Updated");
					}
					
				}else {
					System.out.println("Employee Not Found");
				}
			}
			
		}	
		
	}
	
	public void sortedEmployees() {
		
		System.out.println("SELECT SORTING BASED ON\n"+
							"1.Sort By Id \n"+
							"2.Sort By Name\n"+
							"3.Sort by Number\n"+
							"4.Sort By Gender\n"+
							"5.Sort By Salary");
		
		int choice=scanner.nextInt();
		scanner.nextLine();
		
		switch (choice) {
		case 1:
			 control.sortedEmployees(new SortById());
			break;
		case 2:
			control.sortedEmployees(new SortByName());
			break;
		case 3:
			control.sortedEmployees(new SortByNumber());
			break;
		case 4:
			control.sortedEmployees(new SortByGender());
			break;
		case 5:
			control.sortedEmployees(new SortBySal());
			break;

		default: System.out.println("Invalid Sorting Choice");
			break;
		}
	}
	
	

	
	

}