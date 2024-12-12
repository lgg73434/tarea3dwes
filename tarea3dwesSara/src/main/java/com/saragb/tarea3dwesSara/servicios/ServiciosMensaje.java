package com.saragb.tarea3dwesSara.servicios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saragb.tarea3dwesSara.modelo.Ejemplar;
import com.saragb.tarea3dwesSara.modelo.Mensaje;
import com.saragb.tarea3dwesSara.modelo.Persona;
import com.saragb.tarea3dwesSara.repositorios.MensajeRepository;

@Service
public class ServiciosMensaje {
	
	@Autowired
	MensajeRepository mensajeRepo;

	
	/**
	 * Filtra los mensajes a partir de un ejemplar en concreto
	 * @param ejemplar
	 * @return lista de mensajes
	 */
	public List<Mensaje> getMensajesPorEjemplar(Ejemplar ejemplar) {
		return mensajeRepo.findByEjemplar(ejemplar);
	}

	
	/**
	 * Registra un nuevo mensaje
	 * @param mensaje
	 * @return true si se efectua el registro || false si no se efectua el registro
	 */
	public boolean saveMensaje(Mensaje mensaje) {
		if(mensajeRepo.save(mensaje) != null)
			return true;
		
		return false;
	}

	
	/**
	 * Filtra los mensajes a partir de una persona
	 * @param persona
	 * @return lista de mensajes
	 */
	public List<Mensaje> findByPersona(Persona persona) {
		return mensajeRepo.findByPersona(persona);
	}

	
	/**
	 * Filtra los mensajes a partir de una fecha incial y otra final
	 * @param fechaHora1
	 * @param fechaHora2
	 * @return lista de mensajes
	 */
	public List<Mensaje> MensajesPorFechas(LocalDateTime fechaHora1, LocalDateTime fechaHora2) {
		return mensajeRepo.findMensajesPorFechas(fechaHora1, fechaHora2);
	}

	
	/**
	 * Filtra mensajes a partir de un tipo de planta
	 * @param nombreComun
	 * @return lista de mensajes
	 */
	public List<Mensaje> getMensajesPorPlanta(String nombreComun) {
		return mensajeRepo.findMensajesByNombrePlanta(nombreComun);
	}

}
