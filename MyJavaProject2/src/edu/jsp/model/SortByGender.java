package edu.jsp.model;

import java.util.Comparator;

public class SortByGender implements Comparator<Employees> {

	@Override
	public int compare(Employees o1, Employees o2) {
		
		return o1.getGender().compareTo(o2.getGender());
	}

}
