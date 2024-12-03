package com.saragb.tarea3dwesSara.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saragb.tarea3dwesSara.modelo.Ejemplar;
import com.saragb.tarea3dwesSara.modelo.Mensaje;
import com.saragb.tarea3dwesSara.repositorios.MensajeRepository;

@Service
public class ServiciosMensaje {
	
	@Autowired
	MensajeRepository mensajeRepo;

	public List<Mensaje> getMensajesPorEjemplar(Ejemplar ejemplar) {
		return mensajeRepo.findByEjemplar(ejemplar);
	}

}
