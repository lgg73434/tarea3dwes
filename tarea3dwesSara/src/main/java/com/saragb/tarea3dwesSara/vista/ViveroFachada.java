package com.saragb.tarea3dwesSara.vista;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.saragb.tarea3dwesSara.modelo.Credenciales;
import com.saragb.tarea3dwesSara.modelo.Persona;
import com.saragb.tarea3dwesSara.modelo.Planta;
import com.saragb.tarea3dwesSara.servicios.Controlador;
import com.saragb.tarea3dwesSara.servicios.SesionActiva;
import com.saragb.tarea3dwesSara.utilidades.Validar;

@Controller
public class ViveroFachada {

	private static ViveroFachada portalVivero;

	@Autowired
	SesionActiva sesion;
	
	@Autowired
	Controlador controlador;
	
	@Autowired
	MenuPlantas menuPlantas;
	
	@Autowired
	MenuEjemplares menuEjemplares;
	
	@Autowired
	MenuMensajes menuMensajes;
	
	Scanner scanner = new Scanner(System.in);
	
		
	public static ViveroFachada getPortal() {
		if (portalVivero == null)
			portalVivero = new ViveroFachada();
		return portalVivero;
	}

	
	/**
	 * Inicia el programa mostrando un mensaje de bienvenida y luego muestra el menú principal.
	 * Después de ejecutar las acciones, cierra el scanner.
	 */
	public void iniciarPrograma() {
		System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
		System.out.println("*** ¡¡Bienvenido a Vivero GestionApp!! ***");
		System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		mostrarMenuPrincipal();
		scanner.close();
	}

	
	/**
	 * Muestra el menú principal del programa y gestiona las opciones seleccionadas por el usuario.
	 * Ofrece tres opciones:
	 * 1. Ver plantas (Modo invitado).
	 * 2. Iniciar sesión con usuario y contraseña.
	 * 3. Salir del programa.
	 * 
	 * El método permite al usuario interactuar con el programa mediante un ciclo que valida la entrada
	 * y ejecuta acciones correspondientes a cada opción. Si se selecciona la opción de inicio de sesión,
	 * se valida el usuario y la contraseña, y en caso de éxito, muestra el menú adecuado según el rol del usuario.
	 * 
	 * Si el usuario selecciona la opción 1, se muestran las plantas registradas en el vivero.
	 * En caso de seleccionar una opción no válida, el programa muestra un mensaje de error.
	 */
	public void mostrarMenuPrincipal() {

		int opcion = 0;
		do {
			System.out.println("\n-------------------------------");
			System.out.println("      ¿Qué quieres hacer?");
			System.out.println("-------------------------------");
			System.out.println("Selecciona una opción:");
			System.out.println("1.  Ver plantas (Modo invitado)");
			System.out.println("2.  Login");
			System.out.println("3.  Salir");

			try {
				opcion = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("Opción no válida. Debes introducir un número entero.");
				scanner.next(); // Limpiar el buffer de entrada
				continue; // Volver a pedir la opción
			}

			switch (opcion) {
			case 1:
				List<Planta> plantas = controlador.getServiciosPlanta().mostrarPlantas();
				if (plantas.isEmpty()) {
					System.out.println("Aún no hay plantas registradas en el vivero.");
				} else {
					System.out.println("\n______ Plantas registradas en el vivero ______");
					for (int i = 0; i < plantas.size(); i++) {
						System.out.println((i + 1) + ". "+ plantas.get(i).getNombreComun() +" - "+ plantas.get(i).getNombreCientifico());
					}
				}
				break;

			case 2:
				boolean valido = false;
				do {
					
					System.out.print("\nIntroduce tu usuario: ");
					String usuario = scanner.nextLine();
					System.out.print("Introduce tu contraseña: ");
					String contrasena = scanner.nextLine();

					if (controlador.getServiciosCredenciales().login(usuario, contrasena)) {
						valido = true;
						sesion.setUsuario(usuario);
						System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						System.out.println("\t¡Hola "+sesion.getUsuario()+"!");
						System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
						if (usuario.equalsIgnoreCase("admin")) {
							mostrarMenuAdministrador();

						} else {
							mostrarMenuPersonal();
						}

					} else {
						System.err.println("\nUsuario o contraseña incorrectos.");
					}
				} while (!valido);

				break;

			case 3:
				System.out.println("\n¡Adios!");
				break;

			default:
				System.err.println("Opción incorrecta.");
			}

		} while (opcion != 3);
	}


	public void mostrarMenuAdministrador() {

		int opcion = 0;

		do {
			System.out.println("\n-----------------------------");
			System.out.println("     ¿Qué quieres hacer?");
			System.out.println("-----------------------------");
			System.out.println("Selecciona una opción:");
			System.out.println("1.  Gestionar plantas");
			System.out.println("2.  Gestionar ejemplares");
			System.out.println("3.  Gestionar mensajes");
			System.out.println("4.  Registrar usuario");
			System.out.println("5.  Cerrar sesión");
			System.out.println("6.  Cerrar sesión y salir");

			try {
				opcion = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("Opción no válida. Por favor, introduce un número entero.");
				scanner.nextLine(); // Limpiar el buffer de entrada
				continue; // Volver a pedir la opción
			}

			switch (opcion) {
			case 1:
				menuPlantas.mostrarMenuGestionarPlantas();
				break;

			case 2:
			
				menuEjemplares.mostrarMenuGestionarEjemplares(sesion);
				break;

			case 3:
				menuMensajes.mostrarMenuGestionarMensajes(sesion);
				break;

			case 4:
				System.out.println("\n-----------------------------");
				System.out.println("** Registrar nuevo usuario **");
				System.out.println("-----------------------------");

				String nombre = "";
				String email = "";
				String nombreUsuario = "";
				String contrasena = "";

				do {
					System.out.println("Introduce un nombre:");
					nombre = scanner.nextLine();

					if (!Validar.validarNombre(nombre)) {
						System.err.println("Caracteres no válidos en el nombre.");
					} else {
						break;
					}

				} while (true);

				do {
					System.out.println("Introduce un email:");
					email = scanner.nextLine();

					if (!Validar.validarEmail(email)) {
						System.err.println("Formato de email no válido.");
					}

					if (controlador.getServiciosPersona().isEmailRegistrado(email)) {
						System.err.println("Email ya registrado en el sistema.");
					}

					if (Validar.validarEmail(email) && !controlador.getServiciosPersona().isEmailRegistrado(email)) {
						break;
					}

				} while (true);

				do {
					System.out.println("Introduce un nombre de usuario:");
					nombreUsuario = scanner.nextLine();

					if (!Validar.validarNombreUsuario(nombreUsuario)) {
						System.err.println("El nombre de usuario no puede contener espacios.");
					}

					if (controlador.getServiciosCredenciales().existeUsuario(nombreUsuario)) {
						System.err.println("El nombre de usuario ya existe.");
					}

					if (Validar.validarNombreUsuario(nombreUsuario) && !controlador.getServiciosCredenciales().existeUsuario(nombreUsuario)) {
						break;
					}

				} while (true);

				do {
					System.out.println("Introduce una contraseña:");
					contrasena = scanner.nextLine();

					if (!Validar.validarContrasena(contrasena)) {
						System.err.println(
								"La contraseña debe tener entre 6 y 10 caracteres (letras y/o números).");
					} else {
						break;
					}

				} while (true);

				Persona persona = new Persona(nombre, email.toLowerCase());
				Credenciales credenciales = new Credenciales(nombreUsuario.toLowerCase(), contrasena);
				if (controlador.getServiciosCredenciales().registrarPersonaCredenciales(persona, credenciales)) {
					System.out.println("Nuevo usuario registrado con éxito\n");
					
				} else {
					System.err.println("Error al registrar al nuevo usuario.\n");
				}
				break;

			case 5:
				sesion.cerrarSesion();
				return;

			case 6:
				System.out.println("\n¡Adios!");
				System.exit(0);

			default:
				System.err.println("Opción incorrecta.");
			}

		} while (opcion != 6);
	}
	
	
	public void mostrarMenuPersonal() {

		int opcion = 0;
		do {
			System.out.println("\n-----------------------------");
			System.out.println("     ¿Qué quieres hacer?");
			System.out.println("-----------------------------");
			System.out.println("Seleccione una opción:");
			System.out.println("1.  Gestionar ejemplares");
			System.out.println("2.  Gestionar mensajes");
			System.out.println("3.  Cerrar sesión");
			System.out.println("4.  Cerrar sesión y salir");

			try {
				opcion = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("Opción no válida. Por favor, introduce un número entero.");
				scanner.nextLine(); // Limpiar el buffer de entrada
				continue; // Volver a pedir la opción
			}

			switch (opcion) {
			case 1:
				menuEjemplares.mostrarMenuGestionarEjemplares(sesion);
				break;

			case 2:
				menuMensajes.mostrarMenuGestionarMensajes(sesion);
				break;

			case 3:
				sesion.cerrarSesion();;
				return;

			case 4:
				System.out.println("\n¡Adios!");
				System.exit(0);

			default:
				System.err.println("Opción incorrecta.");
			}

		} while (opcion != 4);

	}
	
	
	public void cerrarScanner() {
		if (scanner != null) {
			scanner.close(); // Cierra el Scanner cuando se termina de usar
		}

	}
	
	
}
