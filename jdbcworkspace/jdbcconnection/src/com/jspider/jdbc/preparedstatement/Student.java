package com.jspider.jdbc.preparedstatement;

public class Student
{
	private String ename;
	private String lname;
	private String usn;
	
	public Student(String Ename,String lname,String usn)
	{
	this.ename=Ename;
	this.lname=lname;
	this.usn=usn;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

		
	
}
