package runner;

import logic.ReaderWriter;
import logic.User;
import logic.UserList;
import ui.LogIn;
import maps.hashtable;

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
//		rw.saveChanges();
		
//		hashtable<String, Integer> map = new hashtable<>();
//		map.add("this", 1);
//		map.add("coder", 2);
//		map.add("this", 4);
//		map.add("hi", 5);
//		System.out.println(map.size());
//		System.out.println(map.remove("this"));
//		System.out.println(map.remove("this"));
//		System.out.println(map.size());
//		System.out.println(map.isEmpty());
//		System.out.println(map.get("coder"));
		
		
	}

}
