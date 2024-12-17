package com.nttdata.glue;

import com.nttdata.steps.TestStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class TestStepDef {
    //Se utiliza la etiqueta @Steps para evitar instanciar.
    //TestStep obj = new TestStep();
    @Steps
    TestStep obj;
    @Given("prueba de assertion")
    public void pruebaDeAssertion() {
        //Los Assert deberian utilizar en un step ya que en step def. solo se realiza llamado a la clase y metodo.
        //Assert.assertEquals("Validacion de respuesta", "hola","hola");
        //Assert.assertTrue(false);
        //Assert.assertEquals(200,2000);
        obj.metodoPrueba();
    }

    @When("pruebo un servicio url {string}")
    public void prueboUnServicioUrl(String url) {
        obj.abrirPagina(url);
    }


    @When("inicio sesion con {string} y {string}")
    public void inicioSesionConY(String usuario, String clave) {
        obj.imprimirUsuarioClave(usuario,clave);

    }
}
