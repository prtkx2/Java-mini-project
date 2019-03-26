/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;


import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static sample.Main.getConnection;

public class VehregFXMLController {

    @FXML
    private AnchorPane main;

    @FXML
    private JFXTextField idno;

    @FXML
    private JFXTextField oname;

    @FXML
    private JFXTextField vname;

    @FXML
    private JFXTextField rnumber;

    @FXML
    private JFXTextField vclass;

    @FXML
    private JFXDatePicker rdate;

    @FXML
    private Button save;

    @FXML
    private Button clear;

    PreparedStatement pr = null;
    ResultSet rs;

    String read = "SELECT * FROM vehreg";

    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con = getConnection("root", "hello1234");
            PreparedStatement pr = con.prepareStatement(read);
            rs = pr.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void adddata(ActionEvent event) throws IOException {
        String sql = "INSERT INTO vehreg(Id, owname, vehname, regno, regdate, vehclass) VALUES (?,?,?,?,?,?)";
        try (
                Connection con = getConnection("root", "hello1234");
                PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setString(1, this.idno.getText());
            stmt.setString(2, this.oname.getText());
            stmt.setString(3, this.vname.getText());
            stmt.setString(4, this.rnumber.getText());
            stmt.setString(5, this.rdate.getEditor().getText());
            stmt.setString(6, this.vclass.getText());

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        finally {

            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Parent root = FXMLLoader.load(getClass().getResource("optionWindow.fxml"));

            Controller controller = loader.getController();

            Scene scene = new Scene(root);
            primaryStage.setTitle("Add vehicle");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    @FXML
    private void clear(ActionEvent event) {
        this.idno.setText("");
        this.oname.setText("");
        this.vname.setText("");
        this.rnumber.setText("");
        this.rdate.setValue(null);
        this.vclass.setText("");
    }
}
