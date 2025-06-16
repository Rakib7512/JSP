<%@taglib prefix="con" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Employee" %>
<%@page import="dao.EmployeeDao" %>
<%@page import="java.util.*" %>



<%@include  file="header.jsp" %>

<%
List<Employee>list=EmployeeDao.getAllEmployee();
request.setAttribute("list",list);

%>
<div class="container">
    <h1 class="text-center">All Employee</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>    
                <th>Name</th>    
                <th>Designation</th>    
                <th>Salary</th>       
            </tr>
        </thead>
        <tbody>
            <con:forEach items="${list}" var="e">
                <tr>

                    <td>${e.getId()}</td>
                    <td>${e.getName()}</td>
                    <td>${e.getDesignation()}</td>
                    <td>${e.getSalary()}</td>

                    <td>
                        <a href="updateemployeeform.jsp?id=${e.getId()}"><button type="Submit" class="btn btn-primary">Edit</button></a>
                        <a href="deleteemployee.jsp?id=${e.getId()}"><button type="Submit" class="btn btn-warning">Delate</button></a>


                    </td>
                </tr>

            </con:forEach>
        </tbody>
    </table>
</div>

<%@include  file="footer.jsp" %>
