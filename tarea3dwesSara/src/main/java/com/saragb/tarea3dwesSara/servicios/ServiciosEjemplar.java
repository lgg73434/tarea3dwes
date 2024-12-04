package com.saragb.tarea3dwesSara.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saragb.tarea3dwesSara.modelo.Ejemplar;
import com.saragb.tarea3dwesSara.modelo.Mensaje;
import com.saragb.tarea3dwesSara.modelo.Planta;
import com.saragb.tarea3dwesSara.repositorios.EjemplarRepository;
import com.saragb.tarea3dwesSara.repositorios.PlantaRepository;

@Service
public class ServiciosEjemplar {
	
	@Autowired
	EjemplarRepository ejemplarRepo;
	
	@Autowired
	PlantaRepository plantaRepo;

	public Ejemplar crearEjemplar(Planta planta) {
		Planta plantaJpa = plantaRepo.findByCodigo(planta.getCodigo());
		Long nombreNum = ultimoLongEjemplar(plantaJpa);
		Ejemplar ejemplar = new Ejemplar(planta.getCodigo()+"_"+nombreNum, plantaJpa);
		
		return ejemplar;
	}

	private Long ultimoLongEjemplar(Planta planta) {
		List<Ejemplar> ejemplares = ejemplarRepo.findByPlanta(planta);
		if(ejemplares.isEmpty())
			return 1L;
		
		return ejemplares.size()+1L;
	}

	public boolean registrarEjemplarAndMensaje(Ejemplar ejemplar, Mensaje mensaje) {
		ejemplar.getMensajes().add(mensaje);
		if(ejemplarRepo.save(ejemplar) != null)
			return true;
		
		return false;
	} 

	public List<Ejemplar> mostrarEjemplaresPlanta(Planta planta) {
		return ejemplarRepo.findByPlanta(planta);
	}

	public List<Ejemplar> mostrarEjemplares() {
		return ejemplarRepo.findAllByOrderByNombreAsc();
	}

	public Ejemplar findEjemplarByNombre(String nombre) {
		return ejemplarRepo.findByNombre(nombre);
	}



}
