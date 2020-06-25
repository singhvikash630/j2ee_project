package com.jspider.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MysqlJdbc 
 {

    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
    	Connection con=null;
    	Statement stmt=null;
    	ResultSet rs=null;
      
    	Class.forName("com.mysql.jdbc.Driver");
		
    	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","root");
    	
    	stmt=con.createStatement();
    	
    	boolean isExecuted=stmt.execute("create table emp9(ename varchar(10),deptno int(2),sal int(10))");
    	if(isExecuted)
    	{
    		System.out.println("ResultSet has result set object ");
    		rs=stmt.getResultSet();
    	   while(rs.next())
    	   {
    	   String fname=rs.getString("fname");	
    	   String lname=rs.getString("lname");
    	   String usn=rs.getString("usn");
    	   System.out.println("fname:"+fname+"lname:"+lname+"usn:"+usn);
    	   }
    	}
    	else
    	{
    		System.out.println("ResultSet has updated count");
    		int count=stmt.getUpdateCount();
    		System.out.println("table created"+count);
    	}
    }}