/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Vinay
 */
public class IntroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection conn;
    
    @FXML
    private Label User;
    
    
    @FXML
    private void submitButton(ActionEvent e){
        System.out.println("submit button"); 
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Select.fxml"));
            Parent root = loader.load();
            Scene add = new Scene(root);
            Stage select_stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            select_stage.setScene(add);
            select_stage.setResizable(false);
            select_stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
    @FXML
    private void addButton(ActionEvent e){
        
        try{
            System.out.println("Add Button");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Add.fxml"));
            Parent root = loader.load();
            Scene add = new Scene(root);
            Stage add_stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            add_stage.setScene(add);
            add_stage.setResizable(false);
            add_stage.show();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @FXML
    private void updateButton(ActionEvent e){
        try{
              System.out.println("Update Button");
              
             FXMLLoader loader = new FXMLLoader(getClass().getResource("update.fxml"));
            Parent root = loader.load();
            Scene update = new Scene(root);
            Stage up_stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            up_stage.setScene(update);
            up_stage.setResizable(false);
            up_stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
      
                
    }
    @FXML
    private void deleteButton (ActionEvent e) throws IOException{
        System.out.println("Delete Button");
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Delete.fxml"));
            Parent del = loader.load();
            Scene delete = new Scene(del);
            Stage del_stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            del_stage.setScene(delete);
            del_stage.setResizable(false);
            del_stage.show();
    }
    @FXML
    private void backButton (ActionEvent e){
        Alert log_out = new Alert(Alert.AlertType.CONFIRMATION);
        log_out.setContentText("Are you Sure want to Logout?");
       Optional<ButtonType> result =  log_out.showAndWait();
        
        if(result.get().equals(ButtonType.OK)) {     
        try{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
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
        }else{
            System.out.println("Same screen");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
