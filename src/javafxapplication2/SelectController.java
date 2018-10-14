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
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vinay
 */
public class SelectController implements Initializable {
    
    @FXML
    private ObservableList<Voter> data;
    
    @FXML
    private Label personID;
    @FXML
    private TextField ID;

    @FXML
    private TableView<Voter> table;
    @FXML
    private TableColumn<Voter,String> Name;
    @FXML
    private TableColumn<Voter,String> Gotharm;
    @FXML
    private TableColumn<Voter,String> fatherName;
    @FXML
    private TableColumn<Voter,String> motherName;
    @FXML
    private TableColumn<Voter,String> mobile;
    @FXML
    private TableColumn<Voter,String> newspaper;
    @FXML
    private TableColumn<Voter,String> profession;
    @FXML
    private TableColumn<Voter,String> surname;
    
   
    /**
     * Initializes the controller class.
     */
    
     @FXML
    private void searchButton(ActionEvent e) throws SQLException, ClassNotFoundException{
        System.out.println("Search button");
        data = FXCollections.observableArrayList();
        Voter vote = new Voter();
        
      vote =  VoterDAO.searchVoter(ID.getText());
        data.add(vote);
        table.setItems(data);
        
    }
    
    @FXML
    private void searchAll(ActionEvent e) throws SQLException, ClassNotFoundException{
        System.out.println("Search button");
        data = FXCollections.observableArrayList();
        Voter vote = new Voter();
        
      data =  VoterDAO.searchVoters();
        table.setItems(data);
         
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
        
        Name.setCellValueFactory(new PropertyValueFactory<Voter,String>("name"));
        Gotharm.setCellValueFactory(new PropertyValueFactory<Voter,String>("gothram"));
        fatherName.setCellValueFactory(new PropertyValueFactory<Voter,String>("fatherName"));
        motherName.setCellValueFactory(new PropertyValueFactory<Voter,String>("motherName"));
        mobile.setCellValueFactory(new PropertyValueFactory<Voter,String>("mobile"));
        newspaper.setCellValueFactory(new PropertyValueFactory<Voter,String>("newspaper"));
        profession.setCellValueFactory(new PropertyValueFactory<Voter,String>("profession"));
        surname.setCellValueFactory(new PropertyValueFactory<Voter,String>("surname"));
        
    //    table.getColumns().addAll(Name,Gotharm,fatherName,motherName,mobile,newspaper,profession,surname);
//        
//        try{
//     data =   VoterDAO.searchVoters();
//     table.setItems(data);
//      
//        } catch (SQLException ex) {
//            Logger.getLogger(SelectController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SelectController.class.getName()).log(Level.SEVERE, null, ex);
//        }
 
    }  
}
