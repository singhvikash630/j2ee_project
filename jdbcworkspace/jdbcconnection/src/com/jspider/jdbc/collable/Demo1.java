	package com.jspider.jdbc.collable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jspider.jdbc.preparedstatement.Student;

public class Demo1 
{

	public static void main(String[] args)
	{
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/class?user=root&password=root";
			con=DriverManager.getConnection(url);
			cstmt=con.prepareCall("{call getAllEmployeeInfo()}");

			rs=cstmt.executeQuery();
			while(rs.next())
			{
				System.out.println("ename:"+rs.getString("ename")+"lname:"+rs.getString("fname")+"usn:"+rs.getString("sal"));	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				if(con!=null)
				{
					con.close();
				}
				if(cstmt!=null)
				{
					cstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
             e.printStackTrace();
			}
		}


	}
}

/*
 * STORED PROCEDURE
 * 
 delimiter $$
    create procedure getAllStudInfo()
begin
    select * from student where fname='ankesh';
end $$
delimiter;
call getAllStudInfo();
*/

