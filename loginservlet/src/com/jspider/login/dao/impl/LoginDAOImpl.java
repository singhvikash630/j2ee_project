package com.jspider.login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.jspider.login.connectionpool.ConnectionPoolManager;
import com.jspider.login.dao.LoginDAO;
import com.jspider.login.pojo.Students;
import com.jspider.login.pojo.Users;

public class LoginDAOImpl implements LoginDAO
{
	public Students authenticateUsers(int regno, String password) throws ClassNotFoundException, SQLException 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		String hql1="from Students s,Users u where u.regno=s.regno and u.regno=:Regno and u.Password=:Password";
		Query query=session.createQuery(hql1);
		query.setInteger("Regno", regno);
		query.setString("Password", password);
	    List<Object[]> results=query.list();
	    Students studentinfo=null;Users user=null;
	    for(Object[] rs:results)
	    {
	    	Students students=(Students)rs[0];
	    	Users users=(Users)rs[1];
	    	
	    	studentinfo=new Students();	    	
		    studentinfo.setRegno(students.getRegno());
	    	studentinfo.setFname(students.getFname());
	    	studentinfo.setMname(students.getMname());
	    	studentinfo.setLname(students.getLname());
	    	studentinfo.setUsers(users);
	    	}
	    session.close();	
		return studentinfo;
		}

	public List<Students> getAllStudentInfo() throws ClassNotFoundException, SQLException
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		String hql1="from Students s,Users u where u.regno=s.regno";
		Query query=session.createQuery(hql1);
		List<Object[]> results=query.list();
	    Students studentinfo=null;Users user=null;
	    ArrayList list=new ArrayList<Students>();
	    for(Object[] rs:results)
	    {
	    	Students students=(Students)rs[0];
	    	Users users=(Users)rs[1];
	    	
	    	studentinfo=new Students();	    	
		    studentinfo.setRegno(students.getRegno());
	    	studentinfo.setFname(students.getFname());
	    	studentinfo.setMname(students.getMname());
	    	studentinfo.setLname(students.getLname());
	    	studentinfo.setUsers(users);
	    	list.add(studentinfo);
	    	}
	    session.close();
	    return list;
		
	}

	public void updateStudentInfo(String fname,String mname,String lname,int oldRegno) throws ClassNotFoundException, SQLException 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Students students=new Students();
		students.setRegno(oldRegno);
		students.setFname(fname);
		students.setMname(mname);
		students.setLname(lname);
		session.update(students);
		session.flush();
		session.close();
	}
	
	public void deleteStudentInfo(int regno) throws ClassNotFoundException,SQLException 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Students students=new Students();
		Users users=new Users();
		students.setRegno(regno);
		users.setRegno(regno);
		students.setUsers(users);
		session.delete(students);
		session.flush();
		session.close();
		
	}
	public void updateUserPassword(int regno,String password) throws ClassNotFoundException, SQLException 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Users users=new Users();
		users.setRegno(regno);
		users.setPassword(password);
		session.update(users);
		session.flush();
		session.close();
	}

	public void addUser(int regno, String fname, String mname, String lname)
			throws ClassNotFoundException, SQLException 
			{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Students students=new Students();
		Users users=new Users();
		students.setRegno(regno);
		students.setFname(fname);
		students.setMname(mname);
		students.setLname(lname);
		users.setRegno(regno);
		students.setUsers(users);
		session.save(students);
		session.flush();
		session.close();
		}


}
