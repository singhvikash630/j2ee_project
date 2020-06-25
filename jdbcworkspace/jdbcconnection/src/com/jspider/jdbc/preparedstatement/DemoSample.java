package com.jspider.jdbc.preparedstatement;

import java.util.ArrayList;

public class DemoSample {

	public static void main(String[] args) 
	{
		Employee empobj1=new Employee("aaaa","nnn","zzz",60,111111111); 
		Employee empobj2=new Employee("bbbb","mmm","yyy",70,222222); 
		Employee empobj3=new Employee("cccc","ooooo","xxxx",90,3333);
		ArrayList<Employee> list=new ArrayList<Employee>();
		list.add(empobj3);
		list.add(empobj2);
		list.add(empobj1);
		processData(list);
		
	}
	public static void processData(ArrayList<Employee> datalist)
	{
		
	}

	

}
