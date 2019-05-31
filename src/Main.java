/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gabri
 */
public class Main extends Application {
    
    public static Stage stg;
    @Override
    public void start(Stage stage) throws Exception { 
        this.stg = stage;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Telas_Controllers/Principal.fxml"));
        Parent root = loader.load(); 
        stage.setScene(new Scene(root)); 
        stage.show();
        stage.setTitle("Olipia SPA");
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
