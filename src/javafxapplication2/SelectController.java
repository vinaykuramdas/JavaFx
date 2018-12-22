/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
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
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
     @FXML
    private TableColumn<Voter,String> childmale1;
    @FXML
    private TableColumn<Voter,String> childmale2;
    @FXML
    private TableColumn<Voter,String> childfemale1;
    @FXML
    private TableColumn<Voter,String> childfemale2;
    @FXML
    private TableColumn<Voter,String> receipt;
    @FXML
    private TableColumn<Voter,String> address;
    @FXML
    private TableColumn<Voter,String> sreeet;
    @FXML
    private TableColumn<Voter,String> landmark;
    
   
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
    
    @FXML
    private void printButton(ActionEvent e) throws IOException{
       // print(table);
       
       File textFile = new File("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\JavaFXApplication2\\src\\Images\\data.txt");
       FileWriter fw = new FileWriter(textFile);
     
        for (Voter person : table.getItems()) {
            String formatted = String.format("%s %s (%s)", person.getName(), person.getGothram(), person.getFatherName());
            System.out.println(formatted);
            fw.write(formatted);
        }
        
        
       
        final String username  = "vinaypsu@gmail.com";
        final String password  = "Vin@y143";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        
        Session sess = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
});
        try{
            Message message = new MimeMessage(sess);
            message.setFrom(new InternetAddress("vinaypsu@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("vinaykurmadas@gmail.com"));
            message.setSubject("Data");
            message.setText("Please find the data");
            
            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();

        String file = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\JavaFXApplication2\\src\\Images\\data.txt";
        String fileName = "Content";
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);
            
            Transport.send(message);
            Alert sent = new Alert(Alert.AlertType.INFORMATION);
            sent.setTitle("Information Dialog");
            sent.setContentText("Data sent to your mail");
            sent.showAndWait();
            System.out.print("message sent successfully");
            
            if(textFile.exists()){
                textFile.delete();
                System.out.println("File deleted");
                
            }
        }
        catch(MessagingException ex){
            throw new RuntimeException(ex);
            
        }
    }
    
      private void print(Node node) {
    System.out.println("Creating a printer job...");

    PrinterJob job = PrinterJob.createPrinterJob();
    if (job != null) {
      System.out.println(job.jobStatusProperty().asString());

      boolean printed = job.printPage(node);
      if (printed) {
        job.endJob();
      } else {
        System.out.println("Printing failed.");
      }
    } else {
      System.out.println("Could not create a printer job.");
    }
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
        childmale1.setCellValueFactory(new PropertyValueFactory<Voter,String>("childMale1"));
        childmale2.setCellValueFactory(new PropertyValueFactory<Voter,String>("childMale2"));
        childfemale1.setCellValueFactory(new PropertyValueFactory<Voter,String>("childFemale1"));
        childfemale2.setCellValueFactory(new PropertyValueFactory<Voter,String>("childFemale2"));
        receipt.setCellValueFactory(new PropertyValueFactory<Voter,String>("receipt"));
        address.setCellValueFactory(new PropertyValueFactory<Voter,String>("Add_name"));
        sreeet.setCellValueFactory(new PropertyValueFactory<Voter,String>("street"));
        landmark.setCellValueFactory(new PropertyValueFactory<Voter,String>("landmark"));
       
        
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
