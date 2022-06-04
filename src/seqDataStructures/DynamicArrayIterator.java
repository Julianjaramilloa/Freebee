package seqDataStructures;

public class DynamicArrayIterator<T> implements Iterator<T> {

	private DynamicArray<T> list;
	private int current;
	
	
	public DynamicArrayIterator(DynamicArray<T> list) {
		this.list = list;
		current = 0;
	}
	
	@Override
	public boolean hasNext() {
		if(list.size() > current) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public T next() {
		T next = null;
		if(hasNext()) {
			next = list.get(current);
			current++;
		}else {
			throw new IndexOutOfBoundsException("No hay más valores en la lista");
		}
		return next;
	}

}
