/**
 * 
 */
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
		Console c = new Console("users.txt", true);
		c.mainMenu();
	}

}
