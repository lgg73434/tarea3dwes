package com.saragb.tarea3dwesSara.servicios;

import java.util.List;

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

	/**
	 * Verifica las credenciales introducidas para iniciar sesión
	 * @param usuario
	 * @param contrasena
	 * @return true si coinciden || false si no coinciden
	 */
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

	
	/**
	 * Comprueba si existe un usuario a partir de un nombre de usuario
	 * @param nombreUsuario
	 * @return true si ya está registrado || false si no está registrado
	 */
	public boolean existeUsuario(String nombreUsuario) {
		return credencialesRepo.existsByUsuario(nombreUsuario.toLowerCase()); 
		
	}

	/**
	 * Método para registrar a una persona y sus credenciales en el sistema
	 * @param persona
	 * @param credenciales
	 * @return true si el registro se lleva a cabo || false si no se efectua el registro
	 */
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

	
	/**
	 * Busca una persona a partir de un nombre de usuario
	 * @param usuario
	 * @return Persona || null si no la encuentra
	 */
	public Persona findByUsuario(String usuario) {
		return credencialesRepo.findPersonaByUsuario(usuario);
	}

	
	/**
	 * Devuelve una lista con todos los usuarios registrados ordenados alfabeticamente
	 * @return lista de usuarios
	 */
	public List<Credenciales> mostrarUsuarios() {
		return credencialesRepo.findAllByOrderByUsuarioAsc();
	}


}
