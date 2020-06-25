package com.jspider.login.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPoolManager 
{
	private final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private final String URL="jdbc:mysql://localhost:3306/class";
	private final String USER_NAME="root";
	private final String PASSWORD="root";
	private final int POOL_SIZE=5;
	Vector<Connection> pool=new Vector<Connection>();
	public static  ConnectionPoolManager instance=null;
	private ConnectionPoolManager() throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER_CLASS);
		initializeConnectionPool();
	}
	public static ConnectionPoolManager getInstance() throws ClassNotFoundException, SQLException
	{
	if(instance==null)
	{
		instance=new ConnectionPoolManager();
		return instance;
	}
	else
	{
		return instance;
	}
	
	}
	public void initializeConnectionPool() throws SQLException
	{
		for(int i=0;i<POOL_SIZE;i++)
		{
			Connection con=DriverManager.getConnection(URL,USER_NAME,PASSWORD);	
			if(con!=null)
			{
				System.out.println("add into connection pool");
				pool.add(con);
			}
		}
	}
	public Connection getConnectionFromPool() throws SQLException
	{
		Connection con=null;
		System.out.println("Giving the connection to client program from pool");
		System.out.println("Before giving the connection,size of the pool:"+pool.size());
		if(pool.size()>0)
		{
			con=pool.get(0);
			pool.remove(0);
		}
		else
		{
			con=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		}
		System.out.println("After giving the connection,size of the pool:"+pool.size());
		return con;
		
	}
	public void returnConnectionToPool(Connection con)
	{
		System.out.println("Before returning the connection,size of the pool:"+pool.size());
		pool.add(con);
		System.out.println("After returning the connection,size of the pool:"+pool.size());
	}
	
}