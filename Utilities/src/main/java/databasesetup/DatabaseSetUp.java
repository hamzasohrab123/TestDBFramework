package databasesetup;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.*;

public class DatabaseSetUp {

    public static Connection connection = null;

    public static final String username = "postgres";
    public static final String password = "postgres2101";
    public static final String hostname = "database-1.cen58y5cse53.us-east-1.rds.amazonaws.com";
    public static final String portnumber = "5432";
    public static final String database = "dvdrental";

    //jdbc:postgresql://host:port/database
    //jdbc:postgresql is the protocol for postgres
    final String url = "jdbc:postgresql://" + hostname + ":" + portnumber + "/" + database;

    @BeforeMethod
    public Connection setUp() throws SQLException {

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;

    }

    @AfterMethod
    public void tearDown() throws Exception {

        // Close DB connection
        if (connection != null) {
            connection.close();

        }
    }

}
