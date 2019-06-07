package admin;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/editUser")
public class EditUser extends HttpServlet {
    @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException, NullPointerException {
            HashMap<String, String> newMap = new HashMap<>();


             String line;
             File f = new File("C:/myWebProject/tomcat/webapps/EmployeeDetails/files/employees.txt");
             String id = request.getParameter("id");
             boolean flag = false;
             String oldText = "";
             String[] fields = {"id", "name", "password", "age", "phone", "address", "salary", "role"};
             HashMap<String, String> oldMap = new HashMap<>();

             if (f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                while((line = br.readLine()) != null) {
                   String[] words = line.split("\t");
                   if (id.equals(words[0])) {
                        if (words.length == fields.length) {
                            flag = true;
                            for (int i = 0; i < fields.length; i++) 
                                oldMap.put(fields[i], words[i]);
                        }
                        break;
                   }
                }
                br.close();
             }

             for (int i = 0; i < fields.length; i++) {
                String temp = request.getParameter(fields[i]);
                if (temp.isEmpty())
                    newMap.put(fields[i], oldMap.get(fields[i]));
                else 
                    newMap.put(fields[i], temp);
            }
             
             if (flag) {
                BufferedReader br1 = new BufferedReader(new FileReader(f));
                while((line = br1.readLine()) != null) {
                   String[] words = line.split("\t");
                   if (id.equals(words[0])) {
                        for (int i = 0; i < fields.length; i++) 
                            if (i == fields.length - 1) 
                                oldText += newMap.get(fields[i]) + "\n";
                            else
                                oldText += newMap.get(fields[i]) + "\t";
                   } else {
                        oldText += line + "\r\n";
                    }
                }
                br1.close();

                FileWriter fw = new FileWriter(f);
                fw.write(oldText);
                fw.close();
             }
             response.sendRedirect("/EmployeeDetails");
   }
}