package com.equipo4.postworks.persistence;

import com.equipo4.postworks.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Persona, Long> {
}
