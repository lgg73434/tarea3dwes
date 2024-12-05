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


	public List<Planta> mostrarPlantas() {
		return plantaRepo.findAllByOrderByNombreComunAsc();
	}

	public boolean existeCodigo(String codigo) {
		if(plantaRepo.findByCodigo(codigo) != null)
			return true;
		
		return false;
	}

	public boolean registrarPlanta(Planta planta) {
		if(plantaRepo.save(planta) != null)
			return true;
		
		return false;
	}

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
