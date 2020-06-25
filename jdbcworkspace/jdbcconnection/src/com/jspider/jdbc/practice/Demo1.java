package com.jspider.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/class?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		Statement stmt=con.createStatement();
		ResultSet res=stmt.executeQuery("select * from employee");
		while(res.next())
		{
			System.out.println("Ename:"+res.getString("ename")+"Fname:"+res.getString("Fname")+"Lname:"+res.getString("lname")+
					            "Deptno:"+res.getString("deptno")+"sal:"+res.getString("sal"));
		}
		
		
		
	}

}
