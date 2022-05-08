package logic;

import java.util.NoSuchElementException;

import dataStructures.DArrayIterator;
import dataStructures.DynamicArray;
import dataStructures.LinkedLIterator;
import dataStructures.LinkedList;
import ui.readerWriter;
public class UserList {
	public DynamicArray<User> users = new DynamicArray<User>();
	private int currentUser;
	
	public UserList() {};
	
	public int size() {
		return users.size();
	}
	
	//Métodos para crear un usuario:
	
	public String userCreation(String userName, String password, String auxPass) {
		String results = null;
		if(password.equals(auxPass) == false) {
			results = "La segunda contraseña no corresponde con la primera";
		}else if(exists(userName)) {
			results = "Ya existe un usuario con este nombre.";
		}else {
			addUserCred(userName, password);
		}
		return results;
	}
	
	public void addUserCred(String userName, String password) {
		User user = new User(userName, password);
		users.pushBack(user);
	};
	
	public void addUser(User user) {
		users.pushBack(user);
	}
	
	/*
	 * Este método permite ver si el usuario con username existe en la lista.
	 * Sirve para que cuando se crea un usuario, se verifique si ese usuario existe o no
	 */
	private boolean exists(String username) {
		boolean exists = false;
		DArrayIterator<User> it = users.iterate();
		while(it.hasNext()) {
			User aux = it.next();
			if(aux.getUserName() == username) {
				exists = true;
			}
		}
		return exists;
	}
	
	//Método para validar un login:
	
	public User login(String username, String password) {
		User user = null;
		DArrayIterator<User> it = users.iterate();
		User aux;
		for(int i=0; i<users.size(); i++) {
			aux = it.next();
			if(aux.right(username, password)) {
				user=aux;
				currentUser = i;
				break;
			};
		}
		return user;
	}
	
	public boolean hasUsers() {
		return !users.isEmpty();
	}
	
	public void updateCurrentUser(User us) {
		try{
			users.replace(currentUser, us);
		}catch(IndexOutOfBoundsException iobe) {
			throw new NoSuchElementException("La posición donde estaba el usuario ya no existe");
		}
		
	};
	
	public void selectUser(String userName, String password) {
		
	};
	

	public String get() {
		// TODO Auto-generated method stub
		return null;
	};
}
