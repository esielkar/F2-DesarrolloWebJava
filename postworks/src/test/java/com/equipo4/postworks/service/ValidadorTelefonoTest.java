package com.equipo4.postworks.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorTelefonoTest {


    @Test
    public  void testFormatea(){
        FormateadorTelefono formateador = new FormateadorTelefono();

        String resultado = formateador.formatea("5512345678");

        assertEquals("(55)-1234-5678", resultado, "Validar telefono");

    }
}