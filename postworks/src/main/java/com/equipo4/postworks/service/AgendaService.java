package com.equipo4.postworks.service;


import com.equipo4.postworks.model.Persona;
import com.equipo4.postworks.persistence.AgendaMemoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AgendaService {
    private final ValidadorTelefono validadorTelefono;
    private final AgendaMemoryDao agendaDao;


    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, AgendaMemoryDao agendaDao) {
        this.validadorTelefono = validadorTelefono;
        this.agendaDao = agendaDao;
    }



    public Persona guardaPersona(Persona persona) {
        if (!validadorTelefono.isValido(persona.getTelefono())) {
            return null;
        }

        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());
        persona.setTelefono(telefono);

        return agendaDao.guardaPersona(persona);
    }

    public Set<Persona> getPersonas() {
        return agendaDao.getPersonas();
    }


}


