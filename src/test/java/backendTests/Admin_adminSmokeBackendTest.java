package backendTests;

import org.testng.annotations.Test;

import baseTest.BaseBackendTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.sql.ResultSet;
import java.sql.Statement;

public class Admin_adminSmokeBackendTest extends BaseBackendTest {

    @Test
    public void verifyAdminUserAPIAndDB() throws Exception {
        // API validation
        given()
            .when().get("/admin/users")
            .then().statusCode(200)
            .body("size()", greaterThan(0));

        // DB validation
        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM admin_users");
        rs.next();
        int count = rs.getInt(1);
        assert count > 0 : "No admin users found in DB";
    }
}
