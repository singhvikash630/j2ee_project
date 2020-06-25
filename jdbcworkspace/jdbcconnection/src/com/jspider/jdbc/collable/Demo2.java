package com.jspider.jdbc.collable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jspider.jdbc.preparedstatement.Student;

public class Demo2 
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
			cstmt=con.prepareCall("{call getEmployeeInfo(?)}");
			cstmt.setString(1,args[0]);

			rs=cstmt.executeQuery();
			while(rs.next())
			{
				System.out.println("ename:"+rs.getString("fname")+"lname:"+rs.getString("lname")+"usn:"+rs.getString("sal"));	
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
    create procedure getAllStudentInfo(in registerNo int)
begin
    select * from student where regNo=registerNo;
end $$
delimiter;
call getAllStudentInfo(1);

delimiter $$
    create procedure getEmployeeInfo(in firstName varchar(10))
begin
    select * from student where fname=firstName;
end $$
delimiter;
call getAllStudentInfo('sonu');

*/

