package DAO;

import DB_sql.myDB;
import Objects.Movimento;
import Objects.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimentoDAO implements DAO {

    private Connection connection;

    public MovimentoDAO() {

        try {
            this.connection = myDB.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void add(Movimento movimento) {
        String query = "{ call procedureName SPA_ADD_MOVIMENTO (?,?,?)}";
        ResultSet rs;

        try (CallableStatement stmt = connection.prepareCall(query)) {

//            stmt.setInt(1, movimento.getId());
            stmt.setInt(1, movimento.getProdutoId());
            stmt.setInt(2, movimento.getOperacaoId());
            stmt.setInt(3, movimento.getQuantidade());

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Movimento movimento) {
        String query = "{ call procedureName (?) }";
        ResultSet rs;

        try (CallableStatement stmt = connection.prepareCall(query)) {

            stmt.setInt(1, movimento.getId());

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


//    public void update(Produto produto){}

    public List<Movimento> getAll() {

        List<Movimento> p = new ArrayList<Movimento>();
        String query = "{ call SPA_SELECT_MOVIMENTOS ('_') }";
        ResultSet rs;

        try {

            CallableStatement stmt = connection.prepareCall(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Movimento item = new Movimento(rs.getInt("id"),
                        rs.getInt("produtoId"),
                        rs.getInt("operacaoId"),
                        rs.getInt("quantidade"));

                p.add(item);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;
    }


//    public void get_by_id(Movimento produto) {
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
//    }
}