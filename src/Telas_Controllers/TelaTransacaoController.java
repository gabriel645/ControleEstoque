package Telas_Controllers;

import DAO.FornecedorDAO;
import DAO.MovimentoDAO;
import DAO.ProdutoDAO;
import Objects.Fornecedor;
import Objects.Movimento;
import Objects.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.omg.CORBA.INTERNAL;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class TelaTransacaoController implements Initializable{

    @FXML private javafx.scene.control.ComboBox<Fornecedor> cb_forn;
    @FXML private javafx.scene.control.ComboBox<Produto> cb_prod;

//    @FXML private javafx.scene.control.ComboBox<ArrayList> cb_io;

    @FXML private javafx.scene.control.TextField textF_Quantidade;


    public void showCadastrarEditarProduto(ActionEvent event) {
        try {
            Parent loader = FXMLLoader.load(this.getClass().getResource("CadastrarEditarProduto.fxml"));
            Scene home = new Scene(loader);
            Stage app = new Stage();
            app.setScene(home);
            app.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ProdutoDAO p = new ProdutoDAO();
        ObservableList<Produto> pObservable = FXCollections.observableArrayList(p.get_by_desc(""));

        FornecedorDAO f = new FornecedorDAO();
        ObservableList<Fornecedor> fObservable = FXCollections.observableArrayList(f.get_by_desc());

//        ObservableList<ArrayList> io = FXCollections.observableArrayList(f.get_by_desc());


        cb_forn.setItems(fObservable);
        cb_prod.setItems(pObservable);

    }
}
