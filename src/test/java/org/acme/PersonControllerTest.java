package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonControllerTest {



    @Test
    public void testGetPersonsEndpoint() {
        given()
                .when().get("/persons")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetPersonByIdEndpoint() {
        given()
                .when().get("/persons/1")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void testDeletePersonByIdEndpoint() {
        given()
                .when().delete("/persons/39")
                .then()
                .statusCode(204);
    }



}