package com.saragb.tarea3dwesSara.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saragb.tarea3dwesSara.modelo.Persona;

//Argumentos <Persona, Long>:
//- Persona: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Planta que lleva la anotación @Id  (clave primaria)
public interface PersonaRepository  extends JpaRepository <Persona, Long>{

	boolean existsByEmail(String email);
	
	@Query("SELECT p FROM Persona p JOIN p.credenciales c WHERE c.usuario = :usuario")
    Persona findPersonaByUsuario(@Param("usuario") String usuario);

}
