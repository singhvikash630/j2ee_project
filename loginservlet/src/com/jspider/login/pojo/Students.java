package com.jspider.login.pojo;

import java.util.HashSet;
import java.util.Set;

public class Students
{
	private int regno;
	private String fname;
	private String mname;
	//private String mname="not available";
	private String lname;
	private Users users;
	public Students()
	{
	//constructor	
	}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
