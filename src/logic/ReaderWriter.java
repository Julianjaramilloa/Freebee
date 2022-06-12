package logic;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;
import java.util.Locale;

import avlTree.AVLTree;
import avlTree.AvlTreeIterator;
import rbTree.TreeIterator;
import seqDataStructures.DynamicArray;

/*
 * freebee
 * @author Marcos Pinzón Pardo
 */

public class ReaderWriter {
	
	
	// De aquí en adelante readAndLoad()
	UserList userList;
	final String fileName = "freebeeRecord.txt";
	User currentUser = null;
	
	// "user" es el usuario que se estï¿½ llenando de cuentas y transacciones en cada momento
	User user = null;

	// Constructor
	public ReaderWriter(UserList userList) {
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
	//Este mï¿½todo, como se puede ver en readData(), se aplica sobre cada renglï¿½n del txt
	private void tokenize(String line) {
		
		System.out.println("Tokenizando línea");
		Scanner sc = new Scanner(line);
		sc.useDelimiter(";");
		
		String data = sc.next().trim();
		
		if(data.charAt(0) == 'U') {
			
			if(currentUser != null) {
				System.out.println(currentUser.completeUserInfo());
				System.out.println("-------------------------------------------------------------------------");
			}
			
			// Se lee el usuario temporal, se agrega a la lista de usuarios y se usa hasta que se lee otro que lo sobreescribe
			User userToken = tokenizeUser(sc.next().trim(), sc.next().trim());
			currentUser = userToken;
			
			userList.addUser(userToken);
			System.out.println("Es un usuario, tokenizando");
			
			
		} else if(data.charAt(0) == 'C') {
			String name = sc.next().trim();
			float balance =  Float.parseFloat(sc.next().trim());
			String currency = sc.next().trim();
			tokenizeAccount( name, balance, currency, currentUser);
			System.out.println("Es una cuenta, tokenizando");
			
		} else if(data.charAt(0) == 'T') {
			//System.out.println(sc.next().trim());
			DateTimeFormatter df = new DateTimeFormatterBuilder()
				    // case insensitive to parse JAN and FEB
				    .parseCaseInsensitive()
				    // add pattern
				    .appendPattern("dd-MM-yyyy")
				    // create formatter (use English Locale to parse month names)
				    .toFormatter(Locale.ENGLISH);
			LocalDate dateOfTransaction = LocalDate.parse(sc.next().trim(),df);
			String desc = sc.next().trim();
			TransactionCategory cat = TransactionCategory.valueOf(sc.next().trim()) ;
			float amount = Float.parseFloat(sc.next().trim());
			Boolean isIngreso = Boolean.parseBoolean(sc.next().trim());
			int accountId = Integer.valueOf(sc.next().trim());
			tokenizeTransaction(dateOfTransaction, accountId, desc, cat, amount, isIngreso, currentUser);

			System.out.println("Es una transacción, tokenizando");
			
		} else {
			System.err.println("Algo falló con la tokenización");
		}
		System.out.println("\n\nLos datos han sido cargados");
		sc.close();

	}

	private User tokenizeUser(String name, String password) {
		

		System.out.println("Tokenizando usuario");	
	
		
		User user = new User(name, password);
		System.out.println("\n\tUsuario creado:\n\n" + "Name:" + name + " Password:" + password + "\n");
		
		return user;
	}

	private void tokenizeAccount(String name, float balance, String currency, User currentUser) {
		
		System.out.println("Tokenizando cuenta");
	
		
		
		//Hay que especificar a quï¿½ usuario se aï¿½ade
		currentUser.addAccount(name, balance, currency);
		System.out.println("\n\tCuenta creada:\n\n" + "Name:" + name + " Balance:" + balance + " Currency:" + currency + "\n");
		
	}

	private void tokenizeTransaction(LocalDate dateOfTransaction, int accId, String desc, TransactionCategory cat, float amount, boolean isIngreso,  User user) {
		
		System.out.println("Tokenizando transacción");
		
		
		
		//Hay que especificar a qué usuario se añade
		try{
			user.addTransactionData(dateOfTransaction, accId, desc, cat, amount, isIngreso);
		}catch(NullPointerException npe) {
			System.err.println("No se insertó la transacción porque no existe la cuenta");
		}
		
		System.out.println("\n\ttransacción creada:\n\n" + 
		"Fecha:" + dateOfTransaction + " Descripción:" + desc + " Category:" + cat +
		"Cantidad:" + amount + " Es un ingreso:" + isIngreso + " Cuenta Asociada:" + accId + "\n");
		
	}



	
	// Hasta aquï¿½ la parte de lectura del .txt
	
	// De aquï¿½ en adelante saveChanges()
	
	/*como cambiamos userlist a Rbtree toca crear un iterador para que savechanges funcione*/
	
	public void saveChanges() {
		
		// Para que esta funciï¿½n correctamente, se debe modificar el get, de manera que quede
		// formateado (parecido a lo que se ve arriba de los prints para confirmar que se imprimiï¿½ bien)
		// y de esta manera se guarde en el .txt como queremos, todo separado por ";"
		
		try (FileWriter f = new FileWriter("testSave2.txt", true);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);) {
			
			// Recorre la lista de usuarios (lo llamï¿½ userList)
//			for (int u = 0; u < userList.size(); u++) {
//				
//				//No tendrï¿½a por quï¿½ haber acceso a las passwords
//				
//				f.write("U; " + userList.get(u).getUsername() + "; " + userList.get(u).getUserPassword() +"\n");
//				
//				// Demostrativo, hay que implementar bien:
//				DynamicArray<Account> listaDeCuentas = userList.get(u).getAccounts(); 
//				LinkedList<Transaction> listaDeTrans = userList.get(u).getTransactions();
//						
//				for (int a = 0; a < listaDeCuentas.size(); a++) {f.write("C; " +listaDeCuentas.get(a) + "\n");}
//				for (int t = 0; t < listaDeTrans.size(); t++) {f.write("T; " +listaDeTrans.get(t) + "\n");}
//				
//	        }
			
			TreeIterator iterator = new TreeIterator(userList.getRoot());

			while (iterator.hasNext()) {
				User user = iterator.next().getUser();
				f.write("U; " + user.getUsername() + "; " + user.getPassword() + "\n");
				DynamicArray<Account> listaDeCuentas = user.getAccounts();
				AVLTree<Transaction> listaDeTrans = user.getTransactions();
				for (int a = 0; a < listaDeCuentas.size(); a++) {f.write("C; " +listaDeCuentas.get(a) + "\n");}
				AvlTreeIterator avlIterator = new AvlTreeIterator(listaDeTrans.getRoot());
				while (avlIterator.hasNext()) {
					f.write("T; " + avlIterator.next().toString() + "\n");
				}
				//for (int t = 0; t < listaDeTrans.size(); t++) {f.write("T; " + avlIterator.next(). + "\n");}

				
			}
			
		} catch (IOException i1) {i1.printStackTrace();}
		
	}
	
	

}