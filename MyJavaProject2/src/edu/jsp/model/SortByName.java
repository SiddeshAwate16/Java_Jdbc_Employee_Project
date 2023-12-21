package edu.jsp.model;

import java.util.Comparator;

public class SortByName implements Comparator<Employees> {

	
	public int compare(Employees o1, Employees o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
