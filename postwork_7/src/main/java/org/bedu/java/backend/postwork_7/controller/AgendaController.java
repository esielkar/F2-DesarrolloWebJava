package org.bedu.java.backend.postwork_7.controller;

import org.bedu.java.backend.postwork_7.model.Persona;
import org.bedu.java.backend.postwork_7.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class AgendaController {

    private final AgendaService agendaService;


    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", agendaService.getPersonas());

        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona , Errors errors) {

        String vistaResultado = "index";
        if (errors.hasErrors()){
            vistaResultado = "index";
        } else{
            agendaService.guardaPersona(persona);
        }

        ModelAndView mav = new ModelAndView(vistaResultado);
        mav.addObject("listaPersonas", agendaService.getPersonas());
        return mav;
    }

}





