package logic;

import maps.hashtable;
import rbTree.RbNode;
import rbTree.RedBlackTree;
import seqDataStructures.DynamicArray;

public class UserList {
	
//	public static RedBlackTree users = new RedBlackTree();
	private User currentUser; //Usuario con la sesi�n abierta
	
	public static hashtable<String, User> users = new hashtable<>();
	
	
//	public RbNode getRoot() {
//	return users.getRoot();
//}
	
	//M�todos para crear un usuario:

	
	public String userCreation(String username, String password, String auxPass) {
		String results = null;
		if(password.equals(auxPass) == false) {
			results = "La segunda contrase�a no corresponde con la primera";
		}else if(exists(username)) {
			results = "Ya existe un usuario con este nombre.";
		}else {
			User user = new User(username, password);
			addUser(user);
		}
		return results;
	}
	
	public void addUserCredentials(String userName, String password) {
		User user = new User(userName, password);
		addUser(user);
	}
	
	public void addUser(User user) {
		try{
			users.add(user.getUsername(), user, true);
		}catch(IllegalArgumentException iae){
			System.err.println("El usuario que se est� intentado ingresar ya existe");
		}
	}
	
	private boolean exists(String username) {		
		boolean exists = false;
		if (users.get(username) != null) {
			exists = true;
		}
		return exists;
	}
	
	//M�todo para validar un login:

	public String login(String username, String password) {
		String finalState = null;
		if(hasUsers()) {
			finalState = "No hay ning�n usuario registrado en la app. Debes crear uno primero.";
		}else {
			finalState = credentialsInfoAfterLogin(username, password);
		}	
			return finalState;	
	}
	
	public boolean hasUsers() {
		return users.isEmpty();
	}
	
	private String credentialsInfoAfterLogin(String username, String password) {
		String credentialsInfo = null;
		DynamicArray<Boolean> succesfulLogin = validateCredentials(username,password);
		
		if(!succesfulLogin.get(0)) {
			credentialsInfo = "No existe un usuario con ese nombre";
		}else if(!succesfulLogin.get(1)) {
			credentialsInfo = "La contrase�a es incorrecta";
		}else {
			return "alright";
		}
		return credentialsInfo;
	}
	
	private DynamicArray<Boolean> validateCredentials(String username, String password) {
		DynamicArray<Boolean> succesfulLogin = new DynamicArray<Boolean>();
		
		boolean isRightUsername = false;
		boolean isRightPassword = false;
		
		User aux = users.get(username);

//		User aux;
//		try {
//			aux = auxNode.getUser();
//		}catch(NullPointerException npe) {
//			aux = null;
//		}
						
		if(aux == null) {
			isRightUsername = false;
			isRightPassword = false;
		}else if(aux.areRightCredentials(username, password)) {
			//Con esta sentencia asignamos se le abre la sesi�n al usuario
			this.currentUser = aux;
			currentUser.incorporateIncomingTransactions();
			System.out.println(currentUser.completeUserInfo());
			isRightUsername = true;
			isRightPassword = true;
			
		}else if(aux.getUsername().equals(username)){
			isRightUsername = true;
			isRightPassword = false;
			
		}
	
		succesfulLogin.add(isRightUsername, 0);
		succesfulLogin.add(isRightPassword, 1);
		

		return succesfulLogin;
	}
	
	
	
	/*public void updateCurrentUser(User us) {
		try{
			users.replace(currentUser, us);
		}catch(IndexOutOfBoundsException iobe) {
			throw new NoSuchElementException("La posici�n donde estaba el usuario ya no existe");
		}
		
	}
	*/

	public static int size() {
		return users.size();
	}

	public static User get(String username) {
		return users.get(username);
	};
	
	public User getUser() {
		return this.currentUser;
	}

}
