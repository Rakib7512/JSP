<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Employee" %>
<%@page import="dao.EmployeeDao" %>
<%@page import="java.util.*" %>

<%@include file="header.jsp" %>

<%
    String name = request.getParameter("name");
    List<Employee> list = EmployeeDao.searchEmployee(name);
    request.setAttribute("list", list);
%>


<title>Employee Search Result | Employee JSP Project</title>
<div class="container bg-danger my-3 px-0 border border-danger rounded">
    <h3 class="text-center text-light my-2">Employee List</h3>
    <table class="table table-light table-striped my-0">
        <thead>
            <tr>
                <th class="text-center">ID</th>
                <th class="text-center">Name</th>
                <th class="text-center">Designation</th>
                <th class="text-center">Salary</th>
                <th class="text-center">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="e">
                <tr>
                    <td class="text-center">${e.getId()}</td>
                    <td class="text-center">${e.getName()}</td>
                    <td class="text-center">${e.getDesignation()}</td>
                    <td class="text-center">${e.getSalary()}</td>
                    <td class="text-center">
                        <a href="editemployee.jsp?id=${e.getId()}"><button class="btn btn-success btn-sm mx-1">Edit</button></a>
                        <a href="deleteemployee.jsp?id=${e.getId()}"><button class="btn btn-danger btn-sm mx-1" onclick="return confirm('Are you really want to delete ${e.getName()} details?')">Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="footer.jsp" %>