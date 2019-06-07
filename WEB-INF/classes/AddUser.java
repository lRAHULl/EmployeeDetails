package admin;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
             String line;
             int id = 0;
             File f = new File("C:/myWebProject/tomcat/webapps/EmployeeDetails/files/employees.txt");
             if (f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                while((line = br.readLine()) != null) {
                   String[] words = line.split("\t");
                   int newId = Integer.parseInt(words[0]);
                   if (newId > id) {
                       id = newId;
                   }
                }
                br.close();
             }
             id++;

            String[] fields = {"id", "name", "password", "age", "phone", "address", "salary", "role"};
            HashMap<String, String> map = new HashMap<>();

            map.put(fields[0], Integer.toString(id));
            for (int i = 1; i < fields.length; i++) {
                map.put(fields[i], request.getParameter(fields[i]));
            }
            
            PrintWriter pw = new PrintWriter(new FileWriter(f, true));

            for (int i = 0; i < fields.length; i++) {
                if (i == fields.length - 1)
                    pw.println(map.get(fields[i]));
                else
                    pw.print(map.get(fields[i]) + "\t");
            }
            pw.close();

            response.sendRedirect("/EmployeeDetails");
   }
}