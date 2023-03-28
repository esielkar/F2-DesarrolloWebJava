package com.equipo4.postworks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMERGENCIA")
public class ContactosEmergencia {

    @Id
    private Long id;
    private String descripcion;
    private String telefono;

    public ContactosEmergencia(Long id,String descripcion, String telefono){
        this.id = id;
        this.descripcion = descripcion;
        this.telefono = telefono;
    }

}
