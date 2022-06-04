package runner;

import ui.Console;

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
