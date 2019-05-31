package DAO;

import DB_sql.myDB;
import Objects.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FornecedorDAO implements DAO{

    private Connection connection;

    public FornecedorDAO() {

        try {
            this.connection = myDB.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void add(Fornecedor fornecedor){


        String query = "{ call DBO.SPA_ADD_OR_UPDATE_FORNCECEDORES (?) }";
        ResultSet rs;

        try (CallableStatement stmt = connection.prepareCall(query)) {

//            stmt.setInt(1, fornecedor.getId());
            stmt.setString(1, fornecedor.getDescricao());

            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Fornecedor fornecedor) {
        String query = "{ call procedureName }";
        ResultSet rs;

        try (CallableStatement stmt = connection.prepareCall(query)) {

            stmt.setInt(1, fornecedor.getId());

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


//    public void update(Produto produto){}

    public List<Fornecedor> get_by_desc() {
        List<Fornecedor> p = new ArrayList<Fornecedor>();
        String query = "{ call SPA_SELECT_FORNECEDORES ('_') }";
        ResultSet rs;

        try (CallableStatement stmt = connection.prepareCall(query)) {

            rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor item = new Fornecedor(rs.getInt("id"),
                        rs.getString("Fornecedor"));

                p.add(item);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;
    }

    public void get_by_id(Fornecedor fornecedor){
        String query = "{ call procedureName }";
        ResultSet rs;

        try (CallableStatement stmt = connection.prepareCall(query)) {

            stmt.setInt(1, fornecedor.getId());

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }




}

