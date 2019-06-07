<%@page import = "admin.DisplayUsers" %>
<%@page import = "java.util.ArrayList" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <title>Display Users</title>
</head>
<body>
    <div class="container">
        <br>
        <center>
            <h1>Display all Users</h1>
            <a href="/EmployeeDetails">Home</a>
        </center>
        <hr>
        <%-- <a href="displayUsers" role="button">Display</a> --%>
        <table class="table">
            <thead class="thead-dark">
                <tr border="10" width="1600" align="center">
                    <th width="200"><b>ID</b></th>
                    <th width="200"><b>Name</b></th>
                    <th width="200"><b>Password</b></th>
                    <th width="200"><b>Age</b></th>
                    <th width="200"><b>Phone</b></th>
                    <th width="200"><b>Address</b></th>
                    <th width="200"><b>Salary</b></th>
                    <th width="200"><b>Role</b></th>
                </tr>
            </thead>
            <tbody>
                <%ArrayList<String[]> std =  (ArrayList<String[]>)request.getAttribute("data"); 
                for(String[] s:std){%> 
                <tr>
                    <% for (int i = 0; i < s.length; i++) { %>
                        <td width="200"><%= s[i] %></td>
                    <% } %>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>