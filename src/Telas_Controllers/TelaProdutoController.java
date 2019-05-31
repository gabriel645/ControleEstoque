package Telas_Controllers;

import DAO.ProdutoDAO;
import Objects.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class TelaProdutoController implements Initializable {

    @FXML private javafx.scene.control.Button bt_Estoque;
    @FXML private javafx.scene.control.TextField textF_Pesquisa;
    @FXML private TableView<Produto> tabela;
    @FXML private TableColumn<Produto, String> Nome;
    @FXML private TableColumn<Produto, String> Fornecedor;
    @FXML private TableColumn<Produto, Date> DataCriacao;
    @FXML private TableColumn<Produto, Double> PrecoUnitario;

    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        Nome.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
        Fornecedor.setCellValueFactory(new PropertyValueFactory<Produto, String>("fornecedor"));
        DataCriacao.setCellValueFactory(new PropertyValueFactory<Produto, Date>("dataDeCriacao"));
        PrecoUnitario.setCellValueFactory(new PropertyValueFactory<Produto, Double>("precoUnitario"));
    }

    @FXML BorderPane PaneProduto;
    public void loadMovimentacao (ActionEvent event)  {
        try {
            Parent newLoadedPane = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
            PaneProduto.getChildren().clear();
            PaneProduto.getChildren().add(newLoadedPane);
        }catch(Exception e){
            e.printStackTrace();


        }
    }
    public void pesquisaProdutos (ActionEvent event)  {
        try {
            List<Produto> p = new ArrayList<Produto>();
            ProdutoDAO prod = new ProdutoDAO();

            if(textF_Pesquisa.getText() == null)
                p = prod.get_by_desc("");
            else
                p = prod.get_by_desc((textF_Pesquisa.getText()));

//            System.out.println(p.get(0).getDescricao());
            ObservableList<Produto> pObservable = FXCollections.observableArrayList(p);

            tabela.setItems(pObservable);



        }catch(Exception e){
            e.printStackTrace();
        }
    }

//    public void showCadastrarEditarProduto(ActionEvent event){
//        try {
//            Parent loader = FXMLLoader.load(this.getClass().getResource("CadastrarEditarProduto.fxml"));
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

}

