package com.saragb.tarea3dwesSara.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saragb.tarea3dwesSara.modelo.Persona;

//Argumentos <Persona, Long>:
//- Persona: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Planta que lleva la anotación @Id  (clave primaria)
public interface PersonaRepository  extends JpaRepository <Persona, Long>{

	/**
	 * Comprueba si el email ya está registrado en el sistema
	 * @param email
	 * @return true si está registrado || false si no está registrado
	 */
	boolean existsByEmail(String email);
	
	
	/**
	 * Busca una persona a partir de un nombre de usuario
	 * @param usuario
	 * @return Persona || null si no existe
	 */
	@Query("SELECT p FROM Persona p JOIN p.credenciales c WHERE c.usuario = :usuario")
    Persona findPersonaByUsuario(@Param("usuario") String usuario);

}
