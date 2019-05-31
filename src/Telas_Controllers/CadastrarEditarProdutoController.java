package Telas_Controllers;

import DAO.FornecedorDAO;
import DAO.ProdutoDAO;
import Objects.Fornecedor;
import Objects.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class CadastrarEditarProdutoController implements Initializable {

    @FXML private javafx.scene.control.TextField textF_Nome;
    @FXML private javafx.scene.control.TextField textF_Preco;

    @FXML private javafx.scene.control.ComboBox<Fornecedor> cb_forn;



    public void showCadastrarEditarFornecedores(ActionEvent event){
        try {
            Parent loader = FXMLLoader.load(this.getClass().getResource("CadastrarEditarFornecedores.fxml"));
            Scene home = new Scene(loader);
            Stage app = new Stage();
            //app.setTitle("Olipia SPA - Relatório");
            app.setScene(home);
            app.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void add_edit(ActionEvent event){
        try {
            ProdutoDAO prod = new ProdutoDAO();
            Date d = new Date();
            Produto f = new Produto(1,cb_forn.getValue().getDescricao(),textF_Nome.getText(),d ,Double.parseDouble(textF_Preco.getText()));
            prod.add(f);


        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FornecedorDAO f = new FornecedorDAO();
        ObservableList<Fornecedor> fObservable = FXCollections.observableArrayList(f.get_by_desc());
        cb_forn.setItems(fObservable);
    }
}
