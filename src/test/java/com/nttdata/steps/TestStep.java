package com.nttdata.steps;

public class TestStep {

    public void metodoPrueba(){
        System.out.println("ejecucion desde step");
    }

    public void abrirPagina(String url) {
        System.out.println("Imprimir url desde step: " + url );
    }

    public void imprimirUsuarioClave(String usuario, String clave) {
        System.out.println("el usuario es - step "+usuario);
        System.out.println("la clave es -step "+clave);
    }
}
