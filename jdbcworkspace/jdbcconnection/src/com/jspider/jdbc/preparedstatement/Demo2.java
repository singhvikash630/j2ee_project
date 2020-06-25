package com.jspider.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		System.out.println("program starts");
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/class?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		PreparedStatement pstmt=con.prepareStatement("select * from student where fname=? and lname=?");
		pstmt.setString(1,args[0]);
		pstmt.setString(2,args[0]);
		ResultSet res=pstmt.executeQuery();
		while(res.next())
		{
			System.out.println("fname:"+res.getString("fname")+"lname:"+res.getString("lname"));
		}
		
		System.out.println("program ends");
		
	}

}
