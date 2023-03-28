package com.equipo4.postworks.controller;

import static org.mockito.Mockito.*;
import com.equipo4.postworks.model.Persona;
import com.equipo4.postworks.persistence.AgendaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

class AgendaControllerTest {

    @Mock
    private AgendaRepository agendaRepository;

    @Mock
    private Model model;

    @Mock
    private Errors errors;

    @InjectMocks
    private AgendaController agendaController;

    @Test
    void formularioRegistro() {
        MockitoAnnotations.openMocks(this);
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Juan", "555-123-4567"));
        when(agendaRepository.findAll()).thenReturn(listaPersonas);

        String result = agendaController.formularioRegistro(model);

        verify(model, times(1)).addAttribute(eq("persona"), any(Persona.class));
        verify(model, times(1)).addAttribute(eq("listaPersonas"), eq(listaPersonas));
        assert(result.equals("index"));
    }

    @Test
    void registra() {
        MockitoAnnotations.openMocks(this);
        Persona persona = new Persona("Roberto","555-123-4567");
        when(errors.hasErrors()).thenReturn(false);

        ModelAndView result = agendaController.registra(persona, errors);

        verify(agendaRepository, times(1)).save(eq(persona));
        assert(result.getViewName().equals("index"));
        assert(result.getModelMap().get("listaPersonas") instanceof List);
    }

}