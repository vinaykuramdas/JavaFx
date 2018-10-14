/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class UpdateController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField gothram;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField fathername;
    @FXML
    private TextField mothername;
    @FXML
    private TextField child_male1;
    @FXML
    private TextField child_male2;
    @FXML
    private TextField child_female1;
    @FXML
    private TextField child_female2;
    @FXML
    private TextField profession;
    @FXML
    private TextField newspaper;
    @FXML
    private TextField mobile;
    @FXML
    private TextField landline;
    @FXML
    private TextField receiptno;
    @FXML
    private TextField p_receiptno;
    @FXML
    private TextField municipalward;
    @FXML
    private TextField add_name;
    @FXML
    private TextField door_no;
    @FXML
    private TextField street;
    @FXML
    private TextField landmark;
    
    @FXML
    private RadioButton gas_yes;
    @FXML
    private RadioButton gas_no;
    @FXML
    private RadioButton tap_yes;
    @FXML
    private RadioButton tap_no;
    @FXML
    private RadioButton bank_acc_yes;
    @FXML
    private RadioButton bank_acc_no;
    @FXML
    private RadioButton house_yes;
    @FXML
    private RadioButton house_no;
    @FXML
    private RadioButton voter_yes;
    @FXML
    private RadioButton voter_no;
    @FXML
    private RadioButton aadhar_yes;
    @FXML
    private RadioButton aadhar_no;
    @FXML
    private RadioButton ration_yes;
    @FXML
    private RadioButton ration_no;
    
    
     @FXML
    private ToggleGroup house;
    @FXML
    private ToggleGroup voter;
    @FXML
    private ToggleGroup aadhar;
    @FXML
    private ToggleGroup gas;
    @FXML
    private ToggleGroup tap;
    @FXML
    private ToggleGroup bank;
    @FXML
    private ToggleGroup ration;
            
    
    
            
    @FXML
    private void updateButton(ActionEvent e) throws SQLException, ClassNotFoundException{
        System.out.println("javafxapplication2.UpdateController.updateButton()");
        
        try{
            Alert update  = new Alert(Alert.AlertType.CONFIRMATION);
            update.setContentText("Are you sure want to Update?");
            Optional<ButtonType> res_up = update.showAndWait();
            
            if(res_up.get().equals(ButtonType.OK)){
                
        RadioButton h_chk = (RadioButton) house.getSelectedToggle();
        RadioButton r_chk = (RadioButton) ration.getSelectedToggle();
        RadioButton a_chk = (RadioButton) aadhar.getSelectedToggle();
        RadioButton v_chk = (RadioButton) voter.getSelectedToggle();
        RadioButton g_chk = (RadioButton) gas.getSelectedToggle();
        RadioButton t_chk = (RadioButton) tap.getSelectedToggle();
        RadioButton b_chk = (RadioButton) bank.getSelectedToggle();
                
                VoterDAO.updateVoter(name.getText(), surname.getText(), gothram.getText(),fathername.getText(),mothername.getText(),child_male1.getText(),child_male2.getText(),child_female1.getText(),child_female2.getText(),
                             newspaper.getText(),profession.getText(),mobile.getText(),landline.getText(),receiptno.getText(),p_receiptno.getText(),municipalward.getText(),add_name.getText(),door_no.getText(),street.getText(),landmark.getText()
                             ,h_chk.getText(),r_chk.getText(),a_chk.getText(),v_chk.getText(),g_chk.getText(),t_chk.getText(),b_chk.getText()
                             );
              
            Alert up_res = new Alert(Alert.AlertType.INFORMATION);
            up_res.setContentText("voter updated successfully");
            up_res.showAndWait();
            
            
             name.setText(""); surname.setText(""); gothram.setText("");fathername.setText("");mothername.setText("");child_male1.setText("");child_male2.setText("");child_female1.setText("");child_female2.setText("");
                             newspaper.setText("");profession.setText("");mobile.setText("");landline.setText("");receiptno.setText("");p_receiptno.setText("");municipalward.setText("");add_name.setText("");door_no.setText("");street.setText("");landmark.setText("");
                             h_chk.setText("");r_chk.setText("");a_chk.setText("");v_chk.setText("");g_chk.setText("");t_chk.setText("");b_chk.setText("");
            }
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void backButton(ActionEvent e) throws IOException{
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Intro.fxml"));
            Parent back = loader.load();
            Scene go_back = new Scene(back);
            Stage back_stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            back_stage.setScene(go_back);
            back_stage.setResizable(false);
            back_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     house = new ToggleGroup();
    house_yes.setToggleGroup(house);
    house_no.setToggleGroup(house);
    
     ration = new ToggleGroup();
    ration_yes.setToggleGroup(ration);
    ration_no.setToggleGroup(ration);
    
     voter = new ToggleGroup();
    voter_yes.setToggleGroup(voter);
    voter_no.setToggleGroup(voter);
    
     aadhar = new ToggleGroup();
    aadhar_yes.setToggleGroup(aadhar);
    aadhar_no.setToggleGroup(aadhar);
    
     gas = new ToggleGroup();
    gas_yes.setToggleGroup(gas);
    gas_no.setToggleGroup(gas);
    
     tap = new ToggleGroup();
    tap_yes.setToggleGroup(tap);
    tap_no.setToggleGroup(tap);
    
    bank = new ToggleGroup();
    bank_acc_yes.setToggleGroup(bank);
    bank_acc_no.setToggleGroup(bank);
            
    }    
    
  @FXML
    private void getDetails(ActionEvent e) throws SQLException{
        Voter vote = new Voter();
      vote= VoterDAO.searchVoter(name.getText());
        
                   surname.setText(vote.getSurname()); gothram.setText(vote.getGothram());fathername.setText(vote.getFatherName());mothername.setText(vote.getMotherName());child_male1.setText(vote.getChildMale1());child_male2.setText(vote.getChildMale2());child_female1.setText(vote.getChildFemale1());child_female2.setText(vote.getChildFemale2());
                             newspaper.setText(vote.getNewspaper());profession.setText(vote.getProfession());mobile.setText(vote.getMobile());landline.setText(vote.getLandline());receiptno.setText(vote.getReceipt());p_receiptno.setText(vote.getReceipt_per());municipalward.setText(vote.getMunicipalward());add_name.setText(vote.getAdd_name());door_no.setText(vote.getDoor_no());street.setText(vote.getStreet());landmark.setText(vote.getLandmark());
               if(vote.getHouse()){
                   house_yes.setSelected(true);
               }else{
                   house_no.setSelected(true);
               }    
               
                if(vote.getRation()){
                   ration_yes.setSelected(true);
               }else{
                   ration_no.setSelected(true);
               }  
                
                 if(vote.getAadhar()){
                   aadhar_yes.setSelected(true);
               }else{
                   aadhar_no.setSelected(true);
               }  
                 
                  if(vote.getVoter()){
                   voter_yes.setSelected(true);
               }else{
                   voter_no.setSelected(true);
               }  
                  
                   if(vote.getGas()){
                   gas_yes.setSelected(true);
               }else{
                   gas_no.setSelected(true);
               }  
                   
                    if(vote.getTap()){
                   tap_yes.setSelected(true);
               }else{
                   tap_no.setSelected(true);
               }  
                    
                     if(vote.getBank_acc()){
                   bank_acc_yes.setSelected(true);
               }else{
                   bank_acc_no.setSelected(true);
               }  
        }  
}
