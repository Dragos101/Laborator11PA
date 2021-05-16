package ro.info.uaic.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    private Database() {

    }

    public static Connection getConnection() throws SQLException, SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dragos", "dragos");
        }
        return connection;
    }
}
