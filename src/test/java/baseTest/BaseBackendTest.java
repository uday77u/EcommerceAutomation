package baseTest;

import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ConfigReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseBackendTest {
    protected static Connection dbConnection;

    @BeforeClass
    public void backendSetup() {
        ConfigReader.loadProperties("config.properties");

        // API setup
        RestAssured.baseURI = ConfigReader.getProperty("apiBaseUrl");

        // DB setup
        try {
            String dbUrl = ConfigReader.getProperty("dbUrl");
            String dbUser = ConfigReader.getProperty("dbUser");
            String dbPassword = ConfigReader.getProperty("dbPassword");
            dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException("DB Connection Failed: " + e.getMessage());
        }
    }

    @AfterClass
    public void backendTeardown() {
        if (dbConnection != null) {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                System.out.println("Error closing DB connection: " + e.getMessage());
            }
        }
    }
}
