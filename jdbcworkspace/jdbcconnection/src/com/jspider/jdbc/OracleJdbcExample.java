package com.jspider.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
import java.math.*; // if needed
import oracle.jdbc.pool.OracleDataSource;
public class OracleJdbcExample 
 {
 public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
    	Connection con=null;
    	Statement stmt=null;
    	ResultSet rs=null;
        Class.forName("oracle.jdbc.OracleDriver");
    	//String URL="jdbc:oracle:thin:scott/tiger";
    	//con= DriverManager.getConnection(URL);
    	con= DriverManager.getConnection("jdbc:oracle:thin://localhost:1158","scott","tiger");
    	stmt=con.createStatement();
    	rs=stmt.executeQuery("select * from emp");
    	while(rs.next())
    	{
    		System.out.println("ename:"+rs.getString("ename")+"empno:"+rs.getString("mgr"));
    		}
    	}
    	}
 
    	
    	