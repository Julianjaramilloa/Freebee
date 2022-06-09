package runner;

import java.time.LocalDate;

import logic.User;
import logic.UserList;
import ui.Categories;
import ui.ConsoleVersion;
import ui.LogIn;
import ui.NewUser;
import ui.Savings;
import ui.ReaderWriter;

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
		
		
//		Savings sv = new Savings();
//		sv.savings();
		
//		UserList ul = new UserList();
//		NewUser nu = new NewUser(ul);
//		nu.setVisible(true);
				
//		Categories ct = new Categories();
//		ct.categories();
		
		UserList ul = new UserList();
		ReaderWriter rw = new ReaderWriter(ul);
		rw.readFile();
		
//		TestClasses tc = new TestClasses();
//		tc.incomingTransactionsTest();
		
//		LogIn lg = new LogIn(ul);
//		lg.credentialsIn();
		
		
		
		//ProveClasses pc = new ProveClasses();
		//pc.minHeap();
		
		
	}

}
