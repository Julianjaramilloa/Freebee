package Structures;

import java.io.Serializable;

public class Queue<T extends Serializable> implements Serializable {
	node<T> head;
	node<T> tail;
	
	public Queue() { this.head = null; }
	
	public void enqueue(T data)
	{

	    // Creating new node with given value
	    node<T> temp = new node<>(data);

	    // Checking if list is empty
	    // and assigning new value to head node
	    if (head == null) {
	        head = temp;
	        tail = temp;
	    }else {
	    	if(tail == head) {
	    		tail = temp;
	    		head.next = tail;
	    	}else {
	    		tail.next = temp;
	    		tail= tail.next;
	    	}
	    }
	}
	public <T> Object dequeue() 
	{
		String temp = peek();
		if (head!=null){
	    	head = head.next;
		}
	    return temp;
	    
	}
	public String peek() 
	{
		node<T> temp = head;
		return String.valueOf(temp.data);
	}


}
