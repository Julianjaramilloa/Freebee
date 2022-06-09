package seqDataStructures;

public class Pila<T> {
	private T[] arr =(T[]) new Object[1];
	int size = 0;
	
	public void push(T data) {
		if(size == arr.length) {
			expandArr();
		}
		arr[size] = data;
		size++;
		
	}
	
	public T pop() {
		T pop = arr[size-1];
		remove();
		return pop;
	}
	
	public T peek() {
		return arr[size-1];
	}
	
	private void expandArr() {
		T[]aux = arr;
		arr = (T[])new Object[arr.length*2];
		for(int i=0; i<aux.length; i++) {
			arr[i] = aux[i];
		}
	}
	
	private void remove() {
		arr[size-1] = null;
		size--;
	}
	
	public void clear() {
		arr = (T[]) new Object[1];;
		size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}else{
			return false;
		}
	}
}
