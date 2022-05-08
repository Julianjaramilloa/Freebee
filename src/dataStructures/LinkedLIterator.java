package dataStructures;

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
		if(hasNext()==true) {
			current = current.next;
			return current.data;
		}
		return null;
	}

}
