package Telas_Controllers;

import DAO.ProdutoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Objects.Fornecedor;
import DAO.FornecedorDAO;

public class CadastrarEditarFornecedoresController {

    @FXML
    private javafx.scene.control.TextField textF_Nome;
    @FXML private javafx.scene.control.TextField textF_Desc;



    public void add_edit(ActionEvent event){
        try {
            FornecedorDAO prod = new FornecedorDAO();
            Fornecedor f = new Fornecedor(Integer.parseInt(textF_Nome.getText()),textF_Desc.getText() );
            prod.add(f);


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
