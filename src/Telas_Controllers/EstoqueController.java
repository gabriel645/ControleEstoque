package Telas_Controllers;

import DAO.FornecedorDAO;
import DAO.MovimentoDAO;
import DAO.ProdutoDAO;
import Objects.Fornecedor;
import Objects.Produto;

import Objects.Movimento;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EstoqueController implements Initializable {

    @FXML private TableView<Movimento> tabela;
    @FXML private TableColumn<Movimento, Integer> ProdutoID;
    @FXML private TableColumn<Movimento, Integer> OperacaoID;
    @FXML private TableColumn<Movimento, Integer> Quantidade;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProdutoID.setCellValueFactory(new PropertyValueFactory<Movimento, Integer>("produtoID"));
        OperacaoID.setCellValueFactory(new PropertyValueFactory<Movimento, Integer>("operacaoID"));
        Quantidade.setCellValueFactory(new PropertyValueFactory<Movimento, Integer>("quantidade"));

    }
    public void showMovimentacao() {
        try {
            List<Movimento> p = new ArrayList<Movimento>();
            MovimentoDAO mov = new MovimentoDAO();

            p = mov.getAll();


//            System.out.println(p.get(0).getDescricao());
            ObservableList<Movimento> pObservable = FXCollections.observableArrayList(p);

            tabela.setItems(pObservable);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void showTelaTransacao(ActionEvent event){
        try {
            Parent loader = FXMLLoader.load(this.getClass().getResource("TelaTransacao.fxml"));
            Scene home = new Scene(loader);
            Stage app = new Stage();
            app.setScene(home);
            app.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
