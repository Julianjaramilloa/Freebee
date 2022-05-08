/**
 * 
 */
package runner;

import logic.UserList;
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
		//En el constructor de Console est� lo de si se carga o no. Por ahora
		//Lo tengo como que no se carga autom�ticamente. Para que se carge
		//automaticamente, ponga true;
		Console c = new Console(false);
		c.mainMenu();
	}

}
