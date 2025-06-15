
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUtil {
  
    
    private static Connection con = null;
    private static String url="jdbc:mysql://localhost:3307/jsp";
    private static String usre="root";
    private static String password="1234";
    private static String driver="com.mysql.cj.jdbc.Driver";
    
    public static Connection getCon(){
    
         try {
             Class.forName(driver);
             con=(Connection) DriverManager.getConnection(url, usre, password);
         } catch (ClassNotFoundException |SQLException ex) {
             Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
         }
  return con;
    }
}

