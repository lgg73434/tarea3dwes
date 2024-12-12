package com.saragb.tarea3dwesSara.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saragb.tarea3dwesSara.modelo.Planta;
import com.saragb.tarea3dwesSara.repositorios.PlantaRepository;



@Service
public class ServiciosPlanta {
	
	@Autowired
	PlantaRepository plantaRepo;


	/**
	 * Muestra todas las plantas registradas en el sistema
	 * @return lista de plantas
	 */
	public List<Planta> mostrarPlantas() {
		return plantaRepo.findAllByOrderByNombreComunAsc();
	}

	
	/**
	 * Comprueba si un código ya está registrado en el sistema
	 * @param codigo
	 * @return true si existe || false si no existe
	 */
	public boolean existeCodigo(String codigo) {
		if(plantaRepo.findByCodigo(codigo) != null)
			return true;
		
		return false;
	}

	
	/**
	 * Notifica si el registro de una nueva planta se efectua con exito
	 * @param planta
	 * @return true si se efectua el registro || false si falla el registro
	 */
	public boolean registrarPlanta(Planta planta) {
		if(plantaRepo.save(planta) != null)
			return true;
		
		return false;
	}

	
	/**
	 * Notifica si los datos de una planta se actualizan correctamente
	 * @param plantaNueva
	 * @return true si se efectua el cambio || false si no se efectua el cambio
	 */
	public boolean actualizarPlanta(Planta plantaNueva) {
		Planta plantaVieja = plantaRepo.findByCodigo(plantaNueva.getCodigo());
		
		plantaVieja.setNombreComun(plantaNueva.getNombreComun());
		plantaVieja.setNombreCientifico(plantaNueva.getNombreCientifico());
		
		if(plantaRepo.save(plantaVieja) != null) {
			return true;
		}
		
		return false;
	}
	
	

}
