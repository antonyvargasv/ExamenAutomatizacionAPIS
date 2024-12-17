package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetStoreStep {
    Response response;
    private String URL_BASE;
    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void consultarMascota(String idMascota) {
        //Query params es despues de ?
        //path params
        // se puede colocar como .path.. .query....
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri("https://petstore.swagger.io/v2")
                //.log().all()
                .get("/pet/"+idMascota)
                .then()
                .log().all()
                .extract().response();
    }

    public void validacionRespuesta(int statusCode) {
        Assert.assertEquals("validacion de respuesta", statusCode,response.statusCode());
        System.out.println("respuesta: "+response.statusCode());
    }

    public void validarNombreMascota(String nombreMascota) {
        System.out.println("la mascota es"+ nombreMascota);
    }

    public void crearMascota(String nombre, String id) {
        String body = "{\n" +
                "    \"id\": " + 354 + ",\n" +
                "    \"name\": \"" + nombre + "\",\n" +
                "    \"status\": \"available\"\n" +
                "}";
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .header("Content-Type","application/json")
                .body(body)
                .log().all()
                .post("/pet/")
                .then()
                .log().all()
                .extract().response();
    }

    }

