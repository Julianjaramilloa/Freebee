package logic;

import java.util.NoSuchElementException;

import seqDataStructures.DynamicArray;
import seqDataStructures.DynamicArrayIterator;

public class UserList {
	
	public static DynamicArray<User> users = new DynamicArray<User>();
//	private int currentUser;
	private User currentUser;
	
	public UserList() {};
	
	//Métodos para crear un usuario:
	
	public String userCreation(String userName, String password, String auxPass) {
		String results = null;
		if(password.equals(auxPass) == false) {
			results = "La segunda contraseña no corresponde con la primera";
		}else if(exists(userName)) {
			results = "Ya existe un usuario con este nombre.";
		}else {
			addUserCredentials(userName, password);
		}
		return results;
	}
	
	public void addUserCredentials(String userName, String password) {
		User user = new User(userName, password);
		users.pushBack(user);
	};
	
	public void addUser(User user) {
		users.pushBack(user);
	}
	
	private boolean exists(String username) {
		boolean exists = false;
		DynamicArrayIterator<User> it = users.iterate();
		while(it.hasNext()) {
			User aux = it.next();
			if(aux.getUsername() == username) {
				exists = true;
			}
		}
		return exists;
	}
	
	//Método para validar un login:

	public String login(String username, String password) {
		String finalState = null;
		if(!hasUsers()) {
			finalState = "No hay ningún usuario registrado en la app. Debes crear uno primero.";
		}else {
			finalState = credentialsInfoAfterLogin(username, password);
		}	
			return finalState;	
	}
	
	public boolean hasUsers() {
		return !users.isEmpty();
	}
	
	private String credentialsInfoAfterLogin(String username, String password) {
		String credentialsInfo = null;
		
		DynamicArray<Boolean> succesfulLogin = doLogin(username,password);
		
		if(!succesfulLogin.get(0)) {
			credentialsInfo = "No existe un usuario con ese nombre";
		}else if(!succesfulLogin.get(0)) {
			credentialsInfo = "La contraseña es incorrecta";
		}else {
			return "alright";
		}
		return credentialsInfo;
	}
	
	private DynamicArray<Boolean> doLogin(String username, String password) {
		DynamicArray<Boolean> succesfulLogin = new DynamicArray<Boolean>();
		DynamicArrayIterator<User> it = users.iterate();
		
		boolean rightUsername = false;
		boolean rightPassword = false;
		
		User aux;
		while(it.hasNext()) {
			aux = it.next();
			if(aux.areRightCredentials(username, password)) {
				//Con esta sentencia asignamos se le abre la sesión al usuario
				this.currentUser = aux;
				rightUsername = true;
				rightPassword = true;
				break;
			}else if(aux.getUsername() == username){
				rightUsername = true;
				rightPassword = false;
				break;
			}
		}
		succesfulLogin.add(rightUsername, 0);
		succesfulLogin.add(rightPassword, 1);
		return succesfulLogin;
	}
	
	
	
	/*public void updateCurrentUser(User us) {
		try{
			users.replace(currentUser, us);
		}catch(IndexOutOfBoundsException iobe) {
			throw new NoSuchElementException("La posición donde estaba el usuario ya no existe");
		}
		
	}
	*/

	public static int size() {
		return users.size();
	}

	public static User get(int u) {
		return users.get(u);
	};
	
	public User getUser() {
		return this.currentUser;
	}
	





}
