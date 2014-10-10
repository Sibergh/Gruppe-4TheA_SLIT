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
{       /*oppretter forbindelse til databasen*/
        public static void main(String[] args) {
                String url = "jdbc:mysql://localhost:3306/";
                String dbName = "slitdbv4";
                String driver = "com.mysql.jdbc.Driver";
                String userName = "root";
                String password = "";
                try {
                    Class.forName(driver).newInstance();
                    Connection conn = DriverManager.getConnection(url+dbName,userName,password);
                    
     /*
                String query = " insert into users (fname, lname, email, phoneNo)"
                        + "values (?,?,?,?)";
                
                /* Insert into table*//*
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, "Ola");
                preparedStmt.setString (2, "Malnes");
                preparedStmt.setString (3, "ola.malnes@gmail.com");
                preparedStmt.setString (4, "12345678");
                    
                // execute the preparedstatement
                preparedStmt.execute();    
                    
                */
                
                /*delete from table*/
                /*
                String query = "delete from users where userid = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, 3);
                
                preparedStmt.execute();*/
                
                
                    
                    
                /*select from table*/
                String query = "SELECT * FROM users where userID=5";
                
                Statement st = conn.createStatement();
                
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next())
                    {
                      int id = rs.getInt("userID");
                      String firstName = rs.getString("fName");
                      

                      // print the results
                      System.out.format("%s, %s\n", id, firstName);
                    }
                st.close();
                
                /*lukker forbindelse med database*/
                conn.close();
                } catch (Exception e) {
                    e.printStackTrace();    
                }
        }
}
