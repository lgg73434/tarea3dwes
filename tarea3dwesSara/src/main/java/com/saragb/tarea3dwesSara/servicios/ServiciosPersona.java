package com.saragb.tarea3dwesSara.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saragb.tarea3dwesSara.modelo.Persona;
import com.saragb.tarea3dwesSara.repositorios.PersonaRepository;

@Service
public class ServiciosPersona {

	@Autowired
	PersonaRepository personaRepo;

	/**
	 * Comprueba si un email ya está registrado en el sistema
	 * @param email
	 * @return true si ya existe || false si no existe
	 */ 
	public boolean isEmailRegistrado(String email) {
		return personaRepo.existsByEmail(email);

	}

	
	/**
	 * Busca una persona a partir de un nombre de usuario
	 * @param usuario
	 * @return Persona
	 */
	public Persona findPersonaByUsuario(String usuario) {
		return personaRepo.findPersonaByUsuario(usuario);
		
	}


	

	
	
	
}
