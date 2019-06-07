package admin;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.*;

@WebServlet("/displayUsers")
public class DisplayUsers extends HttpServlet {
    @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        File f = new File("C:/myWebProject/tomcat/webapps/EmployeeDetails/files/employees.txt");
        ArrayList<String[]> result = new ArrayList<>();
        String line;
        if (f.exists()) {
        BufferedReader br = new BufferedReader(new FileReader(f));
        while((line = br.readLine()) != null) {
            String[] words = line.split("\t");
            result.add(words);
        }
        br.close();
        }

        PrintWriter out = response.getWriter();

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(0).length; j++) {
                out.print(result.get(i)[j] + "\t");
            }
            out.println();
        }

        request.setAttribute("data", result);

        RequestDispatcher rd = request.getRequestDispatcher("displayusers.jsp");
        rd.forward(request, response);
   }
}