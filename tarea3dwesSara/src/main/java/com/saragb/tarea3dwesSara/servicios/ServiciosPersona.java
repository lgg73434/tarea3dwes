package com.saragb.tarea3dwesSara.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saragb.tarea3dwesSara.modelo.Persona;
import com.saragb.tarea3dwesSara.repositorios.PersonaRepository;

@Service
public class ServiciosPersona {

	@Autowired
	PersonaRepository personaRepo;

	public boolean isEmailRegistrado(String email) {
		return personaRepo.existsByEmail(email);

	}

	public Persona findPersonaByUsuario(String usuario) {
		return personaRepo.findPersonaByUsuario(usuario);
		
	}


	

	
	
	
}
