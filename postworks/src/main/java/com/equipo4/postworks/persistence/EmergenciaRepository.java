package com.equipo4.postworks.persistence;

import com.equipo4.postworks.model.ContactosEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergenciaRepository extends JpaRepository<ContactosEmergencia,Long> {
}
