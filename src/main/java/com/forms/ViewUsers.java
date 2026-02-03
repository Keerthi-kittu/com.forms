package com.forms;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewUsers")
public class ViewUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
System.out.println("view invoked");
        try {
            UserDAO dao = new UserDAO();
            List<User> users = dao.getAllUsers();
            //List<User> users = dao.getAllUsers();

            System.out.println("Users list size = " + users.size());

            request.setAttribute("users", users);
            RequestDispatcher rd = request.getRequestDispatcher("viewUsers.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



