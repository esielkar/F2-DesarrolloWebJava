package com.equipo4.postworks.runners;

import com.equipo4.postworks.model.ContactosEmergencia;
import com.equipo4.postworks.persistence.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmergenciaRunner implements CommandLineRunner {

    private final EmergenciaRepository emergenciaRepository;

    @Autowired
    public EmergenciaRunner(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        emergenciaRepository.deleteAll();
        List<ContactosEmergencia> lista = Arrays.asList(
                creaContactoEmergencia(3L,"Emergencias", "911"),
                creaContactoEmergencia(2L,"Cruz Roja", "44-2229-0505"),
                creaContactoEmergencia(1L,"Locatel", "*0311")
        );
        emergenciaRepository.saveAll(lista);
    }

    public ContactosEmergencia creaContactoEmergencia(Long id,String descripcion, String telefono) {
        return new ContactosEmergencia(id,descripcion, telefono);
    }
}
