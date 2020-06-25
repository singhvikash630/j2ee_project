package com.jspider.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Demo1 
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
		PreparedStatement pstmt=null;
		
		try{
		System.out.println("Execution start");
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/class?user=root&password=root";
		con=DriverManager.getConnection(url);
		//inform to DB
		con.setAutoCommit(false);
		
		//issue one/more SQL query
		pstmt=con.prepareStatement("insert into student values(?,?,?)");
		
		//clear batch
		pstmt.clearBatch();
		for(int i=0;i<datalist.size();i++)
		{
			/*if(i==2)
			{
				throw new Exception("error simulation!!!");
			}*/
			Student data=datalist.get(i);
			pstmt.setString(1,data.getEname());
			pstmt.setString(2,data.getLname());
			pstmt.setString(3,data.getUsn());
			//adding batch
			System.out.println("adding the"+(i+1)+"statment to batch");
			pstmt.addBatch();
		}
		//execute batch
		int[] counts=pstmt.executeBatch();
		for(int count:counts)
		{
		System.out.println(count+"rows affected");	
		}
		//commit
		System.out.println("no error found!!! commit the transaction");
		con.commit();
		}
		catch(SQLException e)
		{
			try 
			{
				rollBackTransaction(con);
			} catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			try 
			{
				rollBackTransaction(con);
			} catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		catch(Exception e)
		{
			try 
			{
				rollBackTransaction(con);
			} catch (SQLException e1) 
			{
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
    	if(pstmt!=null)
    	{
    		pstmt.close();
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

