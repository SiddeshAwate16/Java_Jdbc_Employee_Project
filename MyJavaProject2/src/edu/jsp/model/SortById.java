package edu.jsp.model;

import java.util.Comparator;

public class SortById implements Comparator<Employees>{

	
	public int compare(Employees o1, Employees o2) {
		return o1.getId()-o2.getId();
	}

}
