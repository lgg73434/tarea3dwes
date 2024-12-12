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

	
	/**
	 * Crea un nuevo ejemplar
	 * @param planta
	 * @return Ejemplar
	 */
	public Ejemplar crearEjemplar(Planta planta) {
		Planta plantaJpa = plantaRepo.findByCodigo(planta.getCodigo());
		Long nombreNum = ultimoLongEjemplar(plantaJpa);
		Ejemplar ejemplar = new Ejemplar(planta.getCodigo()+"_"+nombreNum, plantaJpa);
		
		return ejemplar;
	}

	
	/**
	 * Devuelve el id correspondiente para registrar un nuevo ejemplar
	 * @param planta
	 * @return Long
	 */
	private Long ultimoLongEjemplar(Planta planta) {
		List<Ejemplar> ejemplares = ejemplarRepo.findByPlanta(planta);
		if(ejemplares.isEmpty())
			return 1L;
		
		return ejemplares.size()+1L;
	}

	
	/**
	 * Registra un nuevo ejemplar más su mensaje inicial
	 * @param ejemplar
	 * @param mensaje
	 * @return true si se registra || false si no se ejecuta el registro
	 */
	public boolean registrarEjemplarAndMensaje(Ejemplar ejemplar, Mensaje mensaje) {
		ejemplar.getMensajes().add(mensaje);
		if(ejemplarRepo.save(ejemplar) != null)
			return true;
		
		return false;
	} 

	
	/**
	 * Devuelve una lista de ejemplares asociados a un tipo de planta
	 * @param planta
	 * @return lista de ejemplares
	 */
	public List<Ejemplar> mostrarEjemplaresPlanta(Planta planta) {
		return ejemplarRepo.findByPlanta(planta);
	}

	
	/**
	 * Devuelve una lista con todos los ejemplares existentes
	 * @return lista de ejemplares
	 */
	public List<Ejemplar> mostrarEjemplares() {
		return ejemplarRepo.findAllByOrderByNombreAsc();
	}

	
	/**
	 * Busca un ejemplar a partir de un nombre
	 * @param nombre
	 * @return Ejemplar
	 */
	public Ejemplar findEjemplarByNombre(String nombre) {
		return ejemplarRepo.findByNombre(nombre);
	}



}
