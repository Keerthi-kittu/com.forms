package com.forms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EducationalInfoTable {
static final String url="jdbc:mysql://localhost:3306/college?useSSL=false&allowPublicKeyRetrieval=true";
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
	   String sql="CREATE TABLE EducationalInfo (id INT AUTO_INCREMENT PRIMARY KEY,degree VARCHAR(30),college VARCHAR(50),yearofpass INT,pid INT UNIQUE,FOREIGN KEY (pid) REFERENCES PersonalInfo(id))";
	 
	   smt.executeUpdate(sql);
	   System.out.println("created");
	   
	}catch(Exception e)
	{
	e.printStackTrace();
	}


	}

	}
