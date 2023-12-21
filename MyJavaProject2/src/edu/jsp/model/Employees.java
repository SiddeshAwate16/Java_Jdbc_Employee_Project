package edu.jsp.model;

public class Employees {
	
	private int Id;
	private String name;
	private long number;
	private String gender;
	private double salary;
	
	
public Employees(int Id,String name,long number,String gender,double salary){
	super();
	this.Id=Id;
	this.name=name;
	this.number=number;
	this.gender=gender;
	this.salary=salary;
}
public Employees(){
	super();
}


	public int getId() {
		return Id;
	}
	
	public String getName() {
		return name;
	}
	
	public long getNumber() {
		return number;
	}
	
	public String getGender() {
		return gender;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setId(int Id) {
		this.Id=Id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setNumber(long number) {
		this.number=number;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public void setSalary(double salary) {
		this.salary=salary;
	}
	
	@Override
	public String toString() {
		return("Employee Id \n"+ Id + "Name \n" + name + "Employee Number \n" + number + "Employee Gender \n" + gender + "Employee Salary " + salary);
	}
}
