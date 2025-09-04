package api.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class BaseTest {
    protected static final String BASE_URL = "https://fakerapi.it/api/v1";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    protected Response getCompaniesWithQuantity(int quantity) {
        return given()
                .when()
                .get("/companies?_quantity=" + quantity)
                .then()
                .extract()
                .response();
    }

    protected Response getCompanies() {
        return given()
                .when()
                .get("/companies")
                .then()
                .extract()
                .response();
    }
}
