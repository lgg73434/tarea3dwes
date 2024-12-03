package com.saragb.tarea3dwesSara.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saragb.tarea3dwesSara.modelo.Credenciales;
import com.saragb.tarea3dwesSara.modelo.Persona;
import com.saragb.tarea3dwesSara.repositorios.CredencialesRepository;
import com.saragb.tarea3dwesSara.repositorios.PersonaRepository;

@Service
public class ServiciosCredenciales {
	
	@Autowired
	CredencialesRepository credencialesRepo;
	
	@Autowired
	PersonaRepository personaRepo;
	
	@Autowired
	private Environment environmet;


	public boolean login(String usuario, String contrasena) {
		if(usuario.equalsIgnoreCase(environmet.getProperty("spring.security.user.name"))){
			if(contrasena.equals(environmet.getProperty("spring.security.user.password"))) {
				return true;
			}
		}
		
		if (credencialesRepo.findByUsuarioAndPassword(usuario.toLowerCase(), contrasena) != null){
			return true;
		}
		
       return false;     
	}

	public boolean existeUsuario(String nombreUsuario) {
		return credencialesRepo.existsByUsuario(nombreUsuario.toLowerCase()); 
		
	}

	@Transactional
	public boolean registrarPersonaCredenciales(Persona persona, Credenciales credenciales) {
		try {
			if(personaRepo.save(persona) != null) {
				credenciales.setPersona(persona);
				if(credencialesRepo.save(credenciales) != null) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
			return false;
		}

	public Persona findByUsuario(String usuario) {
		return credencialesRepo.findPersonaByUsuario(usuario);
	}


	



}
