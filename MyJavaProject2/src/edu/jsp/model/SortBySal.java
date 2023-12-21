package edu.jsp.model;

import java.util.Comparator;

public class SortBySal implements Comparator<Employees> {

	
	public int compare(Employees o1, Employees o2) {
		
		return (int)(o1.getSalary()-o2.getSalary());
	}

}
