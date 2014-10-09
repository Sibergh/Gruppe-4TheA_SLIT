/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;
import java.sql.*;
/**
 *
 * @author ola
 */
public class Connect     
{
        public static void main(String[] args) {
                String url = "jdbc:mysql://localhost:3306/";
                String dbName = "slitdbv4";
                String driver = "com.mysql.jdbc.Driver";
                String userName = "root";
                String password = "";
                try {
                    Class.forName(driver).newInstance();
                    Connection conn = DriverManager.getConnection(url+dbName,userName,password);
                    
                conn.close();
                } catch (Exception e) {
                    e.printStackTrace();    
                }
        }
}
