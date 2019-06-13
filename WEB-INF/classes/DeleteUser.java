package admin;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
    @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
             String id = request.getParameter("id");
            
             try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
                  Statement stmt = conn.createStatement();){
                  System.out.println("here");
                  String str = "DELETE FROM users WHERE id = " + id;
                  stmt.execute(str);
            } catch (Exception e) {
                  System.out.println(e);
            }

             response.sendRedirect("/EmployeeDetails");
   }
}