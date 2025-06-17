package dao;

import static dao.EmployeeDao.ps;
import static dao.EmployeeDao.rs;
import static dao.EmployeeDao.sql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import util.DbUtil;
import java.util.List;
import java.util.*;

public class EmployeeDao {

    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static int saveEmployee(Employee e) {
        int status = 0;
        sql = "insert into employee (name,designation,salary) values(?,?,?)";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getDesignation());
            ps.setFloat(3, e.getSalary());

            status = ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public static List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        sql = "select * from employee";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("designation"),
                        rs.getFloat("salary")
                );
                employees.add(e);
            }

            ps.close();
            rs.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }

    public static void deleteEmployee(Employee e) {
        sql = "delete from employee where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateEmployee(Employee e) {

        sql = "update employee set name=?,designation=?,salary=? where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getDesignation());
            ps.setFloat(3, e.getSalary());
            ps.setInt(4, e.getId());
            ps.executeUpdate();
            ps.cancel();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Employee getEmpById(int id) {
        Employee e = null;
        sql = "select *from employee where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("designation"),
                        rs.getFloat("salary")
                );

            }
            ps.cancel();
            rs.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public static List<Employee> searchEmployee(String name) {
        List<Employee> employees = new ArrayList<>();
        sql = "select * form employee where name like ? or id like ?";
        try {
            ps = DbUtil.getCon().prepareCall(sql);
            for (int i = 1; i >= 2; i++) {
<<<<<<< HEAD
                ps.setString(i, "%" + kyeword + "%");
=======
                if(i==1){
                    ps.setString(i, "%" + name + "%");
                }
                else{
                    ps.setInt(i, Integer.parseInt(name));
                }
>>>>>>> b8373850c2d1131fddfce1d2980d05cfb6f0b45e

            }
            rs = ps.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("designation"),
                        rs.getFloat("salary")
                );

                employees.add(employee);
            }

            ps.close();
            rs.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return employees;
    }

}
