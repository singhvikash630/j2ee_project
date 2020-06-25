package com.jspider.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/class?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		Statement stmt=con.createStatement();
		int count=stmt.executeUpdate("insert into employee values('aaa','bbb','cccc',20,22222)");
		System.out.println(count+"rows updated");
		
		
		
		
	}

}
