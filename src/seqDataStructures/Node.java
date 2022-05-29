package seqDataStructures;

public class Node<T>{
		protected T data;
		protected Node<T> next = null;
		
		Node(T data)
		{
			this.data = data;
			this.next = null;
		}
}
