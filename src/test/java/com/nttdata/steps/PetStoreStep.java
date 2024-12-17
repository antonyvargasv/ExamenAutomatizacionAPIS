package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetStoreStep {
    Response response;
    private String URL_BASE;
    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void crearOrder(int id, int petId, int quantity) {
        String body = "{\n" +
                "  \"id\": "+id+",\n" +
                "  \"petId\": "+petId+",\n" +
                "  \"quantity\": "+quantity+",\n" +
                "  \"shipDate\": \"2024-12-17T20:36:22.957Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .header("Content-Type","application/json")
                .body(body)
                .log().all()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public void validacionRespuesta(int codigoResponse) {
        Assert.assertEquals("validacion de respuesta", codigoResponse,response.statusCode());
        System.out.println("Codigo de respuesta: "+response.statusCode());
    }


    public void consultaOrderPororderId(int petId) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri("https://petstore.swagger.io/v2")
                //.log().all()
                .get("/store/order/"+petId)
                .then()
                .log().all()
                .extract().response();
    }


}

