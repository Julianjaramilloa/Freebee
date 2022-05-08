package dataStructures;

import java.util.NoSuchElementException;

public class DynamicArray<T> implements List<T> {

	private T[] arr =(T[]) new Object[1];
	int size = 0;
	
	private void checkIndex(int index) {
		if(size <= index || index < 0) {
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
		arr[index] = data;
	}

	@Override
	public void pushBack(T data) {
		if(size == arr.length) {
			T[]aux = arr;
			arr = (T[])new Object[arr.length*2];
			for(int i=0; i<aux.length; i++) {
				arr[i] = aux[i];
			}
		}
		size++;
		arr[size] = data;
	}

	@Override
	public void remove(int index) {
		checkIndex(index);
		T toDelete = arr[index];
		
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
	public T get(int index) {
		checkIndex(index);
		return arr[index];
	}

	@Override
	public void clear() {
		arr = (T[]) new Object[1];;
		size = 0;
	}

}
