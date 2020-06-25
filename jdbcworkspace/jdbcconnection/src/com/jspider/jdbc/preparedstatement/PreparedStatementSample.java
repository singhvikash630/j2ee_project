package com.jspider.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreparedStatementSample 
{
	public static void main(String[] args)
	{
		System.out.println("program starts");
		Student studobj1=new Student("vikash","singh","aaaaaaaaa");
		Student studobj2=new Student("vikas","sing","bbbbbbbbbbb");
		Student studobj3=new Student("vika","sing","cccccccccccc");

		ArrayList<Student> list=new ArrayList<Student>();

		list.add(studobj1);
		list.add(studobj2);
		list.add(studobj3);

		processData(list);
		System.out.println("program ends");
	}
	public static void processData(ArrayList<Student> datalist) 
	{
		Connection con=null;
		PreparedStatement stmt=null;
		
		try{
		System.out.println("Execution start");
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/class?user=root&password=root";
		con=DriverManager.getConnection(url);
		stmt=con.prepareStatement("insert into student values(?,?,?)");
		for(Student data:datalist)
		{
			stmt.setString(1,data.getEname());
			//stmt.setInt(1,Integer.parseInt(args[0]));
			stmt.setString(2,data.getLname());
			stmt.setString(3,data.getUsn());
			int count=stmt.executeUpdate();
			System.out.println(count+"rows updated");
		}
		System.out.println("Execution end");
		}
		catch(Exception e){}
    	finally
    	{
    		try{
    	if(con!=null)
    	{
    		con.close();
    	}
    	if(stmt!=null)
    	{
    		stmt.close();
    	}
    	
    	}
    	catch(SQLException e)
    	{}
    	}

	}
}

