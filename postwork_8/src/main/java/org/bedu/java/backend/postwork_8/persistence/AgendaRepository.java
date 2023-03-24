package org.bedu.java.backend.postwork_8.persistence;

import org.bedu.java.backend.postwork_8.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Persona, Long> {
}
