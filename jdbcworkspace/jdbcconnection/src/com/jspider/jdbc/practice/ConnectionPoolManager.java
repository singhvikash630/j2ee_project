package com.jspider.jdbc.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class ConnectionPoolManager 
{
	private final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private final String DB_URL="jdbc:mysql://localhost:3306/class";
	//private final String DB_USER="root";
	//private final String DB_PASSWORD="root";
	private final int POOL_SIZE=5;
	Vector<Connection> pool=new Vector<Connection>();
	static ConnectionPoolManager instance=null;
	private ConnectionPoolManager() throws ClassNotFoundException, SQLException, IOException
	{
		initializeConnectionPool();
	}
	public static ConnectionPoolManager getInstance() throws ClassNotFoundException, SQLException, IOException
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
	public void initializeConnectionPool() throws ClassNotFoundException, SQLException, IOException
	{
		for(int i=0;i<POOL_SIZE;i++)
		{
			Properties pro=new Properties();
			FileInputStream fin=new FileInputStream("D:\\JAVA\\workspace\\jdbcconnection\\src\\com\\jspider\\jdbc\\practice\\db.properties");
			pro.load(fin);
			Class.forName(DRIVER_CLASS);
			Connection con=DriverManager.getConnection(DB_URL,pro);
			if(con!=null)
			{
				System.out.println("initialize the connection,adding into pool");
				pool.add(con);
			}
		}

	}
	public Connection getConnectionFromPool()
	{
		System.out.println("giving the connection to client program from pool");
		System.out.println("before getting the connection,poolsize="+pool.size());
		Connection con=pool.get(0);
		pool.remove(0);
		System.out.println("after getting the connection,poolsize="+pool.size());
		return con;
	}
	public void returnConnectionToPool(Connection con)
	{
		System.out.println("returning the connection back to pool");
		System.out.println("before returning the connection,poolsize="+pool.size());
		pool.add(con);
		System.out.println("after getting the connection,poolsize="+pool.size());
			
	}

}
