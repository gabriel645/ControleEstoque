package DB_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myDB {

    public static Connection getConnection(){
        try{
            String url = "jdbc:sqlserver://localhost:49678;databaseName=SPA;integratedSecurity=true";

            Connection conn = DriverManager.getConnection(url);

            conn.setAutoCommit(true);

            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
