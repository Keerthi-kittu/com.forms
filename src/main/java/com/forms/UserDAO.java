package com.forms;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;


public class UserDAO {
static final String url="jdbc:mysql://localhost:3306/college";
static final String USER="root";
static final String pass="root";




public void saveUser(User user) throws Exception {

Class.forName("com.mysql.cj.jdbc.Driver");

        try {
           
             Connection con = DriverManager.getConnection(url,USER,pass);

           
            con.setAutoCommit(false);

            int pid = insertPersonalInfo(con, user.getPersonalInfo());
            insertAddressInfo(con, user.getAddressInfo(), pid);
            insertEducationInfo(con, user.getEducationInfo(), pid);

           
            con.commit();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Insert PersonalInfo
    public int insertPersonalInfo(Connection con,PersonalInfo p) throws Exception {
    //Class.forName("com.mysql.cj.jdbc.Driver");
        //System.out.println("MySQL Driver Loaded");
        //Connection con = DriverManager.getConnection(url,USER,pass);
        String sql = "INSERT INTO personalinfo(name,email,gender,pnumber) VALUES (?,?,?,?)";

        PreparedStatement ps =
            con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, p.getName());
        ps.setString(2, p.getEmail());
        ps.setString(3, p.getGender());
        ps.setString(4, p.getPnumber());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
   
       
        return rs.getInt(1);
       
    }

    // Insert AddressInfo
    public void insertAddressInfo(Connection con,AddressInfo a, int pid) throws Exception {
    //Class.forName("com.mysql.cj.jdbc.Driver");
        //System.out.println("MySQL Driver Loaded");

        //Connection con =DriverManager.getConnection(url,USER,pass);
        String sql =
            "INSERT INTO addressinfo(village,mandal,district,state,pid) VALUES (?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, a.getVillage());
        ps.setString(2, a.getMandal());
        ps.setString(3, a.getDistrict());
        ps.setString(4, a.getState());
        ps.setInt(5, pid);

        ps.executeUpdate();
        //con.close();
    }

    //Insert EducationInfo
    public void insertEducationInfo(Connection con,EducationInfo e, int pid) throws Exception {
    //Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("com.mysql.cj.jdbc.Driver");
       // System.out.println("MySQL Driver Loaded");System.out.println("MySQL Driver Loaded");

       // Connection con = DriverManager.getConnection(url,USER,pass);
        String sql =
            "INSERT INTO educationalinfo(degree,college,yearofpass,pid) VALUES (?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, e.getDegree());
        ps.setString(2, e.getCollege());
        ps.setString(3, e.getYearofpass());
        ps.setInt(4, pid);

        ps.executeUpdate();
        
    }









public List<User> getAllUsers() throws SQLException, ClassNotFoundException  {
List<User> userList = new ArrayList<>();

   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con = DriverManager.getConnection(url, USER, pass);

   String sql =
       "SELECT * FROM PersonalInfo p " +
       "JOIN AddressInfo a ON p.id = a.pid " +
       "JOIN EducationalInfo e ON p.id = e.pid";

   PreparedStatement ps = con.prepareStatement(sql);
   ResultSet rs = ps.executeQuery();

   while (rs.next()) {

       // PersonalInfo
       PersonalInfo p = new PersonalInfo();
       p.setName(rs.getString("name"));
       p.setEmail(rs.getString("email"));
       p.setGender(rs.getString("gender"));
       p.setPnumber(rs.getString("pnumber"));

       //  AddressInfo
       AddressInfo a = new AddressInfo();
       a.setVillage(rs.getString("village"));
       a.setMandal(rs.getString("mandal"));
       a.setDistrict(rs.getString("district"));
       a.setState(rs.getString("state"));

       // EducationInfo
       EducationInfo e = new EducationInfo();
       e.setDegree(rs.getString("degree"));
       e.setCollege(rs.getString("college"));
       e.setYearofpass(rs.getString("yearofpass"));

       // Wrap into User
       User user = new User();
       user.setPersonalInfo(p);
       user.setAddressInfo(a);
       user.setEducationInfo(e);

       userList.add(user);
   }

   con.close();
   return userList;
}
     


}
