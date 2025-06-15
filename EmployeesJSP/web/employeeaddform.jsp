<%@include file="header.jsp" %>
        <div class="container my-3">
            <div class="bg-success text-center">
                <h1 class="jumborton">Employee Form</h1>
            </div>
            <!--    start form-->
            <form action="saveemployee.jsp"  method="post">
                <div class="row">
                    <div class="col-md-6">
                        <label for="exampleInputEmail1" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Full Name">
                    </div>

                    <div class="col-md-6">
                        <label for="exampleInputEmail1" class="form-label">Designation</label>
                        <input type="text" class="form-control" id="email" name="designation" placeholder="Designation">
                    </div>        
                </div>
                <!-- start 2nd row-->
             

                <div class="row">
                    <div class="col-md-6">
                        <label for="exampleInputEmail1" class="form-label">Salary</label>
                        <input type="text" class="form-control" id="contactNo" name="salary" placeholder="salary">
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
