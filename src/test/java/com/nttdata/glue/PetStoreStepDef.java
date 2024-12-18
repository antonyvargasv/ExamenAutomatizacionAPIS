package com.nttdata.glue;

import com.nttdata.steps.PetStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;


public class PetStoreStepDef {
    @Steps
    PetStoreStep tienda;

    @Given("la url es {string}")
    public void laUrlEs(String url) {
        tienda.definirURL(url);
    }

    @When("creo el order con  {int}, {int} y {int}")
    public void creoElOrderConIdPetIdYQuantity(int id, int petId, int quantity) {
        tienda.crearOrder(id, petId, quantity);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSeaCodigoResponse(int codigoResponse) {
        tienda.validacionRespuesta(codigoResponse);
    }

    @When("consulto el order con {int}")
    public void consultoElOrderConOrderID(int id) {
        tienda.consultaOrderPororderId(id);
    }

    @And("valida datos de respuesta {int}, {int}, {int}, {string}, {string}")
    public void validaDatosDeRespuestaIdPetIdQuantity(int id, int petId, int quantity, String status, String complete) {
        tienda.validarRespuestaID(id, petId, quantity, status, complete);
    }
}
