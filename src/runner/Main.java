package runner;

import ui.Console;

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

	/**
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
		
		
		//pc.rbTree();
		
		//pc.linkedListInsertions();
		
		
	}

}
