package seqDataStructures;

public class LinkedLIterator<T> implements Iterator<T> {

	private LinkedList<T> list;
	private Node<T> current;
	
	public LinkedLIterator(LinkedList<T> list) {
		this.list = list;
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
