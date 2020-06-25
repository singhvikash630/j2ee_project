package com.jspider.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.Driver;
public class JdbcDemo 
 {
	static Statement stmt=null;
	static ResultSet rs=null;
	static Connection con=null;

    public static void main(String args[])
    {
    	try{
    	//two ways to load Driver
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	/*Driver driver=new Driver();
    	DriverManager.registerDriver(driver);*/
    	
    	/*Three ways to getConnection method
    	 
    	 String URL="jdbc:mysql://localhost:3306/class?user=root&password=root";
    	Connection con=DriverManager.getConnection(URL);*/
    	
    	/*String URL="jdbc:mysql://localhost:3306/class";
    	String userId="root";
    	String password="root";
    	Connection con=DriverManager.getConnection(URL,userId,password);*/
    	
    	String URL="jdbc:mysql://localhost:3306/class";
    	Properties pro=new Properties();
    	FileInputStream fin=new FileInputStream("D:\\JAVA\\workspace\\jdbcconnection\\db.properties"); 
    	pro.load(fin);
    	con=DriverManager.getConnection(URL,pro);
    	
    	/*//metadata
    	DatabaseMetaData metadata=(DatabaseMetaData)con.getMetaData();
    	System.out.println("Current Database:"+metadata.getDatabaseProductName());
    	System.out.println("Database version name:"+metadata.getDatabaseProductVersion());
    	System.out.println("URL:"+metadata.getURL());
    	*/
    	//use of methods of JDBC statement
    	stmt=con.createStatement();
    	int count=stmt.executeUpdate("create table emp3(ename varchar(10),deptno int(2),sal int(10))");
    	System.out.println(count+"rows updated");
    	
    	/*boolean isExecuted=stmt.execute("create table emp1(ename varchar(10),deptno int(2),sal int(10))");
    	boolean isExecuted1=stmt.execute("insert into emp values('vikash',10,20000)");
    	boolean isExecuted=stmt.execute("select *from student");
    	if(isExecuted)
    	{
    		System.out.println("ResultSet has ResultSet object");
    		rs=stmt.getResultSet();
    		while(rs.next())	
    		{
    			System.out.println("fame:"+rs.getString("fname")+"lname:"+rs.getString("lname")+"usn:"+rs.getString("usn"));
    		}
    	}
    	else
    	{
    		System.out.println("ResultSet has updated count");
    		int count1=stmt.getUpdateCount();
    		System.out.println(count1+"table created");
    	}
    	*/}
    	
    	
    	/*rs=stmt.executeQuery("select * from student");
    	
    	while(rs.next())
    	{
    	System.out.println("fname:"+rs.getString("fname")+"lname:"+rs.getString("lname")+"usn:"+rs.getString("usn"));	
    	}
    	}*/
    	catch(Exception e)
    	{
    		
    	}
    	finally
    	{
    		try
    		{
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
    	{
    		
    	}
    	}
    }
 }