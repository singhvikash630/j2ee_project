package com.jspider.jdbc.practice;

public class Employee 
{
	private String ename;
	private String fname;
	private String lname;
	private int deptno;
	private int sal;
	public Employee(String ename,String fname,String lname,int deptno,int sal)
	{
	this.ename=ename;
	this.fname=fname;
	this.lname=lname;
	this.deptno=deptno;
	this.sal=sal;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	
	
	
	

	

}
