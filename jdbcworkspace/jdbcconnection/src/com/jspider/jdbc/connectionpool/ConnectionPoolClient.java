package com.jspider.jdbc.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolClient {

	public static void main(String[] args)
	{
		Connection con1=null;
		Connection con2=null;
		Connection con3=null;
		Statement stmt=null;
		ResultSet rs=null;
		ConnectionPoolManager pool=null;
	try
		{
			pool=ConnectionPoolManager.getInstance();
			con1=pool.getConnectionFromPool();
			stmt=con1.createStatement();
			rs=stmt.executeQuery("select * from student");
			while(rs.next())
			{
				System.out.println("fname:"+rs.getString("fname")+"lname:"+rs.getString("lname")+"usn:"+rs.getString("usn"));	
			}
			con2=pool.getConnectionFromPool();
			con3=pool.getConnectionFromPool();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			try
			{
				System.out.println("return the first connection to pool");
				pool.returnConnectionToPool(con1);
				System.out.println("return the second connection to pool");
				pool.returnConnectionToPool(con2);
				System.out.println("return the third connection to pool");
				pool.returnConnectionToPool(con3);
				if(stmt!=null)
				{
					stmt.close();

				}
				if(rs!=null)
				{
					rs.close();
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}


