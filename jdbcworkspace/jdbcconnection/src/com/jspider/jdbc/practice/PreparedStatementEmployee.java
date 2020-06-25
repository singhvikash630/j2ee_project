package com.jspider.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class PreparedStatementEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		System.out.println("execution starts");
		Employee empobj1=new Employee("aaaaa","bbb","ccc",10,11111111); 
		Employee empobj2=new Employee("bbbb","cccc","dddd",22,2222222); 
		Employee empobj3=new Employee("ccccc","fffffff","ggggg",33,3333333);
		ArrayList<Employee> list=new ArrayList<Employee>();
		list.add(empobj1);
		list.add(empobj2);
		list.add(empobj3);
		processData(list);
		
		System.out.println("execution ends");
		
	}
	public static void processData(ArrayList<Employee> datalist) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/class?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		for(Employee data:datalist)
		{
		pstmt.setString(1,data.getEname());
		pstmt.setString(2,data.getFname());
		pstmt.setString(3,data.getLname());
		pstmt.setInt(4,data.getDeptno());
		pstmt.setInt(5,data.getSal());
		int count=pstmt.executeUpdate();
		System.out.println(count+"rows updated");
		}
	}

}
