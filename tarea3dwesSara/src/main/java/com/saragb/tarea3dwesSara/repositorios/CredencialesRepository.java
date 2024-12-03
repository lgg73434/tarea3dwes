package com.saragb.tarea3dwesSara.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saragb.tarea3dwesSara.modelo.Credenciales;




//Argumentos <Credenciales, Long>:
//- Credenciales: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Credenciales que lleva la anotación @Id  (clave primaria)
@Repository
public interface CredencialesRepository extends JpaRepository <Credenciales, Long> {

	@Query(value = "SELECT * FROM credenciales WHERE BINARY usuario = :usuario AND BINARY password = :password", nativeQuery = true)
	Credenciales findByUsuarioAndPassword(@Param("usuario") String usuario, @Param("password") String password);

	Credenciales findByUsuario(String usuario);

	boolean existsByUsuario(String usuario);
	
	
	

}
