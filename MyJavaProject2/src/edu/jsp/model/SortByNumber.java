package edu.jsp.model;

import java.util.Comparator;

public class SortByNumber implements Comparator<Employees> {

	
	public int compare(Employees o1, Employees o2) {
		
		return (int)(o1.getNumber()-o2.getNumber());
	}

}
