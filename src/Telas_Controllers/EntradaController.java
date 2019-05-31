package Telas_Controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class EntradaController implements Initializable {
    //private Stage app = new Stage();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML 
    private javafx.scene.control.Button button_Finalizar;
    
     public void showPesquisa(ActionEvent event){               
        try {
            Parent loader = FXMLLoader.load(this.getClass().getResource("Pesquisar.fxml")); 
            Scene home = new Scene(loader);
            Stage app = new Stage();
            app.setTitle("Olimpia SPA - Pesquisa");
            app.setScene(home);
            app.show();
            
            

        } catch(Exception e) {
           e.printStackTrace();
        }
     }
     public void salva_fecha(ActionEvent event){
         try {
                //implementar SALVAR
            Stage stage = (Stage) button_Finalizar.getScene().getWindow();
            // do what you have to do
            stage.close();

        } catch(Exception e) {
           e.printStackTrace();
        }
     }
    
}
