package org.bedu.java.backend.postwork5;

import org.bedu.java.backend.postwork5.model.Persona;
import org.bedu.java.backend.postwork5.service.FormateadorTelefono;
import org.bedu.java.backend.postwork5.service.ValidadorTelefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class Postwork5Application implements CommandLineRunner {

	private final ValidadorTelefono validadorTelefono;
	private final FormateadorTelefono formateadorTelefono;

	@Autowired
	public Postwork5Application(ValidadorTelefono validadorTelefono, FormateadorTelefono formateadorTelefono) {
		this.validadorTelefono = validadorTelefono;
		this.formateadorTelefono = formateadorTelefono;
	}

	public static void main(String[] args) {
		SpringApplication.run(Postwork5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner reader = new Scanner(System.in);

		System.out.println("Cual es tu nombre: ");
		String nombre = reader.nextLine();

		System.out.println("Cual es tu telefono: ");
		String telefono = reader.nextLine();

		if (validadorTelefono.isValido(telefono)) {
			telefono = validadorTelefono.limpiaNumero(telefono);
			telefono = formateadorTelefono.formatea(telefono);

			Persona persona = new Persona(nombre, telefono);

			System.out.println(persona);
		} else {
			System.out.println("Por favor, introduce un numero valido");
		}
	}
}