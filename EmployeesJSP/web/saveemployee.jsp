<jsp:useBean class="model.Employee" id="e" />
<%@page import="dao.EmployeeDao" %>
<jsp:setProperty name="e" property="*" />

<%
int status = EmployeeDao.saveEmployee(e);
if(status>0){
    response.sendRedirect("success.jsp");
    }
    else{
      response.sendRedirect("error.jsp");
    }   
%>
