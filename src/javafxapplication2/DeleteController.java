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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class DeleteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label deleteId;
    @FXML
    private TextField id;
    @FXML
    private TextArea result;
    
    @FXML
    private void deleteButton(ActionEvent e) throws IOException, SQLException, ClassNotFoundException{
        System.out.println("javafxapplication2.DeleteController.deleteButton()");
        
            Alert delete =new Alert( Alert.AlertType.CONFIRMATION);
            delete.setContentText("Are you sure want to DELETE");
            Optional<ButtonType> res = delete.showAndWait();
            
            if(res.get().equals(ButtonType.OK)){
                try{
                    
                 VoterDAO.deleteVoterWithId(id.getText());
            result.setText("The person with"+deleteId.getText()+"is deleted successfully.");  
                }catch(Exception ex){
                    ex.printStackTrace();
            }
         
            }else{
                System.out.println("Same screen");
                result.setText("No person Deleted");
            }
        
            
    }
    @FXML
    private void backButton(ActionEvent e) throws IOException{
        System.out.println("javafxapplication2.DeleteController.backButton()");
        
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
    }    
    
}
