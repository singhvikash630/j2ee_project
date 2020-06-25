package com.jspider.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
		System.out.println("Execution start");
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/class?user=root&password=root";
		con=DriverManager.getConnection(url);
		stmt=con.createStatement();
		//pstmt.setString(1,args[0]);
		rs=stmt.executeQuery("select * from student");
		while(rs.next())
		{
			System.out.println("fname:"+rs.getString("fname")+"lname:"+rs.getString("lname")+"usn:"+rs.getString("usn"));
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
    	if(rs!=null)
    	{
    		rs.close();
    	}
    	}
    	catch(SQLException e)
    	{}
    	}
	}
}


