package runner;

import logic.ReaderWriter;
import logic.UserList;
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
		
		UserList ul = new UserList();
		ReaderWriter rw = new ReaderWriter(ul);
		rw.readFile();
		
		LogIn lg = new LogIn(ul);
		lg.credentialsIn();
		rw.saveChanges();
		
		
		
		
	}

}
