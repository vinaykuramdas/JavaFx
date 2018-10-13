/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javafx.application.Application.launch;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Dbconnecr {
  static   Connection conn;
   static  String url = "jdbc:postgresql://localhost:5432/vinay";
   static  String user = "postgres";
   static  String password = "Vin@y143";
  public static void dbConnect(){
      try{
      Class.forName("org.postgresql.Driver");
    Connection conn =  DriverManager.getConnection(url, user, password);
          JOptionPane.showMessageDialog(null, "connected");
   
      }
      catch(Exception ex){
          ex.printStackTrace();
      }
  }   
  
  public static ResultSet dbExecuteQuery(String query) throws SQLException{
      Statement stmt = null;
      ResultSet rst = null;
      CachedRowSetImpl crsi = null;
      
      try{
         //Connect to DB (Establish PostGreSql Connection)
          dbConnect();
          
          //Create statement
          stmt = conn.createStatement();
          
          //Execute select (query) operation
          rst = stmt.executeQuery(query);
          
          //CachedRowSet Implementation
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            //We are using CachedRowSet
          crsi = new CachedRowSetImpl();
          crsi.populate(rst);
      } catch(SQLException e){
          e.printStackTrace();
          
      }
      finally{
          if(rst != null){
              rst.close();
          }
          if(stmt != null){
              stmt.close();
          }
      }
      return crsi;
  }
  
  public static void dbExecuteUpdate(String stmt) throws SQLException{
      Statement stmat = null;
      
      try{
          
          // connect to db(postgresql )
          dbConnect();
          
          // create statement
          stmat = conn.createStatement();
          //Run upadate operation
          stmat.executeUpdate(stmt);
          
      }catch(SQLException e){
          e.printStackTrace();
          
      }finally{
          if(stmat != null){
              stmat.close();
          }
      }
  }
   
}
