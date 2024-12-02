package com.saragb.tarea3dwesSara.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saragb.tarea3dwesSara.modelo.Credenciales;



//Argumentos <Credenciales, Long>:
//- Credenciales: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Credenciales que lleva la anotación @Id  (clave primaria)
@Repository
public interface CredencialesRepository extends JpaRepository <Credenciales, Long> {

	Credenciales findByUsuarioAndPassword (String usuario, String pass);
	

}
