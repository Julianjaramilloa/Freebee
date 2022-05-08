package ui;

import java.util.Scanner;

import logic.UserList;

public class Console {
	private UserList userList;
	Scanner sc = new Scanner(System.in);//Para prevenir problemas con Scanners multiples
	
	public Console(String savedData, boolean loadData) {
		userList = new UserList(savedData);
		if(loadData) {
			userList.readAndLoadData();
		}
	}
	
	public void mainMenu() {
		
		System.out.println("\n          Hola de nuevo. Bienvenido a FREEBIE");
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
				if(!menu()) {
					exit=true;
				}
				break;
			case 2:
				createUserMenu();
				if(!menu()) {
					exit=true;
				}
				break;
			case 3:
				appInfo();
				if(!menu()) {
					exit=true;
				}
				break;
			case 4:
				System.out.println("Gracias por usar FREEBIE");
				System.exit(0);
				break;
			default:
				System.err.println("No escogiste un número correcto. Escoge solo las opciones disponibles");
				printMenuOptions();
			}
		}
		
		sc.close();
		System.out.println("Gracias por usar FREEBIE\n"
				+ "Programa cerrado");
		System.exit(0);
	};
	
	private boolean menu() {
		boolean menu = false;
		System.out.println("\n¿Volver al menú principal?\n"
				+ "1: Sí\n"
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
			
			if(password.equals(auxPass) == false) {
				System.err.println("La segunda contraseña no corresponde con la primera");
				continue;
			}
			if(userList.exists(userName)) {
				System.err.println("Ya existe un usuario con este nombre. Ingresa otro");
			}
			userList.addUser(userName, password);
			created = true;
			System.out.println("¡Usuario exitosamente creado!");
		}
		
		
	}
	
	private void userMenu() {
		System.out.println("\nIngresa tus credenciales:");
		boolean logged = false;
		while(!logged) {
			String user = sc.nextLine();
			String pass = sc.nextLine();
			
		}
	}
	
}







