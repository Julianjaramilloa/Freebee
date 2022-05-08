package ui;

import java.util.Scanner;

import logic.User;
import logic.UserList;

public class Console {
	private UserList userList;
	Scanner sc = new Scanner(System.in);//Para prevenir problemas con Scanners multiples
	final String cont = "¿Quieres seguir en la app?";
	
	public Console(boolean loadData) {
		userList = new UserList();
		if(loadData) {
			userList.readAndLoadData();
		}
	}
	
	public void mainMenu() {
		
		System.out.println("\n          Hola de nuevo. Bienvenido a freebee");
		System.out.println("       El mejor gestor de tus finanzas personales\n");
		
		
		
		boolean exit = false;
		while(!exit) {
			printMenuOptions();
			String option = sc.nextLine();
			int opt;
			try{
				 opt = Integer.parseInt(option);
			}catch(NumberFormatException nfe) {
				System.err.println("La entrada que pusiste no es un número. Vuelve a seleccionar una opción");
				continue;
			}
			switch(opt) {
			case 1:
				userMenu();
				if(!choice(cont)) {
					exit=true;
				}
				break;
			case 2:
				createUserMenu();
				if(!choice(cont)){
					exit=true;
				}
				break;
			case 3:
				appInfo();
				if(!choice(cont)) {
					exit=true;
				}
				break;
			case 4:
				System.out.println("Gracias por usar freebee");
				System.exit(0);
				break;
			case 5:
				System.out.println(userList.users.toString());
				break;
			default:
				System.err.println("No escogiste un número correcto. Escoge solo las opciones disponibles");
				printMenuOptions();
			}
		}
		
		sc.close();
		System.out.println("Gracias por usar freebee\n"
				+ "Programa cerrado");
		System.exit(0);
	};
	
	private boolean choice(String choice) {
		boolean menu = false;
		System.out.println("\n" + choice
				+ "\n1: Sí\n"
				+ "2: No");
		boolean validOption = false;
		
		while(!validOption) {
			String option = sc.nextLine();
			int opt;
			try{
				 opt = Integer.parseInt(option);
			}catch(NumberFormatException nfe) {
				System.err.println("La entrada que pusiste no es un número. Vuelve a seleccionar una opción");
				continue;
			}
			switch(opt) {
			case 1:
				menu = true;
				validOption=true;
				break;
			case 2:
				menu=false;
				validOption = true;
				break;
			default:
				System.err.println("No ingresaste un valor correcto");
				continue;
			}
		}

		return menu;
	}
	
	private void appInfo() {
		System.out.println("FREEBIE v1.1, programa para la gestión de las finanzas personales.\n"
				+ "Proyecto Estructuras de Datos, Joseph Gallego, G3 Universidad Nacional 2022-1.\n"
				+ "Equipo 1. Conformado por:\n"
				+ "	Marcos Pinzón Pardo.\n"
				+ "	Julián Córdoba Jaramillo\n"
				+ "	Dylan Rivero Esteves\n"
				+ "	Camilo Andrés Apraez\n"
				+ "	César Arthuro Lemos\n"
				+ "Work in progress");
	}
	
	private void printMenuOptions() {
		System.out.println("Elige la opción que desees:\n"
				+ "   1. Login\n"
				+ "   2. Crear Usuario\n"
				+ "   3. Acerca de la app\n"
				+ "   4. Salir\n");
	}
	
	private void createUserMenu() {
		
		boolean created = false;
		while(!created) {	
			String userName;
			String password;
			String auxPass;
			

			System.out.println("Ingresa un número de usuario y una contraseña");
			System.out.println("Nombre de Usuario:");
			userName = sc.nextLine();
			System.out.println("Ahora ingresa una contraseña: ");
			password = sc.nextLine();		
			System.out.println("Ingresa nuevamente la contraseña");
			auxPass = sc.nextLine();
			
			String result = userList.userCreation(userName, password, auxPass);
			if(result != null) 
			{
				System.out.println(result);
				if(choice("¿Volver a intentarlo?")) {
					continue;
				}else {
					break;
				}
				
			}else 
			{
				System.out.println("¡Usuario exitosamente creado!");
				if(choice("¿Seguir creando usuarios?")) {
					continue;
				}else {
					created = true;
				}
			}
			
			
		}
		
		
	}
	
	private void userMenu() {
		if(!userList.hasUsers()) {
			System.out.println("No hay usuarios. No se puede hacer login");
			return;
		}
		
		User user;
		System.out.println("\nIngresa tus credenciales:");
		boolean logged = false;
		while(!logged) {
			System.out.println("Usuario:");
			String userN = sc.nextLine();
			System.out.println("Contraseña:");
			String pass = sc.nextLine();
			
			user = userList.login(userN, pass);
			if(user == null) {
				System.out.println("Usuario o Contraseña Incorrectos");
				continue;
			}else {
				System.out.println("Login Exitoso");
				logged = true;
			}
		}
		
		
	}
	
	private void userMenuOptions(String userName) {
		System.out.println("Hola estimado" + userName);
		System.out.println("\nOpciones:");
		System.out.println("	 1. Cuentas\n"
				+ "Transacciones"
				+ "Tips"
				+ "Volver");
	}
}







