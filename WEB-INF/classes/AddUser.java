package admin;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

            String[] fields = {"id", "name", "password", "age", "phone", "address", "salary", "role"};

            String placeField = "(";
            for (int i = 1; i < fields.length; i++) {
                if (i == fields.length - 1)
                    placeField += fields[i];
                else
                    placeField += fields[i] + ",";
            }
            placeField += ")";

            String valueField = "(";
            for (int i = 1; i < fields.length; i++) {
                if (i == fields.length - 1)
                    valueField += "'" + request.getParameter(fields[i]) + "'";
                else
                    valueField += "'" + request.getParameter(fields[i]) + "',";
            }
            valueField += ")";


            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
                Statement stmt = conn.createStatement();){
                System.out.println("here");
                String str = "INSERT INTO users " + placeField + " VALUES " + valueField;
                stmt.execute(str);
            } catch (Exception e) {
                System.out.println(e);
            }

            response.sendRedirect("/EmployeeDetails");
   }
}