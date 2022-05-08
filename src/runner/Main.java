/**
 * 
 */
package runner;

import logic.UserList;
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
		//En el constructor de Console está lo de si se carga o no. Por ahora
		//Lo tengo como que no se carga automáticamente. Para que se carge
		//automaticamente, ponga true;
		Console c = new Console(false);
		c.mainMenu();
	}

}
