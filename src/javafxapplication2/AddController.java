/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private void addButton(ActionEvent e) throws SQLException, ClassNotFoundException{
        VoterDAO.insertVoter(name.getText(), surname.getText(), gothram.getText());
        Alert add = new Alert(Alert.AlertType.INFORMATION);
        add.setContentText("Voter added successfully");
        add.showAndWait();
    }
   
            
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    ToggleGroup house = new ToggleGroup();
    house_yes.setToggleGroup(house);
    house_no.setToggleGroup(house);
    
    ToggleGroup ration = new ToggleGroup();
    ration_yes.setToggleGroup(ration);
    ration_no.setToggleGroup(ration);
    
    ToggleGroup voter = new ToggleGroup();
    voter_yes.setToggleGroup(voter);
    voter_no.setToggleGroup(voter);
    
    ToggleGroup aadhar = new ToggleGroup();
    aadhar_yes.setToggleGroup(aadhar);
    aadhar_no.setToggleGroup(aadhar);
    
    ToggleGroup gas = new ToggleGroup();
    gas_yes.setToggleGroup(gas);
    gas_no.setToggleGroup(gas);
    
    ToggleGroup tap = new ToggleGroup();
    tap_yes.setToggleGroup(tap);
    tap_no.setToggleGroup(tap);
    
    ToggleGroup bank = new ToggleGroup();
    bank_acc_yes.setToggleGroup(bank);
    bank_acc_no.setToggleGroup(bank);
            
            
            
            
    
    }    
    
}
