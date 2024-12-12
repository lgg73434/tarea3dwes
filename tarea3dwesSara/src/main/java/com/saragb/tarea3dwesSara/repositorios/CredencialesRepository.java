package com.saragb.tarea3dwesSara.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saragb.tarea3dwesSara.modelo.Credenciales;
import com.saragb.tarea3dwesSara.modelo.Persona;


//Argumentos <Credenciales, Long>:
//- Credenciales: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Credenciales que lleva la anotación @Id  (clave primaria)
@Repository
public interface CredencialesRepository extends JpaRepository <Credenciales, Long> {

	/**
	 * Busca unas credenciales a partir de un nombre de usuario y una password
	 * @param usuario
	 * @param password
	 * @return Credenciales || null si no existen
	 */
	@Query(value = "SELECT * FROM credenciales WHERE BINARY usuario = :usuario AND BINARY password = :password", nativeQuery = true)
	Credenciales findByUsuarioAndPassword(@Param("usuario") String usuario, @Param("password") String password);

	
	/**
	 * Busca credenciales a partir de un nombre de usuario
	 * @param usuario
	 * @return Credenciales || null si no existen
	 */
	Credenciales findByUsuario(String usuario);

	
	/**
	 * Comprueba si existe un usuario a partir de un nombre de usuario
	 * @param usuario
	 * @return true si existe || false si no existe
	 */
	boolean existsByUsuario(String usuario);

	
	/**
	 * Busca una persona a partir de un nombre de usuario
	 * @param usuario
	 * @return Persona || null si no existe
	 */
	@Query("SELECT c.persona FROM Credenciales c WHERE c.usuario = :usuario")
	Persona findPersonaByUsuario(@Param("usuario") String usuario);

	
	/**
	 * Devuelve una lista con todas las credenciales registradas en el sistema ordenadas alfabeticamente
	 * @return lista de credenciales
	 */
	List<Credenciales> findAllByOrderByUsuarioAsc();
	
	
	

}
