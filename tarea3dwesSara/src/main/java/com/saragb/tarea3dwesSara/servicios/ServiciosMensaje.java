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

	public List<Mensaje> getMensajesPorEjemplar(Ejemplar ejemplar) {
		return mensajeRepo.findByEjemplar(ejemplar);
	}

	public boolean saveMensaje(Mensaje men) {
		if(mensajeRepo.save(men) != null)
			return true;
		
		return false;
	}

	public List<Mensaje> findByPersona(Persona persona) {
		return mensajeRepo.findByPersona(persona);
	}

	public List<Mensaje> MensajesPorFechas(LocalDateTime fechaHora1, LocalDateTime fechaHora2) {
		return mensajeRepo.findMensajesPorFechas(fechaHora1, fechaHora2);
	}

	public List<Mensaje> getMensajesPorPlanta(String nombreComun) {
		return mensajeRepo.findMensajesByNombrePlanta(nombreComun);
	}

}
