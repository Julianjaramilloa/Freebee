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
import maps.HashIterate;
import maps.HashNode;
import rbTree.TreeIterator;
import seqDataStructures.DynamicArray;
import seqDataStructures.LinkedList;

/*
 * freebee
 * @author Marcos Pinz�n Pardo
 * @author Dylan Rivero
 */

public class ReaderWriter {
	
	
	// De aqu� en adelante readAndLoad()
	UserList userList;
	final String fileName = "testSave.txt";
	User currentUser = null;
	
	// "user" es el usuario que se est� llenando de cuentas y transacciones en cada momento
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
//		      System.out.println("El archivo " + fileName + " ya existe");
		    	System.out.println("Leyendo datos desde " + fileName);	
		      // Lee el archivo y crea los objetos
		      readData(fileName);
		      }
		    } catch (IOException e) {
		System.out.println("Algo sali� mal con la creaci�n de " + fileName);
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
			if(currentUser != null) {
				System.out.println(currentUser.completeUserInfo());
				System.out.println("-------------------------------------------------------------------------");
			}
			sc.close();
			System.out.println("Datos cargados!");
		} catch (FileNotFoundException e) {
			System.out.println("Error leyendo archivo");
			e.printStackTrace();
		}
	}
	//Este m�todo, como se puede ver en readData(), se aplica sobre cada rengl�n del txt
	private void tokenize(String line) {
		
//		System.out.println("Tokenizando l�nea");
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
			
			
		} else if(data.charAt(0) == 'C') {
			String name = sc.next().trim();
			float balance =  Float.parseFloat(sc.next().trim());
			String currency = sc.next().trim();
			tokenizeAccount( name, balance, currency, currentUser);
			
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
			
		} else {
			System.err.println("Algo fall� con la tokenizaci�n");
		}
//		System.out.println("\n\nLos datos han sido cargados");
		sc.close();

	}

	private User tokenizeUser(String name, String password) {
		

//		System.out.println("Tokenizando usuario");	
		
		User user = new User(name, password);
		System.out.println("\n\tUsuario creado:\n\n" + "Name:" + name + " Password:" + password + "\n");
		
		return user;
	}

	private void tokenizeAccount(String name, float balance, String currency, User currentUser) {
		
//		System.out.println("Tokenizando cuenta");
	
		
		
		//Hay que especificar a qu� usuario se a�ade
		currentUser.addAccount(name, balance, currency);
//		System.out.println("\n\tCuenta creada:\n\n" + "Name:" + name + " Balance:" + balance + " Currency:" + currency + "\n");
		
	}

	private void tokenizeTransaction(LocalDate dateOfTransaction, int accId, String desc, TransactionCategory cat, float amount, boolean isIngreso,  User user) {
		
//		System.out.println("Tokenizando transacci�n");
		
		
		
		//Hay que especificar a qu� usuario se a�ade
		try{
			user.addTransactionData(dateOfTransaction, accId, desc, cat, amount, isIngreso);
		}catch(NullPointerException npe) {
			System.err.println("No se insert� la transacci�n porque no existe la cuenta");
		}
		
//		System.out.println("\n\ttransacci�n creada:\n\n" + 
//		"Fecha:" + dateOfTransaction + " Descripci�n:" + desc + " Category:" + cat +
//		"Cantidad:" + amount + " Es un ingreso:" + isIngreso + " Cuenta Asociada:" + accId + "\n");
		
	}
	
	public <K, V> void saveChanges() {
		
		try (FileWriter f = new FileWriter("testSave.txt", false);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);) {
			
			HashIterate iterate = new HashIterate(userList.users);
			while(iterate.hasNext()) {
				
				String key = (String) iterate.next();
				User user = userList.get(key);
				f.write("U; " + user.getUsername() + "; " + user.getPassword() +"\n");
				DynamicArray<Account> listaDeCuentas = user.getAccounts(); 
				AVLTree<Transaction> listaDeTrans = user.getTransactions();
				for (int a = 0; a < listaDeCuentas.size(); a++) {
					f.write("C; " +listaDeCuentas.get(a).saveData() + "\n");
				}

				AvlTreeIterator<Transaction> avlIterator = new AvlTreeIterator<Transaction>(listaDeTrans.getRoot());
				while (avlIterator.hasNext()) {
					f.write("T; " + (avlIterator.next()).saveData() + "\n");
				}
				
			}
			
		} catch (IOException i1) {i1.printStackTrace();}
		
	}
	
	

}