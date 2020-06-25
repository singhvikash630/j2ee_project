package com.jspider.jdbc.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPoolManager 
{
	private final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private final String DB_URL="jdbc:mysql://localhost:3306/class";
	private final String DB_USER="root";
	private final String DB_PASSWORD="root";
	private final int POOL_SIZE=2;
	Vector<Connection> pool=new Vector<Connection>();
	static ConnectionPoolManager instance=null;
	private ConnectionPoolManager() throws ClassNotFoundException, SQLException
	{
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
	public void initializeConnectionPool() throws ClassNotFoundException, SQLException
	{
		for(int i=0;i<POOL_SIZE;i++)
		{
			Class.forName(DRIVER_CLASS);
			Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			if(con!=null)
			{
				System.out.println("initialize the connection,adding into pool");
				pool.add(con);
			}
		}
	}
	public synchronized Connection getConnectionFromPool() throws SQLException
	{
		Connection con=null;
		System.out.println("giving the connection to client program from pool");
		System.out.println("before getting the connection,poolsize="+pool.size());
		if(pool.size()>0)
		{
			con=pool.get(0);
			pool.remove(0);
		}
		else
		{
			con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		}
		System.out.println("after getting the connection,poolsize="+pool.size());
		return con;
	}
	public synchronized void returnConnectionToPool(Connection con)
	{
		System.out.println("returning the connection back to pool");
		System.out.println("before returning the connection,poolsize="+pool.size());
		pool.add(con);
		System.out.println("after getting the connection,poolsize="+pool.size());
	}
}
