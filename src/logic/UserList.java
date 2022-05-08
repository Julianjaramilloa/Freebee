package logic;

import dataStructures.LinkedLIterator;
import dataStructures.LinkedList;

public class UserList {
	private LinkedList<User> users = new LinkedList<User>();
	private String fileName;
	
	public UserList(String savedData) {
		this.fileName = savedData;
	};
	
	public void addUser(String userName, String passWord) {
		User user = new User(userName, passWord);
		users.pushBack(user);
	};
	
	/*
	 * Este método permite ver si el usuario con username existe en la lista.
	 * Sirve para que cuando se crea un usuario, se verifique si ese usuario existe o no
	 */
	public boolean exists(String username) {
		boolean exists = false;
		LinkedLIterator<User> it = users.iterate();
		while(it.hasNext()) {
			User aux = it.next();
			if(aux.getUserName() == username) {
				exists = true;
			}
		}
		return exists;
	}
	
	public boolean log() {
		return false;
	}
	
	public void editUser() {
		
	};
	
	public void selectUser(String userName, String password) {
		
	};
	
	public void readAndLoadData() {
		
	};
}
