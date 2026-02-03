package com.forms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.sql.*;

public class AddressInfoTable {
static final String url="jdbc:mysql://localhost:3306/college";
static final String user="root";
static final String pass="root";
public static void main(String[] args) {
	// TODO Auto-generated method stub

	System.out.println("hi");
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(
	           url,user,pass);
	   Statement smt=con.createStatement();
	   //String sql="drop table AddressInfo";
	   String sql="create table AddressInfo(id int primary key auto_increment,village varchar(30) ,mandal varchar(20) ,district varchar(20) ,state varchar(15) ,pid int unique,foreign key(pid) references PersonalInfo(id))";
	   smt.executeUpdate(sql);
	   System.out.println("created");
	   
	}catch(Exception e)
	{
	e.printStackTrace();
	}
}
}
