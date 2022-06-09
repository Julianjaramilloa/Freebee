package runner;

import logic.UserList;
import ui.Categories;
import ui.ConsoleVersion;
import ui.LogIn;
import ui.Savings;

/**
 * 
 * @author Marcos Pinzón Pardo
 * @author Julián Córdoba Jaramillo
 * @author Dylan Rivero Esteves
 * @author Camilo Andrés Apraez
 * @author César Arthuro Lemos
 * 				
 * Proyecto freebee, de la asignatura Estructuras de Datos.
 *  
 */
public class Main {

	/**|
	 * @param args
	 */
	public static void main(String[] args) {
		//True en el constructor: Cargar datos guardados.
		/*
		Console c = new Console(true);
		c.mainMenu();
		*/
		
//		String a = "as";
//		String b = "bro";
//		System.out.println(a.compareTo(b));
		
//		ProveClasses pc = new ProveClasses();
//		pc.avlTree();
		
		ProveClasses pc = new ProveClasses();
		pc.userTransactions();
		
		Savings sv = new Savings();
		sv.savings();
				
//		Categories ct = new Categories();
//		ct.categories();
		
		//pc.rbTree();
		
		//pc.linkedListInsertions();
		
//		UserList ul = new UserList();
		
//		ul.addUserCredentials("carlitosBacca", "789");
		
//		LogIn lg = new LogIn(ul);
//		lg.credentialsIn();
		
		
//		NewUser nw = new NewUser(); 
//		nw.createUser();
		
	}

}
