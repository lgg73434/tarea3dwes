package com.saragb.tarea3dwesSara.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saragb.tarea3dwesSara.modelo.Planta;


@Repository
//Argumentos <Planta, Long>:
// - Planta: clase con la que va a trabajar
// - Long: Tipo de dato que corresponde al atributo de Planta que lleva la anotación @Id (clave primaria)
public interface PlantaRepository extends JpaRepository <Planta, Long>{

	/**
	 * Busca una planta a partir de un código
	 * @param codigo
	 * @return Planta || null si no existe
	 */
	Planta findByCodigo(String codigo);

	/**
	 * Devuelve una lista de las plantas registradas por orden alfabético
	 * @return lista de plantas
	 */
	List<Planta> findAllByOrderByNombreComunAsc();
	
}
