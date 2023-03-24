package org.bedu.java.backend.postwork_8.controller;

import org.bedu.java.backend.postwork_8.model.Persona;
import org.bedu.java.backend.postwork_8.persistence.AgendaRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AgendaController {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaController(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", agendaRepository.findAll());

        return "index";
    }

    @PostMapping("/index")
    public ModelAndView registra(@Valid Persona persona , Errors errors) {

        String vistaResultado = "index";
        if (errors.hasErrors()){
            vistaResultado = "index";
        } else {
            agendaRepository.save(persona);
        }

        ModelAndView mav = new ModelAndView(vistaResultado);
        mav.addObject("listaPersonas", agendaRepository.findAll());
        return mav;
    }

}
