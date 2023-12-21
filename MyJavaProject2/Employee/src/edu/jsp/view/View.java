package edu.jsp.view;


import java.util.List;
import java.util.Scanner;

import edu.jsp.controller.Controller;
import edu.jsp.model.Employees;

public class View {
	
	static boolean value = !false;
	
	Controller control=new Controller();
	
	Scanner scanner=new Scanner(System.in);
	
public static void main(String[] args) {
	View emp=new View();
	
	while(View.value) {
		 emp.display();
	}
}

	public void display() {
		System.out.println("\n----------Welcome-----------\n" + "Enter your choice\n" + 
								"1.To add employee details\n" + 
								"2.To delete employee details\n" + 
								"3.To get all employees details\n" +
								"4.To get employee by its Id\n" + 
								"5.To update an employee details\n"
								+ "Exits\n"+
									"ENTER ");
	int answer=scanner.nextInt();	
		
	switch (answer) {
	case 1: {
		saveEmployees();
		break;
	}
	case 2:{
		
		break;
	}
	case 3:{
		getAllEmployees();
	}
	
	case 4:{
		getEmployeesId();
	}
	}
	
	}
	
	public void saveEmployees() {
		System.out.println("Enter the Employees Id : \n");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the Employees name : \n");
		String name=scanner.nextLine();
		
		System.out.println("Enter the Employees gender : \n");
		String gender=scanner.nextLine();
		
		System.out.println("Enter the Employees salary : \n");
		double sal=scanner.nextDouble();
		
		System.out.println("Enter the Employees contact : \n");
		long contact=scanner.nextLong();
		
		Employees employees=new Employees(id,name,gender,contact,sal);
		
		if (control.saveEmployees(employees)!=null) {
			System.out.println("Employee Saved\n");
		}else {
			System.out.println("Something went Wrong\n");
		}
	}
	
	public void getEmployeesId() {
		
		System.out.println("Enter the Id you want : ");
		int id=scanner.nextInt();
		
		Employees emp=control.getEmployees(id);
		if (emp!=null) {
			System.out.println("Id :"+emp.getId());
			System.out.println("Name :"+emp.getName());
			System.out.println("Gender :"+emp.getGender());
			System.out.println("Contact :"+emp.getContact());
			System.out.println("Salary :"+emp.getSalary());
		}else {
			System.out.println("Employee not found");
		}
	}

	public void getAllEmployees() {
		List<Employees> emp = control.getEmployees();
		for(Employees i:emp) {
			System.out.println("Employee Id : " + i.getId());
			System.out.println("Employee Name : " + i.getName());
			System.out.println("Employee Gender : " + i.getGender());
			System.out.println("Employee Contact : " + i.getContact());
			System.out.println("Employee Salary : " + i.getSalary());
		}
	}
	
	public void deleteEmployee() {
		System.out.println("Enter Employee Id Ypo want to Delete : \n");
		int id=scanner.nextInt();
		scanner.nextLine();
		

			
		}
	}



	

	
	
	

