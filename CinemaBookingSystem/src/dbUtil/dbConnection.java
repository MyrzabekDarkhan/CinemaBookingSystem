package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    // JDBC driver name and database URL
    private static final String SCONN = "jdbc:sqlite:Cinema.sqlite";


    public static Connection getConnection()
            throws SQLException {
        //try block
        try {
            // Register JDBC driver
            Class.forName("org.sqlite.JDBC");

            //Opening a connection
            return DriverManager.getConnection(SCONN);
        }
        //catch block
        catch (ClassNotFoundException | SQLException ex) {
            //Handle errors for JDBC
            ex.printStackTrace();
        }
        return null;
    }


}