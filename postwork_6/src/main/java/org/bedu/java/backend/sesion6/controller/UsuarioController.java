package org.bedu.java.backend.sesion6.controller;

import org.bedu.java.backend.sesion6.model.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

//    @PostMapping("/{id}")
    @PostMapping("/{id}")
    public String creaUsuario(@RequestBody Usuario usuario, @PathVariable("id") long id){
        System.out.println("Creando usuario");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Usuario: " + usuario.getUsuario());
        System.out.println("E-Mail: " + usuario.getCorreoElectronico());

        return "Usuario " + id + " Creado";
    }

    @PostMapping
    public String creaUsuario(@RequestBody Usuario usuario, @RequestParam("id") long id, @RequestParam("rol") String rol){
        System.out.println("Creando usuario");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Usuario: " + usuario.getUsuario());
        System.out.println("E-Mail: " + usuario.getCorreoElectronico());
        System.out.println("Rol: " + rol);

        return "Usuario " + id + " Creado";
    }

}
