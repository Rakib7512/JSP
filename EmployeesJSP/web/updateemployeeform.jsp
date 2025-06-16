<%@page import="dao.EmployeeDao" %>
<%@page import="model.Employee" %>




<%
String id = request.getParameter("id");

Employee e = EmployeeDao.getEmpById(Integer.parseInt(id));

%>


<%@include file="header.jsp" %>
<div class="container my-3">
    <div class="bg-success text-center">
        <h1 class="jumborton">Employee Update form</h1>
    </div>
    <!--    start form-->
    <form action="updateemployee.jsp"  method="post">
        <input type="hidden" class="form-control" id="name" name="id" value="<%=e.getId()%>" placeholder="ID">
        <div class="row">
            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="<%=e.getName()%>" placeholder="Full Name">
            </div>

            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Designation</label>
                <input type="text" class="form-control" id="designation" name="designation"value="<%=e.getDesignation()%>" placeholder="Designation">
            </div>        
        </div>
        <!-- start 2nd row-->


        <div class="row">
            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Salary</label>
                <input type="text" class="form-control" id="contactNo" name="salary"value="<%=e.getSalary()%>" placeholder="salary">
            </div>

        </div>

        <div class="row mt-3 text-center">
            <div class="col-md-6">
                <button type="submit" class="btn btn-success text-center" >Save</button>

            </div>

            <div class="col-md-6">
                <button type="reset" class="btn btn-danger text-center" >Reset</button>

            </div>
        </div>
    </form>

    <!--end form    -->
</div>

<%@include file="footer.jsp" %>
