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
		control.saveEmployees(employee);
		
	}
	
	public void getAllEmployees() {
		System.out.println("ON WHICH BASIS YOU WANT TO SORT ? \n"+
				"1. ID \n"+
				"2. NAME \n"+
				"3. NUMBER \n"+
				"4. GENDER \n"+
				"5. SALARY \n"+
				"6. EXIT \n");
	
	int choice=scanner.nextInt();
	scanner.nextLine();

	switch (choice) {
	case 1:{
		control.sort("ID");
		break;
	}
	case 2:{
		control.sort("NAME");
		break;
	}
	case 3:{
		control.sort("NUMBER");
		break;
	}
	case 4:{
		control.sort("GENDER");
		break;
	}
	case 5:{
		control.sort("SALARY");
	}
	case 6:{
		
		return;
	}
	default:
		System.out.println("something went wrong !!!");
		break;
	}
}
			
		
	
	public void getEmployeeId() {
		System.out.println("Enter employee Id: ");
		int id=scanner.nextInt();
		Employees employee;	
		control.searchEmployee(id);

		}
	
	public void removeEmployee() {
		getAllEmployees();
		
		System.out.println("enter emplooyee id \n");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		control.removeEmployees(id);	

		
	}
	
	public void updateEmployee() {

		control.getAllEmployee();
		
		System.out.println("Enter Employee ID to Upadte Employee :");
		int eId=scanner.nextInt();
		scanner.nextLine();
		
			System.out.println("WHAT YOU WANT TO UPDATE? \n"+
						"1.NAME \n"+
						"2. SALARY \n"+
						"3. NUMBER \n"+
						"4. GENDER \n" +
						"5. UPDATE ALL \n"+
						"6. EXIT \n");
				
					int choice=scanner.nextInt();
					
					switch (choice) {
					case 1: {
						System.out.println("enter employee name \n");
						String name=scanner.next();		
						control.updateName(eId, name);
						System.out.println("Employee Name Updated");
						break;
					}
					case 2: {
						System.out.println("enter employee salary \n");
						double salary=scanner.nextDouble();		
						control.updateSalary(eId, salary);
						System.out.println("Employee salary Updated");
						break;
						
					}
					case 3: {
						System.out.println("enter employee contact \n");
						int number=scanner.nextInt();		
						control.updateNumber(eId, number);
						System.out.println("Employee number"
								+ " Updated");
						break;
					}
					case 4: {
						System.out.println("enter employee contact \n");
						int gender=scanner.nextInt();		
						control.updateNumber(eId, gender);
						System.out.println("Employee gender"
								+ " Updated");
						break;
					}
					case 5: {
						System.out.println("enter employee name \n");
						String name=scanner.next();	
						System.out.println("enter employee SALARY \n");
						int salary=scanner.nextInt();
						System.out.println("enter employee number \n");
						int number=scanner.nextInt();
						System.out.println("enter employee gender \n");
						int gender=scanner.nextInt();
						control.updateAll(eId, name, number, name, salary);
						System.out.println("Employee Name Updated");
						break;
					}
					case 6: {
						
					value=false;
						break;
					}
					default:
						System.out.println("Error");
										
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
			 control.sort("id");
			break;
		case 2:
			control.sort("name");
			break;
		case 3:
			control.sort("number");
			break;
		case 4:
			control.sort("gender");
			break;
		case 5:
			control.sort("salary");
			break;

		default: System.out.println("Invalid Sorting Choice");
			break;
		}
	}
	
	

	
	

}