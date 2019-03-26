/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static sample.Main.getConnection;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class Controller implements Initializable {

    @FXML
    private GridPane pane;
    @FXML
    private JFXTextField user;
    @FXML
    private JFXPasswordField pswd;
    @FXML
    private JFXButton loginButton;
    @FXML
    private Text connectionStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickLogin(ActionEvent event) throws IOException {
         if (("root".equals(user.getText())) & ("hello1234").equals(pswd.getText())) {
            connectionStatus.setText("Connected!");
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Parent root = FXMLLoader.load(getClass().getResource("optionWindow.fxml"));
            
            Controller controller = loader.getController();
            
            Scene scene = new Scene(root);
            primaryStage.setTitle("Vehicle information");
            primaryStage.setScene(scene);
            primaryStage.show();
        } else  {
            connectionStatus.setText("Wrong details!");
        }
        getConnection(user.getText(), pswd.getText());  //method to establish connection with the server with entered username and password as argument
    }
    
}
