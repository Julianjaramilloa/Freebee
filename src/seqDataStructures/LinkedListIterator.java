package seqDataStructures;

public class LinkedListIterator<T> implements Iterator<T> {

	private Node<T> current;
	
	public LinkedListIterator(LinkedList<T> list) {
		current = list.head;
	}
	
	@Override
	public boolean hasNext() {
		if (current !=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public T next() {
		T data = current.data;
		if(hasNext()==true) {
			current = current.next;
		}else {
			throw new IndexOutOfBoundsException("No hay más valores en la lista");
		}
		return data;
	}

}
