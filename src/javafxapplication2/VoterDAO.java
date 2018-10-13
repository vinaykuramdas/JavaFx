/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author VINAY
 */
public class VoterDAO {
    
     //*******************************
    //SELECT an Voter
    //*******************************
    
    public static Voter searchVoter(String voterName) throws SQLException{
        Voter voter = null;
        //Declare a SELECT statement
        String selectstmt = "SELECT * FROM voter.voterList WHERE Name = "+voterName;
        try{
             //Get ResultSet from dbExecuteQuery method
             ResultSet rst = Dbconnecr.dbExecuteQuery(selectstmt);
             
            //Send ResultSet to the getEmployeeFromResultSet method and get voter object
            voter = getVoterFromResultSet(rst);
        }catch(SQLException e){
            e.printStackTrace();
        }
       return voter; 
    }
    
    
     //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Voter getVoterFromResultSet(ResultSet rs) throws SQLException
    {
        Voter emp = null;
        if (rs.next()) {
            emp = new Voter();
            emp.setName(rs.getString("EMPLOYEE_ID"));
            emp.setFatherName(rs.getString("FIRST_NAME"));
            emp.setMotherName(rs.getString("LAST_NAME"));
            emp.setGothram(rs.getString("EMAIL"));
            emp.setChildMale1(rs.getString("PHONE_NUMBER"));
            emp.setChildMale2(rs.getString("HIRE_DATE"));
            emp.setChildFemale1(rs.getString("JOB_ID"));
            emp.setChildFemale2(rs.getString("SALARY"));
            emp.setProfession(rs.getString("COMMISSION_PCT"));
            emp.setNewspaper(rs.getString("MANAGER_ID"));
            emp.setMobile(rs.getString("DEPARTMENT_ID"));
        }
        return emp;
    }
    
   //*******************************
    //SELECT Employees
    //*******************************
    
    public static ObservableList<Voter> searchVoters() throws SQLException, ClassNotFoundException{
         ObservableList<Voter> list = null;
         //Declare a SELECT statement
        String selectStmt = "SELECT * FROM voter.voterlist" ;
        
        try{
            
            ResultSet rst = Dbconnecr.dbExecuteQuery(selectStmt);
             list = getVoterList(rst);
            
        
                }catch(SQLException e){
                    e.printStackTrace();
                }
        return list;
    }
    
    
    
     //Select * from Voter.voterlist operation
    private static ObservableList<Voter> getVoterList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Voter objects
        ObservableList<Voter> empList = FXCollections.observableArrayList();
 
        while (rs.next()) {
            Voter emp = new Voter();
            emp.setName(rs.getString("EMPLOYEE_ID"));
            emp.setFatherName(rs.getString("FIRST_NAME"));
            emp.setMotherName(rs.getString("LAST_NAME"));
            emp.setGothram(rs.getString("EMAIL"));
            emp.setChildMale1(rs.getString("PHONE_NUMBER"));
            emp.setChildMale2(rs.getString("HIRE_DATE"));
            emp.setChildFemale1(rs.getString("JOB_ID"));
            emp.setChildFemale2(rs.getString("SALARY"));
            emp.setProfession(rs.getString("COMMISSION_PCT"));
            emp.setNewspaper(rs.getString("MANAGER_ID"));
            emp.setMobile(rs.getString("DEPARTMENT_ID"));
            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }
    
    
    
     //*************************************
    //UPDATE an voter's email address
    //*************************************
    public static void updateVoter (String empId) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE voter.voterlist \n" +
          //              "      SET EMAIL = '" + empEmail + "'\n" +
                        "    WHERE EMPLOYEE_ID = " + empId + ";\n" +
                        "   COMMIT;\n" +
                        "END;";
 
        //Execute UPDATE operation
        try {
            Dbconnecr.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
 
    //*************************************
    //DELETE an voter
    //*************************************
    public static void deleteVoterWithId (String empId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String deleteStmt =
                "BEGIN\n" +
                        "   DELETE FROM voter.voterlist\n" +
                        "         WHERE employee_id ="+ empId +";\n" +
                        "   COMMIT;\n" +
                        "END;";
 
        //Execute UPDATE operation
        try {
            Dbconnecr.dbExecuteUpdate(deleteStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
 
    //*************************************
    //INSERT an employee
    //*************************************
    public static void insertVoter (String name, String lastname, String email) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String insertStmt =
                "BEGIN\n" +
                        "INSERT INTO voter.voterlist\n" +
                        "(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID)\n" +
                        "VALUES\n" +
                        "(sequence_employee.nextval, '"+name+"', '"+lastname+"','"+email+"', SYSDATE, 'IT_PROG');\n" +
                        "END;";
 
        //Execute DELETE operation
        try {
            Dbconnecr.dbExecuteUpdate(insertStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
}
