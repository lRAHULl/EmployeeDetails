package admin;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
    @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
             String line;
             File f = new File("C:/myWebProject/tomcat/webapps/EmployeeDetails/files/employees.txt");
             String id = request.getParameter("id");
             boolean flag = false;
             String oldText = "";
             if (f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                while((line = br.readLine()) != null) {
                   String[] words = line.split("\t");
                   if (id.equals(words[0])) {
                        flag = true;   
                        continue;
                   } else {
                        oldText += line + "\r\n";
                   }
                }
                br.close();
             }
             
             if (flag) {
                 FileWriter fw = new FileWriter(f);
                 fw.write(oldText);
                 fw.close();
             }
             response.sendRedirect("/EmployeeDetails");
   }
}