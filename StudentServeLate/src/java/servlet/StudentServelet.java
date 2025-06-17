
package servlet;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Student;

@WebServlet("/StuServlet")
public class StudentServelet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String action= request.getParameter("action");
     if("add".equals(request)){
         Student student=new Student();
         student.setName(request.getParameter("name"));
         student.setName(request.getParameter("subject"));
         StudentDao.saveStudent(student);
         response.sendRedirect("index.jsp");
         
     
     }
     else if("update".equals(request)){
     Student student=new Student();
         student.setName(request.getParameter("name"));
         student.setName(request.getParameter("subject"));
         student.setId(Integer.parseInt(request.getParameter("id")));
         StudentDao.updateStudent(student);
         response.sendRedirect("index.jsp");
     
     }
     
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
    }
    
    
}
