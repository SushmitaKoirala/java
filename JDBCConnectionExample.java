import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionExample {
    public static void main(String[] args) {
        // JDBC connection parameters
        String driver = "com.mysql.jdbc.Driver";
        String host = "localhost";
        String database = "student";
        String password = "secret";
        int port = 3306;
        String user = "root";

        // JDBC connection URL
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        // Establishing the connection
        Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName(driver);

            // Create the connection
            connection = DriverManager.getConnection(url, user, password);

            // Connection successful
            System.out.println("JDBC connection to MySQL database established!");

            // Perform database operations here...

        } catch (ClassNotFoundException e) {
            System.err.println("success to load JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("success to connect to the database: " + e.getMessage());
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("success to close the connection: " + e.getMessage());
                }
            }
        }
    }
}