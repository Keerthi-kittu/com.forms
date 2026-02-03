package com.forms;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reginfo")

public class RegisterInformation extends HttpServlet {
//System.out.println("RegisterInformation servlet invoked");

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    System.out.println("RegisterInformation servlet invoked");

        try {
           
            PersonalInfo p = new PersonalInfo();
            AddressInfo a = new AddressInfo();
            EducationInfo e = new EducationInfo();
            System.out.println("Before populate:");
            System.out.println("p = " + p);
            System.out.println("a = " + a);
            System.out.println("e = " + e);


            //Populate using BeanUtils (NO getParameter)
            BeanUtils.populate(p, request.getParameterMap());
            BeanUtils.populate(a, request.getParameterMap());
            BeanUtils.populate(e, request.getParameterMap());
            System.out.println("After populate:");
            System.out.println("Name = " + p.getName());
            System.out.println("Village = " + a.getVillage());
            System.out.println("Degree = " + e.getDegree());

           
            User user = new User();
            user.setPersonalInfo(p);
            user.setAddressInfo(a);
            user.setEducationInfo(e);
            //  Save to DB
            UserDAO dao=new UserDAO();
            dao.saveUser(user);

            response.sendRedirect("success.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
       
       
    }


}

