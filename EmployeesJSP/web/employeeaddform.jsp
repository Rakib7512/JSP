<%-- 
    Document   : employeeaddform
    Created on : Jun 15, 2025, 2:39:35 AM
    Author     : RJ Power
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employee Form</h1>
        <form action="saveemployee.jsp" method="post">
                 Name        :<input type="text" name="name"><br><br>
                 Designation :<input type="text" name="designation"><br><br>
                 Salary      :<input type="text" name="salary"><br>

            <<input type="Submit" value="Save">

        </form>

    </body>
</html>
