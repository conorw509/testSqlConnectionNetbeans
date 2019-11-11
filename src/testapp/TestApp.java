/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Conor
 */
public class TestApp extends Application {
    
    private Connection conn;
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Button btn = new Button();
        btn.setText("Connect to mySql'");
       
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             SqlConnect connect = new SqlConnect(conn);
                try {
                    connect.connect();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
                }
             
             
                
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Insert!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);   
    }
    
}
