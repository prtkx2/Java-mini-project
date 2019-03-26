package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static sample.Main.getConnection;


import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class TableWindowController implements Initializable {

    @FXML
    private BorderPane borderpane;

    @FXML
    private JFXButton clickAddVehicle;

    @FXML
    private JFXTextField searchquery;

    @FXML
    private JFXTextField searchin;

    @FXML
    private JFXButton clickSearch;

    @FXML
    private TableView<RegTable> regTable;

    @FXML
    private TableColumn<RegTable, String> col_id;

    @FXML
    private TableColumn<RegTable, String> col_owname;

    @FXML
    private TableColumn<RegTable, String> col_vehname;

    @FXML
    private TableColumn<RegTable, String> col_regno;

    @FXML
    private TableColumn<RegTable, String> col_regdate;

    @FXML
    private TableColumn<RegTable, String> col_vehtype;

    ObservableList<RegTable> oblist = FXCollections.observableArrayList();

    @FXML
    void searchData() throws Exception {
        Connection con = getConnection("root", "hello1234");
        if ("Id".equals(searchin.getText())) {
            regTable.getItems().clear();
            ResultSet r1 = null;
            try {
                PreparedStatement ps = con.prepareStatement("Select * from people.vehreg where Id= ?");
                ps.setString(1, searchquery.getText());
                r1 = ps.executeQuery();

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                while (r1.next()) {
                    oblist.add(new RegTable(r1.getString("Id"), r1.getString("owname"), r1.getString("vehname"), r1.getString("regno"), r1.getString("regdate"), r1.getString("vehclass")));
                }
                col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_owname.setCellValueFactory(new PropertyValueFactory<>("owname"));
                col_vehname.setCellValueFactory(new PropertyValueFactory<>("vehname"));
                col_regno.setCellValueFactory(new PropertyValueFactory<>("regno"));
                col_regdate.setCellValueFactory(new PropertyValueFactory<>("regdate"));
                col_vehtype.setCellValueFactory(new PropertyValueFactory<>("vehclass"));

                regTable.setItems(oblist);
            }


        }
        if ("Owner's Name".equals(searchin.getText())) {
            regTable.getItems().clear();
            ResultSet r1 = null;
            try {
                PreparedStatement ps = con.prepareStatement("Select * from people.vehreg where owname= ?");
                ps.setString(1, searchquery.getText());
                r1 = ps.executeQuery();

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                while (r1.next()) {
                    oblist.add(new RegTable(r1.getString("Id"), r1.getString("owname"), r1.getString("vehname"), r1.getString("regno"), r1.getString("regdate"), r1.getString("vehclass")));
                }
                col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_owname.setCellValueFactory(new PropertyValueFactory<>("owname"));
                col_vehname.setCellValueFactory(new PropertyValueFactory<>("vehname"));
                col_regno.setCellValueFactory(new PropertyValueFactory<>("regno"));
                col_regdate.setCellValueFactory(new PropertyValueFactory<>("regdate"));
                col_vehtype.setCellValueFactory(new PropertyValueFactory<>("vehclass"));

                regTable.setItems(oblist);
            }


        }
        if ("Vehicle's name".equals(searchin.getText())) {
            regTable.getItems().clear();
            ResultSet r1 = null;
            try {
                PreparedStatement ps = con.prepareStatement("Select * from people.vehreg where vehname= ?");
                ps.setString(1, searchquery.getText());
                r1 = ps.executeQuery();

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                while (r1.next()) {
                    oblist.add(new RegTable(r1.getString("Id"), r1.getString("owname"), r1.getString("vehname"), r1.getString("regno"), r1.getString("regdate"), r1.getString("vehclass")));
                }
                col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_owname.setCellValueFactory(new PropertyValueFactory<>("owname"));
                col_vehname.setCellValueFactory(new PropertyValueFactory<>("vehname"));
                col_regno.setCellValueFactory(new PropertyValueFactory<>("regno"));
                col_regdate.setCellValueFactory(new PropertyValueFactory<>("regdate"));
                col_vehtype.setCellValueFactory(new PropertyValueFactory<>("vehclass"));

                regTable.setItems(oblist);
            }


        }
        if ("Registration No.".equals(searchin.getText())) {
            regTable.getItems().clear();
            ResultSet r1 = null;
            try {
                PreparedStatement ps = con.prepareStatement("Select * from people.vehreg where regno= ?");
                ps.setString(1, searchquery.getText());
                r1 = ps.executeQuery();

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                while (r1.next()) {
                    oblist.add(new RegTable(r1.getString("Id"), r1.getString("owname"), r1.getString("vehname"), r1.getString("regno"), r1.getString("regdate"), r1.getString("vehclass")));
                }
                col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_owname.setCellValueFactory(new PropertyValueFactory<>("owname"));
                col_vehname.setCellValueFactory(new PropertyValueFactory<>("vehname"));
                col_regno.setCellValueFactory(new PropertyValueFactory<>("regno"));
                col_regdate.setCellValueFactory(new PropertyValueFactory<>("regdate"));
                col_vehtype.setCellValueFactory(new PropertyValueFactory<>("vehclass"));

                regTable.setItems(oblist);
            }


        }
        if ("Reg. Date".equals(searchin.getText())) {
            regTable.getItems().clear();
            ResultSet r1 = null;
            try {
                PreparedStatement ps = con.prepareStatement("Select * from people.vehreg where regdate= ?");
                ps.setString(1, searchquery.getText());
                r1 = ps.executeQuery();

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                while (r1.next()) {
                    oblist.add(new RegTable(r1.getString("Id"), r1.getString("owname"), r1.getString("vehname"), r1.getString("regno"), r1.getString("regdate"), r1.getString("vehclass")));
                }
                col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_owname.setCellValueFactory(new PropertyValueFactory<>("owname"));
                col_vehname.setCellValueFactory(new PropertyValueFactory<>("vehname"));
                col_regno.setCellValueFactory(new PropertyValueFactory<>("regno"));
                col_regdate.setCellValueFactory(new PropertyValueFactory<>("regdate"));
                col_vehtype.setCellValueFactory(new PropertyValueFactory<>("vehclass"));

                regTable.setItems(oblist);
            }


        }
        if ("Vehicle Type".equals(searchin.getText())) {
            regTable.getItems().clear();
            ResultSet r1 = null;
            try {
                PreparedStatement ps = con.prepareStatement("Select * from people.vehreg where vehclass= ?");
                ps.setString(1, searchquery.getText());
                r1 = ps.executeQuery();

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                while (r1.next()) {
                    oblist.add(new RegTable(r1.getString("Id"), r1.getString("owname"), r1.getString("vehname"), r1.getString("regno"), r1.getString("regdate"), r1.getString("vehclass")));
                }
                col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_owname.setCellValueFactory(new PropertyValueFactory<>("owname"));
                col_vehname.setCellValueFactory(new PropertyValueFactory<>("vehname"));
                col_regno.setCellValueFactory(new PropertyValueFactory<>("regno"));
                col_regdate.setCellValueFactory(new PropertyValueFactory<>("regdate"));
                col_vehtype.setCellValueFactory(new PropertyValueFactory<>("vehclass"));

                regTable.setItems(oblist);
            }


        }
    }

    @FXML
    void clickAddVeh(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("vehregFXML.fxml"));

        Controller controller = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Add vehicle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = getConnection("root", "hello1234");
            ResultSet rs = con.createStatement().executeQuery("select *from people.vehreg");
            while (rs.next()) {
                oblist.add(new RegTable(rs.getString("Id"), rs.getString("owname"), rs.getString("vehname"), rs.getString("regno"), rs.getString("regdate"), rs.getString("vehclass")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_owname.setCellValueFactory(new PropertyValueFactory<>("owname"));
        col_vehname.setCellValueFactory(new PropertyValueFactory<>("vehname"));
        col_regno.setCellValueFactory(new PropertyValueFactory<>("regno"));
        col_regdate.setCellValueFactory(new PropertyValueFactory<>("regdate"));
        col_vehtype.setCellValueFactory(new PropertyValueFactory<>("vehclass"));

        regTable.setItems(oblist);
    }


}