package runner;

import java.time.LocalDate;

import logic.ReaderWriter;
import logic.User;
import logic.UserList;
import ui.Categories;
import ui.ConsoleVersion;
import ui.LogIn;
import ui.NewUser;
import ui.Savings;
import ui.Stats;

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
		
		
		
		UserList ul = new UserList();
		ReaderWriter rw = new ReaderWriter(ul);
		rw.readFile();
		
		LogIn lg = new LogIn(ul);
		lg.credentialsIn();
		rw.saveChanges();
		
		
		
		
	}

}
