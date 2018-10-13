/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.Properties;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Vinay
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ImageView devi;
    
    @FXML
    private void LoginButton(ActionEvent event) {
        if("vinay".equals(username.getText()) && "Vin@y143".equals(password.getText())){
            System.out.println("You clicked me!"); 
            Alert log = new Alert(Alert.AlertType.INFORMATION);
            log.setTitle("Information Dialog");
            log.setContentText("You logged in!");
            log.showAndWait();
            username.setText("");
            password.setText("");
            try{
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Intro.fxml"));
                 Parent root1 = loader.load(); 
                Scene Intro = new Scene(root1);
                Stage Intro_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Intro_stage.setScene(Intro);
                Intro_stage.setResizable(false);
                Intro_stage.show();
                 
            }
            catch(Exception e){
                e.printStackTrace();   
            }
           
            
        }else{
           Alert error = new Alert(Alert.AlertType.ERROR);
           error.setTitle("Error");
           error.setContentText("Wrong Credentials.Please try again");
           error.showAndWait();
           
            username.setText("");
            password.setText("");
        }
        
    }
    
    @FXML
    private void ForgotButton(ActionEvent ev){
        
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
            message.setSubject("Password Recovery");
            message.setText("your password is\n Password:Vin@y143");
            
            Transport.send(message);
            Alert sent = new Alert(Alert.AlertType.INFORMATION);
            sent.setTitle("Information Dialog");
            sent.setContentText("Password sent to your mail");
            sent.showAndWait();
            System.out.print("message sent successfully");
        }
        catch(MessagingException ex){
            throw new RuntimeException(ex);
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
