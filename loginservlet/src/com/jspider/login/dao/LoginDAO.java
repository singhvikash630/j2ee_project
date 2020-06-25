package com.jspider.login.dao;


import java.sql.SQLException;
import java.util.List;

import com.jspider.login.pojo.Students;

public interface LoginDAO 
{
	public Students authenticateUsers(int regno,String password)throws ClassNotFoundException, SQLException ;
	List<Students> getAllStudentInfo()throws ClassNotFoundException, SQLException;
	public void updateStudentInfo(String fname,String mname,String lname,int oldRegno) throws ClassNotFoundException, SQLException;
    public void deleteStudentInfo(int regno) throws ClassNotFoundException, SQLException; 
    public void updateUserPassword(int regno,String Password) throws ClassNotFoundException, SQLException;	
    public void addUser(int regno,String fname,String mname,String lname) throws ClassNotFoundException, SQLException;	

}
