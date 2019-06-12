package admin;

import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.*;

@WebServlet("/displayUsers")
public class DisplayUsers extends HttpServlet {
    @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // File f = new File("C:/myWebProject/tomcat/webapps/EmployeeDetails/files/employees.txt");
        ArrayList<String[]> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
            Statement stmt = conn.createStatement();){
            System.out.println("here");
            String str = "SELECT * FROM users";
            ResultSet rset = stmt.executeQuery(str);

            String[] fields = {"id", "name", "password", "age", "phone", "address", "salary", "role"};
            while (rset.next()) {
                List<String> arr = new ArrayList<>();
                for (int i = 0; i < fields.length; i++) {
                    arr.add(rset.getString(fields[i]));
                }
                String[] ins = (String[])arr.toArray(new String[arr.size()]);
                result.add(ins);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        // String line;
        // if (f.exists()) {
        // BufferedReader br = new BufferedReader(new FileReader(f));
        // while((line = br.readLine()) != null) {
        //     String[] words = line.split("\t");
        //     result.add(words);
        // }
        // br.close();
        // }

        // PrintWriter out = response.getWriter();

        // for (int i = 0; i < result.size(); i++) {
        //     for (int j = 0; j < result.get(0).length; j++) {
        //         out.print(result.get(i)[j] + "\t");
        //     }
        //     out.println();
        // }

        request.setAttribute("data", result);

        RequestDispatcher rd = request.getRequestDispatcher("displayusers.jsp");
        rd.forward(request, response);
   }
}