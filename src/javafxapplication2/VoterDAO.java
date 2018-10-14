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
        String selectstmt = "SELECT * FROM voter.\"voterList\" WHERE \"NAME\" = "+"\'"+voterName+"\'";
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
            emp.setName(rs.getString("NAME"));
            emp.setGothram(rs.getString("GOTHRAM"));
            emp.setSurname(rs.getString("SURNAME"));
            emp.setFatherName(rs.getString("FATHERNAME"));
            emp.setMotherName(rs.getString("MOTHERNAME"));
            emp.setChildMale1(rs.getString("MALE1"));
            emp.setChildMale2(rs.getString("MALE2"));
            emp.setChildFemale1(rs.getString("FEMALE1"));
            emp.setChildFemale2(rs.getString("FEMALE2"));
            emp.setNewspaper(rs.getString("NEWSPAPER"));
            emp.setProfession(rs.getString("PROFESSION"));
            emp.setMobile(rs.getString("MOBILE"));
            emp.setLandline(rs.getString("LANDLINE"));
            emp.setReceipt(rs.getString("RECEIPTNO"));
            emp.setReceipt_per(rs.getString("PER_RECEIPT_NO"));
            emp.setMunicipalward(rs.getString("MINICIPAL_WARD_NO"));
            emp.setAdd_name(rs.getString("ADDRESS"));
            emp.setDoor_no(rs.getString("DOOR_NO"));
            emp.setStreet(rs.getString("STREET"));
            emp.setLandmark(rs.getString("LANDMARK"));
            
            emp.setHouse(rs.getBoolean("HOUSE"));
            emp.setRation(rs.getBoolean("RATION"));
            emp.setAadhar(rs.getBoolean("AADHAR"));
            emp.setVoter(rs.getBoolean("VOTER"));
            emp.setGas(rs.getBoolean("GAS"));
            emp.setTap(rs.getBoolean("TAP"));
            emp.setBank_acc(rs.getBoolean("BANK_ACC"));
            
           
           
        }
        return emp;
       
    }
    
   //*******************************
    //SELECT Employees
    //*******************************
    
    public static ObservableList<Voter> searchVoters() throws SQLException, ClassNotFoundException{
         ObservableList<Voter> list = null;
         //Declare a SELECT statement
        String selectStmt = "SELECT * FROM voter.\"voterList\" ";
        
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
        Voter  emp = new Voter();
            emp.setName(rs.getString("NAME"));
            emp.setGothram(rs.getString("GOTHRAM"));
            emp.setSurname(rs.getString("SURNAME"));
            emp.setFatherName(rs.getString("FATHERNAME"));
            emp.setMotherName(rs.getString("MOTHERNAME"));
            emp.setChildMale1(rs.getString("MALE1"));
            emp.setChildMale2(rs.getString("MALE2"));
            emp.setChildFemale1(rs.getString("FEMALE1"));
            emp.setChildFemale2(rs.getString("FEMALE2"));
            emp.setNewspaper(rs.getString("NEWSPAPER"));
            emp.setProfession(rs.getString("PROFESSION"));
            emp.setMobile(rs.getString("MOBILE"));
            emp.setLandline(rs.getString("LANDLINE"));
            emp.setReceipt(rs.getString("RECEIPTNO"));
            emp.setReceipt_per(rs.getString("PER_RECEIPT_NO"));
            emp.setMunicipalward(rs.getString("MINICIPAL_WARD_NO"));
            emp.setAdd_name(rs.getString("ADDRESS"));
            emp.setDoor_no(rs.getString("DOOR_NO"));
            emp.setStreet(rs.getString("STREET"));
            emp.setLandmark(rs.getString("LANDMARK"));
            
            emp.setHouse(rs.getBoolean("HOUSE"));
            emp.setRation(rs.getBoolean("RATION"));
            emp.setAadhar(rs.getBoolean("AADHAR"));
            emp.setVoter(rs.getBoolean("VOTER"));
            emp.setGas(rs.getBoolean("GAS"));
            emp.setTap(rs.getBoolean("TAP"));
            emp.setBank_acc(rs.getBoolean("BANK_ACC"));
            
            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }
    
    
    
     //*************************************
    //UPDATE an voter's email address
    //*************************************
    public static void updateVoter (String name, String surname, String gothram,String fathername,String mothername,String male1,String male2,String female1,String feamle2,String news,String proff,
                                    String mobile,String Landline,String receipt,String pereceipt,String muncipal,String add,String door,String street,String landmark,
                                    String house,String ration,String aadhar,String voter,String gas,String tap,String bank) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                 "UPDATE  voter.\"voterList\" " +
                        " SET \"SURNAME\" = "  + "\'"+surname+"\'"+","+
                        " \"GOTHRAM\" = " + "\'"+gothram+"\'"+","+
                        " \"FATHERNAME\" = " + "\'"+fathername+"\'"+","+
                        " \"MOTHERNAME\" = " + "\'"+mothername+"\'"+","+
                        " \"MALE1\" = " + "\'"+male1+"\'"+","+
                        " \"MALE2\" = " + "\'"+male2+"\'"+","+
                        " \"FEMALE1\" = " + "\'"+female1+"\'"+","+
                        " \"FEMALE2\" = " + "\'"+feamle2+"\'"+","+
                        " \"NEWSPAPER\" = " + "\'"+news+"\'"+","+
                        " \"PROFESSION\" = " + "\'"+proff+"\'"+","+
                        " \"MOBILE\" = " + "\'"+mobile+"\'"+","+
                        " \"LANDLINE\" = " + "\'"+Landline+"\'"+","+
                        " \"RECEIPTNO\" = " + "\'"+receipt+"\'"+","+
                        " \"PER_RECEIPT_NO\" = " + "\'"+pereceipt+"\'"+","+
                        " \"MINICIPAL_WARD_NO\" = " + "\'"+muncipal+"\'"+","+
                        " \"ADDRESS\" = " + "\'"+add+"\'"+","+
                        " \"DOOR_NO\" = " + "\'"+door+"\'"+","+
                        " \"STREET\" = " + "\'"+street+"\'"+","+
                        " \"LANDMARK\" = " + "\'"+landmark+"\'"+","+
                        " \"HOUSE\" = " + "\'"+house+"\'"+","+
                        " \"RATION\" = " + "\'"+ration+"\'"+","+
                        " \"AADHAR\" = " + "\'"+aadhar+"\'"+","+
                        " \"VOTER\" = " + "\'"+voter+"\'"+","+
                        " \"GAS\" = " + "\'"+gas+"\'"+","+
                        " \"TAP\" = " + "\'"+tap+"\'"+","+
                        " \"BANK_ACC\" = " + "\'"+bank+"\'"+
                        " WHERE \"NAME\" = "+"\'"+name+"\'" ;
             
 
     //   Execute UPDATE operation
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
    public static void deleteVoterWithId (String name) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        
        String deleteStmt =
                
                       " DELETE FROM voter.\"voterList\" WHERE \"NAME\" = " + "\'"+name+"\'" ;
      
        //Execute UPDATE operation
        try {
            
            System.out.println(deleteStmt);
            Dbconnecr.dbExecuteUpdate(deleteStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
 
    //*************************************
    //INSERT an employee
    //*************************************
    public static void insertVoter (String name, String surname, String gothram,String fathername,String mothername,String male1,String male2,String female1,String feamle2,String news,String proff,
                                    String mobile,String Landline,String receipt,String pereceipt,String muncipal,String add,String door,String street,String landmark,
                                    String house,String ration,String aadhar,String voter,String gas,String tap,String bank) throws SQLException, ClassNotFoundException {
        //Declare a INSERT statement
        String insertStmt =
                        "INSERT INTO voter.\"voterList\" " +
                        "VALUES\n" +
                        "( "+ "\'"+name+"\'"+ ", "+ "\'"+surname+"\'"+ ","+ "\'"+gothram+"\'"+ ", "+ "\'"+fathername+"\'"+ ", "+ "\'"+mothername+"\'"+ ","+ "\'"+male1+"\'"+ ","+ "\'"+male2+"\'"+ ","+ "\'"+female1+"\'"+ ","+ "\'"+feamle2+"\'"+ ","
                + "  "+ "\'"+news+"\'"+ ","+ "\'"+proff+"\'"+ ","+ "\'"+mobile+"\'"+ ","+ "\'"+Landline+"\'"+ ","+ "\'"+receipt+"\'"+ ","+ "\'"+pereceipt+"\'"+ ","+ "\'"+muncipal+"\'"+ ","+ "\'"+add+"\'"+ ","+ "\'"+door+"\'"+ ","+ "\'"+street+"\'"+ ","+ "\'"+landmark+"\'"+","+
                        "\'"+house+"\'"+ ","+"\'"+ration+"\'"+ ","+"\'"+aadhar+"\'"+ ","+"\'"+voter+"\'"+ ","+"\'"+gas+"\'"+ ","+"\'"+tap+"\'"+ ","+"\'"+bank+"\'"+ ")";
 
        System.out.println(insertStmt);
    //    Execute INSERT operation
        try {
            Dbconnecr.dbExecuteUpdate(insertStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
}
