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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class PrincipalController implements Initializable {
//    public void showProdutos(ActionEvent event){
//        try {
//            Parent loader = FXMLLoader.load(this.getClass().getResource("Cadastro.fxml"));
//            Scene home = new Scene(loader);
//            Stage app = new Stage();
//            //app.setTitle("Olipia SPA - Cadastro");
//            app.setScene(home);
//            app.show();
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void showMovimentacao(ActionEvent event){
//        try {
//            Parent loader = FXMLLoader.load(this.getClass().getResource("Entrada.fxml"));
//            Scene home = new Scene(loader);
//            Stage app = new Stage();
//            //app.setTitle("Olipia SPA - Entrada");
//            app.setScene(home);
//            app.show();
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void showRelatorio(ActionEvent event){
//        try {
//            Parent loader = FXMLLoader.load(this.getClass().getResource("Relatorio.fxml"));
//            Scene home = new Scene(loader);
//            Stage app = new Stage();
//            //app.setTitle("Olipia SPA - Relatório");
//            app.setScene(home);
//            app.show();
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }

    @FXML
    Pane PainelPrincipal;
    public void loadProdutos (ActionEvent event)  {
        try {
            Parent newLoadedPane = FXMLLoader.load(getClass().getResource("TelaProduto.fxml"));
            PainelPrincipal.getChildren().clear();
            PainelPrincipal.getChildren().add(newLoadedPane);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void loadMovimentacao (ActionEvent event)  {
        try {
            Parent newLoadedPane = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
            PainelPrincipal.getChildren().clear();
            PainelPrincipal.getChildren().add(newLoadedPane);
        }catch(Exception e){
            e.printStackTrace();


        }
    }
    public void loadRelatorio (ActionEvent event)  {
        try {
            Parent newLoadedPane = FXMLLoader.load(getClass().getResource("Relatorio.fxml"));
            PainelPrincipal.getChildren().clear();
            PainelPrincipal.getChildren().add(newLoadedPane);
        }catch(Exception e){
            e.printStackTrace();


        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
