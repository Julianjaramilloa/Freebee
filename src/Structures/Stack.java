package Structures;

import java.io.Serializable;


public class Stack <T extends Serializable> implements Serializable {
	// Generic node instance
    node<T> head;
    
    public Stack() { this.head = null; }
    
    
	public void push( T data)
	{
		// Temporary node that stores previous head
        // value
        node<T> temp = head;

        // New valued node stored in head
        head = new node<T>(data);

        // New head node pointing to old head node
        head.next = temp;

        return;
    }
	public Object pop() 
	{
		// Dummy node with null value
        String temp = top();
 
        if (head!=null){
        	head = head.next;
        }
		return temp;
        
	}
	public String top() 
	{
		node<T> temp = head;
		return String.valueOf(temp.data);
	}
		
}







