package com.jspider.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo1 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	System.out.println("Execution start");
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/class?user=root&password=root";
	Connection con=DriverManager.getConnection(url);
	PreparedStatement pstmt=con.prepareStatement("select * from student where fname=?");
	pstmt.setString(1,args[0]);
	ResultSet rs=pstmt.executeQuery();
	while(rs.next())
	{
		System.out.println("fname:"+rs.getString("fname")+"lname:"+rs.getString("lname")+"usn:"+rs.getString("usn"));
	}
	System.out.println("Execution end");
	}
}
