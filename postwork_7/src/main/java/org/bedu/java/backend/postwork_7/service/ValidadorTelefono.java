package org.bedu.java.backend.postwork_7.service;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

    @Service
    public class ValidadorTelefono {
        public String limpiaNumero(String telefono){
            return telefono.replaceAll("[^0-9]", "");
        }
    }

