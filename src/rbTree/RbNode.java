package rbTree;

import java.time.LocalDate;

import logic.Transaction;
import logic.User;

public class RbNode {
	  LocalDate date;
	  String username;
	  int data;
	  User user;
	  RbNode left;
	  RbNode right;
	  RbNode parent;


	  boolean color; 


	  public RbNode(User user) {
	    this.username = user.getUsername();
	    this.user = user;
	  }
	  

	  public RbNode(int i) {
		this.data = i;
	  }

	  public User getUser() {
		  return user;
	  }

	//Hago aquí el toString() para debuggear
	  @Override
	  public String toString() {
		  return String.valueOf(data);
	  }
	  
	}