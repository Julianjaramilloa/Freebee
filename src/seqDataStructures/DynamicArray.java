package seqDataStructures;

import java.util.NoSuchElementException;

public class DynamicArray<T> implements List<T> {

	private T[] arr =(T[]) new Object[1];
	int size = 0;
	
	public void checkIndex(int index) {
		if(size < index || index < 0) {
			throw new IndexOutOfBoundsException("El índice es inválido.");
		}
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}else{
			return false;
		}
	}
	
	
	@Override
	public void add(T data, int index) {
		checkIndex(index);
		if(size == arr.length) {
			expandArr();
		}
		for(int i=size-1; i>= index; i--) {
			arr[i+1] = arr[i];
		}
		arr[index] = data;
		size++;
	}

	@Override
	public void pushBack(T data) {
		if(size == arr.length) {
			expandArr();
		}
		arr[size] = data;
		size++;
		
	}

	private void expandArr() {
		T[]aux = arr;
		arr = (T[])new Object[arr.length*2];
		for(int i=0; i<aux.length; i++) {
			arr[i] = aux[i];
		}
	}
	
	@Override
	public void remove(int index) {
		checkIndex(index);
		for(int i=index+1; i<size;i++) {
			arr[i-1] = arr[i];
		}
		int blankSpace = size-1; 
		arr [blankSpace] = null;
		size--;
	}
	
	@Override
	public void removeKey(T key) {
		boolean thereIs = false;
		for(int i=0; i<size; i++) {
			if(arr[i] == key) {
				thereIs = true;
				remove(i);
				
			}
		}
		if(!thereIs) {
			throw new NoSuchElementException("La lista está vacía");
		}
		
	}
	
	@Override
	public void replace(int index, T data) {
		checkIndex(index);
		arr[index] = data;
	}

	@Override
	public T get(int index) {
		checkIndex(index);
		return arr[index];
	}

	@Override
	public void clear() {
		arr = (T[]) new Object[1];;
		size = 0;
	}
	
	public DynamicArrayIterator<T> iterate(){
		return new DynamicArrayIterator<T>(this);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0; i<size; i++) {
			sb.append(arr[i].toString());
			sb.append(", ");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");		
		return sb.toString();
		
	}
	
	public String verticalOrder() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			sb.append(arr[i].toString());
			sb.append(";\n ");
		}
		return sb.toString();
		
	}

}
