package runner;

import logic.UserList;
import ui.Categories;
import ui.ConsoleVersion;
import ui.LogIn;

/**
 * 
 * @author Marcos Pinz�n Pardo
 * @author Juli�n C�rdoba Jaramillo
 * @author Dylan Rivero Esteves
 * @author Camilo Andr�s Apraez
 * @author C�sar Arthuro Lemos
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
		
		
		ProveClasses pc = new ProveClasses();
		pc.avlTree();
		
//		Categories ct = new Categories();
//		ct.categories();
		
		//pc.rbTree();
		
		//pc.linkedListInsertions();
		
//		UserList ul = new UserList();
		
//		LogIn lg = new LogIn(ul);
//		lg.credentialsIn();
//		NewUser nw = new NewUser(); 
//		nw.createUser();
		
	}

}
