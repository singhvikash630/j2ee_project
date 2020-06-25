package com.jspider.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Transaction 
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
		//inform to DB
		con.setAutoCommit(false);
		
		//issue one/more SQL query
		stmt=con.prepareStatement("insert into student values(?,?,?)");
		for(int i=0;i<datalist.size();i++)
		{
			/*if(i==2)
			{
				throw new Exception("error simulation!!!");
			}*/
			Student data=datalist.get(i);
			stmt.setString(1,data.getEname());
			stmt.setString(2,data.getLname());
			stmt.setString(3,data.getUsn());
			int count=stmt.executeUpdate();
			System.out.println(count+"rows updated");
		}
		//commit
		System.out.println("no error found!!! commit the transaction");
		con.commit();
		}
		catch(SQLException e)
		{
			try {
				rollBackTransaction(con);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			try {
				rollBackTransaction(con);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		catch(Exception e)
		{
			try {
				rollBackTransaction(con);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
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
    	{
    		e.printStackTrace();
    	}
    	}
    }
	public static void rollBackTransaction(Connection con) throws SQLException
	{
		//Error!!!Rollback
		System.out.println("Error occurred"+"Rolling back the transcation");
		con.rollback();
	}
}

