package DAO;

import DB_sql.myDB;
import Objects.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class ProdutoDAO implements DAO{

    private static Connection connection;

    public ProdutoDAO() {

        try {
            this.connection = myDB.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void add(Produto produto){
        String query = "{ call DBO.SPA_ADD_OR_UPDATE_PRODUTOS (?,?,?,?,?) }";
        ResultSet rs;

        try (CallableStatement stmt = connection.prepareCall(query)) {

            stmt.setInt(1, produto.getId());
            stmt.setString(3, produto.getFornecedor());
            stmt.setString(2, produto.getDescricao());
            Date dt = new Date();
            java.sql.Date d = new java.sql.Date (dt.getTime());
            stmt.setDate(4, d);
            stmt.setDouble(5, produto.getPrecoUnitario());

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Produto produto) {
        String query = "{ call procedureName (" + produto.getId() + ") }";
        ResultSet rs;

        try (CallableStatement stmt = connection.prepareCall(query)) {

            stmt.setInt(1, produto.getId());

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void delete(int id) {
        String query = "{ call procedureName (?) }";
//        String query = "{ call procedureName (" + id + ") }";
        ResultSet rs;

        try (CallableStatement stmt = connection.prepareCall(query)) {

            stmt.setInt(1, id);

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


//    public void update(Produto produto){}

    public  List<Produto> get_by_desc(String pesquisa) {
        List<Produto> p = new ArrayList<Produto>();
        String query = "";
        if(pesquisa.trim() != null )
            query = "{ call SPA_SELECT_PRODUTOS ('" + pesquisa + "') }";
        else
            query = "{ call SPA_SELECT_PRODUTOS ('_') }";
        ResultSet rs;

        try {

            CallableStatement stmt = connection.prepareCall(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto item = new Produto(rs.getInt("id"),
                        rs.getString("FornecedorID"),
                        rs.getString("Descricao"),
                        rs.getDate("DataCriacao"),
                        rs.getDouble("PrecoUnitario"));

                p.add(item);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;
    }

//    public void get_by_id(Produto produto){
//        String query = "{ call procedureName }";
//        ResultSet rs;
//
//        try (CallableStatement stmt = connection.prepareCall(query)) {
//
//            stmt.setInt(1, produto.getId());
//
//            rs = stmt.executeQuery();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }





