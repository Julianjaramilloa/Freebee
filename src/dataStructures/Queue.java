package dataStructures;

import java.io.Serializable;

public class Queue<T extends Serializable> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Node<T> head;
	Node<T> tail;
	
	public Queue() { this.head = null; }
	
	public void enqueue(T data)
	{

	    Node<T> temp = new Node<>(data);

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
		Node<T> temp = head;
		return String.valueOf(temp.data);
	}


}
