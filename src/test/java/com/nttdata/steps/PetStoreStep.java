package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;

public class PetStoreStep {
    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void crearOrder(int id, int petId, int quantity) {
        String body = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"petId\": " + petId + ",\n" +
                "  \"quantity\": " + quantity + ",\n" +
                "  \"shipDate\": \"2024-12-17T20:36:22.957Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .body(body)
                .log().all()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public void validacionRespuesta(int codigoResponse) {
        Assert.assertEquals("validacion de respuesta", codigoResponse, response.statusCode());
        System.out.println("Codigo de respuesta: " + response.statusCode());
    }


    public void consultaOrderPororderId(int petId) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri("https://petstore.swagger.io/v2")
                .log().all()
                .get("/store/order/" + petId)
                .then()
                .log().all()
                .extract().response();
    }

    public void validarRespuestaID(int id, int petId, int quantity, String status, String complete) {
        assertThat(response.body().path("id"), CoreMatchers.equalTo(id));
        assertThat(response.body().path("petId"), CoreMatchers.equalTo(petId));
        assertThat(response.body().path("quantity"), CoreMatchers.equalTo(quantity));
        assertThat(response.body().path("status"), CoreMatchers.equalTo(status));
        Assert.assertTrue(response.body().path("complete"));
        System.out.println("test terminado *******");
    }
}

