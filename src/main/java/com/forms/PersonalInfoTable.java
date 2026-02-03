package com.forms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.sql.*;

public class PersonalInfoTable {
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
    String sql="create table PersonalInfo(id int primary key auto_increment,name varchar(30) not null,email varchar(50) not null,gender varchar(10),pnumber varchar(15) not null)";
    smt.executeUpdate(sql);
    System.out.println("created");
   
}catch(Exception e)
{
e.printStackTrace();
}

}

}



