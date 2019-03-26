package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(root, 674, 575));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        launch(args);


    }


    public static Connection getConnection( String name, String pass) {
        try {
            String username = name;
            String password= pass;
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/people";  //people is the database,127.0.0.1 is the address of localhost
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");

            return conn;
        }catch (Exception e )
        {
            System.out.println(e);
        }
        return null;
    }
}