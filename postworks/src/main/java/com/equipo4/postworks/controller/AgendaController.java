package com.equipo4.postworks.controller;

import com.equipo4.postworks.model.Persona;
import com.equipo4.postworks.persistence.AgendaRepository;
import com.equipo4.postworks.service.AgendaService;
import com.equipo4.postworks.service.FormateadorTelefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.net.URI;
import java.util.Set;

/* POSTWORK 7 */
/*@RestController
@RequestMapping("/api/v1/agenda")*/
@Controller
public class AgendaController {

    /* POSTWORK 7 */
    /*private final AgendaService agendaService;
    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }*/

    /* POSTWORK 8*/
    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaController(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }


    /* POSTWORK 6 */
    /*
    @GetMapping
    public ResponseEntity<Set<Persona>> getPersonas(){
        return ResponseEntity.ok(agendaService.getPersonas());
    }

    @PostMapping
    public ResponseEntity<Persona> guardaPersona(@RequestBody Persona persona) {
        Persona resultado = agendaService.guardaPersona(persona);

        if (resultado == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(resultado);
    }
    */

    /* POSTWORK 7 */
    /*
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
    }*/

    /* POSTWORK 8 */

    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", agendaRepository.findAll());

        return "index";
    }

    @PostMapping("/registro")
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
