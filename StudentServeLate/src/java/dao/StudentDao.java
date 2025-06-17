package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import util.DbUtil;

public class StudentDao {

    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static int saveStudent(Student s) {
        int status = 0;
        sql = "insert into employee (name,designation,salary) values(?,?,?)";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getSubject());
            status = ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public static List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        sql = "select * from student";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student e = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("subject"));

                students.add(e);
            }

            ps.close();
            rs.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

    public static void deleteStudent(Student s) {
        sql = "delete from employee where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateStudent(Student s) {

        sql = "update employee set name=?,designation=?,salary=? where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getSubject());
            ps.executeUpdate();
            ps.cancel();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Student getStuById(int id) {
        Student e = null;
        sql = "select *from student where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                e = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("subject")
                );

            }
            ps.cancel();
            rs.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
}
