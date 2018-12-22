/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class AddController implements Initializable {

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
    private void backButton(ActionEvent e){
         try{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Intro.fxml"));
            Parent back = loader.load();
            Scene go_back = new Scene(back);
            Stage back_stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            back_stage.setScene(go_back);
            back_stage.setResizable(false);
            back_stage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    
   
    
    
   @FXML
   private void printButton(ActionEvent e) throws IOException{
//       FXMLLoader load = new FXMLLoader(getClass().getResource("Add.fxml"));
//       Parent printe = load.load();
//       Stage add_stage = (Stage)((Node) e.getSource()).getScene().getWindow();
       
    
//     gothram.appendText("Gothram:");
//       print(gothram);   
//       
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
    private void addButton(ActionEvent e) throws SQLException, ClassNotFoundException{
        RadioButton h_chk = (RadioButton) house.getSelectedToggle();
        RadioButton r_chk = (RadioButton) ration.getSelectedToggle();
        RadioButton a_chk = (RadioButton) aadhar.getSelectedToggle();
        RadioButton v_chk = (RadioButton) voter.getSelectedToggle();
        RadioButton g_chk = (RadioButton) gas.getSelectedToggle();
        RadioButton t_chk = (RadioButton) tap.getSelectedToggle();
        RadioButton b_chk = (RadioButton) bank.getSelectedToggle();
        
        VoterDAO.insertVoter(name.getText(), surname.getText(), gothram.getText(),fathername.getText(),mothername.getText(),child_male1.getText(),child_male2.getText(),child_female1.getText(),child_female2.getText(),
                             newspaper.getText(),profession.getText(),mobile.getText(),landline.getText(),receiptno.getText(),p_receiptno.getText(),municipalward.getText(),add_name.getText(),door_no.getText(),street.getText(),landmark.getText()
                             ,h_chk.getText(),r_chk.getText(),a_chk.getText(),v_chk.getText(),g_chk.getText(),t_chk.getText(),b_chk.getText()
                             );
        Alert add = new Alert(Alert.AlertType.INFORMATION);
        add.setContentText("Voter added successfully");
        add.showAndWait();
        
                name.setText(""); surname.setText(""); gothram.setText("");fathername.setText("");mothername.setText("");child_male1.setText("");child_male2.setText("");child_female1.setText("");child_female2.setText("");
                newspaper.setText("");profession.setText("");mobile.setText("");landline.setText("");receiptno.setText("");p_receiptno.setText("");municipalward.setText("");add_name.setText("");door_no.setText("");street.setText("");landmark.setText("");
                house_yes.setSelected(false);house_no.setSelected(false);aadhar_yes.setSelected(false);aadhar_no.setSelected(false);
                voter_yes.setSelected(false);voter_no.setSelected(false);ration_yes.setSelected(false);ration_no.setSelected(false);
                gas_yes.setSelected(false);gas_no.setSelected(false);tap_yes.setSelected(false);tap_no.setSelected(false);bank_acc_yes.setSelected(false);bank_acc_no.setSelected(false);
                             
        
    }
    
}
