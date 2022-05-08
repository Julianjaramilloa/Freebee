package ui;
import logic.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Locale.Category;

/*
 * freebee
 * @author Marcos Pinzón Pardo
 */

public class readerWriter {
	
	
	// De aquí en adelante readAndLoad()
	UserList userList;
	final String fileName = "freebieRecord.txt";
	
	// "user" es el usuario que se está llenando de cuentas y transacciones en cada momento
	User user = null;

	// Constructor
	public readerWriter(UserList userList) {
		this.userList = userList;
	}
	
	// Crea el archivo o inicia readData
	public void readFile() {
		
		try {
			// Si el archivo no existe, lo crea
		    File textfile = new File(fileName);
		    if (textfile.createNewFile()) {
		      System.out.println("Nuevo archivo " + fileName + " creado");   
		    // Si ya existe, lee los datos y crea usuarios, cuentas y transacciones
		    } else {
		      System.out.println("El archivo " + fileName + " ya existe");
		      // Lee el archivo y crea los objetos
		      readData(fileName);
		      }
		    } catch (IOException e) {
		System.out.println("Algo salió mal con la creación de " + fileName);
	    e.printStackTrace();
	    }
	System.out.println("");
	}
		
	// Lee linea por linea y crea usuario, luego cuentas y luego transacciones
	private void readData(String fileName) {
		
		File f = new File(fileName);
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				tokenize(line);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error leyendo archivo");
			e.printStackTrace();
		}
	}

	//Este método, como se puede ver en readData(), se aplica sobre cada renglón del txt
	private void tokenize(String line) {
		
		System.out.println("Tokenizando línea");
		Scanner sc = new Scanner(line);
		sc.useDelimiter(";");
		
		String data = sc.next().trim();
		System.out.println(data);

		
		if(data == "U") {
			// Se lee el usuario temporal, se agrega a la lista de usuarios y se usa hasta que se lee otro que lo sobreescribe
			User user = tokenizeUser(data);
			userList.addUser(user);
			System.out.println("Es un usuario, tokenizando");
			
			
		} else if(data.charAt(0) == 'C') {
			tokenizeAccount(data, user);
			System.out.println("Es una cuenta, tokenizando");
			
		} else if(data.charAt(0) == 'T') {
			tokenizeTransaction(data, user);
			System.out.println("Es una transacción, tokenizando");
			
		} else {
			System.err.println("Algo falló con la tokenización");
		}
		
		sc.close();

	}

	private User tokenizeUser(String data) {
		

		System.out.println("Tokenizando usuario");	

		System.out.println("Tokenizando usuario");
		
		Scanner sc = new Scanner(data);
		sc.useDelimiter(";");
		
		String name = sc.next().trim();
		String password = sc.next().trim();
		
		sc.close();
		
		User user = new User(name, password);
		System.out.println("\n\tUsuario creado:\n\n" + "Name:" + name + " Password:" + password + "\n");
		
		return user;
	}

	private void tokenizeAccount(String data, User user) {
		
		System.out.println("Tokenizando cuenta");
		
		Scanner sc = new Scanner(data);
		sc.useDelimiter(";");
		
		String name = sc.next().trim();
		float balance = Float.parseFloat(sc.next().trim());
		String currency = sc.next().trim();
		
		sc.close();
		
		
		//Hay que especificar a qué usuario se añade
		user.addAccount(name, balance, currency);
		System.out.println("\n\tCuenta creada:\n\n" + "Name:" + name + " Balance:" + balance + " Currency:" + currency + "\n");
		
	}

	private void tokenizeTransaction(String data, User user) {
		
		System.out.println("Tokenizando transacción");
		
		Scanner sc = new Scanner(data);
		sc.useDelimiter(";");
		
		LocalDate dateOfTransaction = LocalDate.parse(sc.next().trim());
		String desc = sc.next().trim();
		Categories cat = Categories.valueOf(sc.next().trim()) ;
		float amount = Float.parseFloat(sc.next().trim());
		Boolean isIngreso = Boolean.parseBoolean(sc.next().trim());
		short accId = Short.valueOf(sc.next().trim());
		
		sc.close();
		
		
		//Hay que especificar a qué usuario se añade
		user.addTransaction(dateOfTransaction, accId, desc, cat, amount, isIngreso);
		
		System.out.println("\n\tTransacción creada:\n\n" + 
		"Fecha:" + dateOfTransaction + " Descripción:" + desc + " Category:" + cat +
		"Cantidad:" + amount + " Es un ingreso:" + isIngreso + " Cuenta:" + accId + "\n");
		
	}

	
	// Hasta aquí la parte de lectura del .txt
	
	// De aquí en adelante saveChanges()
	
	/*public void saveChanges() {
		
		// Para que esta función correctamente, se debe modificar el get, de manera que quede
		// formateado (parecido a lo que se ve arriba de los prints para confirmar que se imprimió bien)
		// y de esta manera se guarde en el .txt como queremos, todo separado por ";"
		
		try (FileWriter f = new FileWriter(fileName, true);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);) {
			
			// Recorre la lista de usuarios (lo llamé userList)
			for (int u = 0; u < UserList.size(); u++) {
				
				f.write("U; " + UserList.get(u) + "\n");
				
				// Demostrativo, hay que implementar bien:
				listaDeCuentas = u.getAccounts; 
				listaDeTrans = u.getTransactions;
						
				for (int a = 0; a < listaDeCuentas.size(); a++) {f.write("C; " +listaDeCuentas.get(a) + "\n");}
				for (int t = 0; t < listaDeTrans.size(); t++) {f.write("T; " +listaDeTrans.get(t) + "\n");}
				
	        }
			
		} catch (IOException i1) {i1.printStackTrace();}
		
	}
	*/
	

}