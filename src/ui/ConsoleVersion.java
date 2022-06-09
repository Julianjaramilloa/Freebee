package ui;

import java.util.Scanner;

import logic.User;
import logic.UserList;

public class ConsoleVersion {
	private UserList userList;
	Scanner sc = new Scanner(System.in);//Para prevenir problemas con Scanners multiples, solo uno para toda la clase
	final String cont = "�Quieres seguir en la app?";
	User user = null;
	
	public ConsoleVersion(boolean loadData) {
		userList = new UserList();
		if(loadData) {
			readAndLoadData(userList);
		}
	}
	
	public void readAndLoadData(UserList userlist) {
		ReaderWriter read = new ReaderWriter(userlist);
		read.readFile();
		
	}
	
//	public void saveData(UserList userlist) {
//		readerWriter save = new readerWriter(userlist);
////		save.saveChanges();
//		
//	}
	
	public void mainMenu() {
		
		System.out.println("----------------------------------------------------");
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
				System.err.println("La entrada que pusiste no es un n�mero. Vuelve a seleccionar una opci�n");
				continue;
			}
			switch(opt) {
			case 1:
				accountMenu();
				if(!choice(cont)) {
					exit=true;
				}
				break;
			case 2:
				createAccountMenu();
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
//				saveData(userList);
				System.out.println("Gracias por usar freebee");
				sc.close();
				System.exit(0);
				break;
			case 5:
				System.out.println(userList.users.toString());
				break;
			default:
				System.err.println("No escogiste un n�mero correcto. Escoge solo las opciones disponibles");
			}
		}
		
		System.out.println("Gracias por usar freebee\n"
				+ "Programa cerrado");
		sc.close();
		System.exit(0);
	};
	
	private void appInfo() {
		System.out.println("FREEBE, programa para la gesti�n de las finanzas personales.\n"
				+ "Proyecto Estructuras de Datos, Joseph Gallego, G3 Universidad Nacional 2022-1.\n"
				+ "Equipo 1. Conformado por:\n"
				+ "	Marcos Pinz�n Pardo.\n"
				+ "	Juli�n C�rdoba Jaramillo\n"
				+ "	Dylan Rivero Esteves\n"
				+ "	Camilo Andr�s Apraez\n"
				+ "	C�sar Arthuro Lemos\n"
				+ "Work in progress");
	}
	
	private void printMenuOptions() {
		System.out.println("Elige la opci�n que desees:\n"
				+ "   1. Login\n"
				+ "   2. Crear Usuario\n"
				+ "   3. Acerca de la app\n"
				+ "   4. Salir\n");
	}

	//men� de creaci�n de usuario, opci�n 1
	private void createAccountMenu() {
		
		boolean created = false;
		while(!created) {	
			String userName;
			String password;
			String auxPass;
			

			System.out.println("Ingresa un n�mero de usuario y una contrase�a");
			System.out.println("Nombre de Usuario:");
			userName = sc.nextLine();
			System.out.println("Ahora ingresa una contrase�a: ");
			password = sc.nextLine();		
			System.out.println("Ingresa nuevamente la contrase�a");
			auxPass = sc.nextLine();
			
			String result = userList.userCreation(userName, password, auxPass);
			if(result != null) 
			{
				System.out.println(result);
				if(choice("�Volver a intentarlo?")) {
					continue;
				}else {
					break;
				}
				
			}else{
				System.out.println("�Usuario exitosamente creado!");
					created = true;
			}
			
			
		}
		
		
	}
	
	private void accountMenu() {

		if(!login()) {
			return;
		}
		
		//Todo esto se abre siempre que uno haya hecho un login exitoso
		System.out.println("\n          �Hola estimado " + user.getUsername() + "!");
		boolean finished = false;
		while(!finished) {
			accountsOptions();
			String option = sc.nextLine();
		int opt;
			try{
				 opt = Integer.parseInt(option);
			}catch(NumberFormatException nfe) {
				System.err.println("La entrada que pusiste no es un n�mero. Vuelve a seleccionar una opci�n");
				continue;
			}
			switch(opt) {
			case 1:
				createAccount();
				if(choice("Seguir en el men� cuentas?")) {
					continue;
				}else{
					finished = true;
				}
				break;
			case 2: //A futuro
				addTransaction();
				if(choice("Seguir en el men� cuentas?")) {
					continue;
				}else{
					finished = true;
				}
				break;
			case 3:
				query();
				if(choice("Seguir en el men� cuentas?")) {
					continue;
				}else{
					finished = true;
				}
				break;
			case 4:
				finished = true;
				break;
			case 5:
				System.out.println("Gracias por usar freebee");
				System.exit(0);
				break;
			default:
				System.err.println("No escogiste un n�mero correcto. Escoge solo las opciones disponibles");
				accountsOptions();
			}
		
		}
	}
	
	private boolean login() {
		if(!userList.hasUsers()) {
			System.out.println("No hay usuarios. No se puede hacer login");
			return false;
		}
		
		
		System.out.println("\nIngresa tus credenciales:");
		boolean logged = false;
		while(!logged) {
			System.out.println("Usuario:");
			String userN = sc.nextLine();
			System.out.println("Contrase�a:");
			String pass = sc.nextLine();
			
			//user = userList.login(userN, pass);
			user = userList.getUser();
			if(user == null) {
				System.out.println("Usuario o Contrase�a Incorrectos");
				if(choice("�Volver a intentarlo?")) {
					continue;
				}else{
					return false;
				}
			}else {
				System.out.println("Login Exitoso");
				logged = true;
			}
		}
		return logged;
		
	}

	
	//Las 5 opciones que tiene el user
	private void accountsOptions() {
		System.out.println("\nOpciones:\n"
				+"   1.Crear Nueva Cuenta"
				+ "   2.A�adir transacci�n(No disponible por ahora)"
				+ "   3.Consultar Cuentas"
				+ "   4.Volver"
				+ "   5.Salir");
	}
	
	private void createAccount() {
		System.out.println("Entrega los datos de la cuenta que vas a introducir:");
		System.out.println("Nombre:");
		String name = sc.nextLine();
		System.out.println("Balance(debe ser float):");
		float balance = 0;
		try{
			balance = Float.parseFloat(sc.nextLine());
		}catch (NumberFormatException nfe){
			System.err.println("No se ingres� un valor num�rico. Operaci�n fallida");
			return;
		}
		System.out.println("Divisa;");
		String currency = sc.nextLine();
		user.addAccount(name,balance,currency);
		System.out.println("Cuenta a�adida");
	}
	
	private void addTransaction() {
		System.out.println("Introduce los valores de tu transacci�n");
		System.out.println("Fecha de la transacci�n");
		System.out.println("id de la cuenta a la que la vas a asociar");
		System.out.println("descripci�n de la transacci�n");
		System.out.println("Categor�a");
		System.out.println("Cantidad");
		System.out.println("Es ingreso(boolean)");
	}
	
	private void query() {
		System.out.println("Cu�l es la cuenta que quieres consultar?");
		short id = 0;
		try {
			id = Short.parseShort(sc.nextLine());
		}catch(NumberFormatException nfe) {
			System.err.println("Se ingres� un valor no v�lido");
			return;
		}
		System.out.println(user.accountsInfo(id));
		user.transactionsInfo(id);
	}
	
	private boolean choice(String choice) {
		boolean menu = false;
		System.out.println("\n" + choice
				+ "\n1: S�\n"
				+ "2: No");
		boolean validOption = false;
		
		while(!validOption) {
			String option = sc.nextLine();
			int opt;
			try{
				 opt = Integer.parseInt(option);
			}catch(NumberFormatException nfe) {
				System.err.println("La entrada que pusiste no es un n�mero. Vuelve a seleccionar una opci�n");
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
}







