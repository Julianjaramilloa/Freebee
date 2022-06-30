package maps;

import java.util.ArrayList;

import seqDataStructures.DynamicArray;

public class HashIterate<T> {
	private ArrayList list;
	private int current;
	
	public HashIterate(hashtable table) {
		this.list = table.getKeySet();
		current = 0;
	}
	
	public boolean hasNext() {
		if(list.size() > current) {
			return true;
		}else {
			return false;
		}
	}
	
	public T next() {
		T next = null;
		if(hasNext()) {
			next = (T) list.get(current);
			current++;
		}else {
			throw new IndexOutOfBoundsException("No hay más valores en la lista");
		}
		return next;
	}

}
