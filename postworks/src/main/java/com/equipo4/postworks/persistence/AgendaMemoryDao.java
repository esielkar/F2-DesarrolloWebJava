package com.equipo4.postworks.persistence;

import com.equipo4.postworks.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Repository
public class AgendaMemoryDao {
    private static final SortedSet<Persona> personas = new TreeSet<>();

    public Persona guardaPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }


    public Set<Persona> getPersonas() {
        return personas;
    }
}
