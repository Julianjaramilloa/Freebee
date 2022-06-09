package priorityQueue;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	private T[] arr = (T[]) new Comparable[1];
	private int size = 0; //Esta variable guarda la cantidad de objetos en el heap
	private int arraySize = 1; //Esta variable guarda el tamaño total del array
	
	
	@Override
	public void add(T data) {
		if(size == arraySize) {
			expandArray();
		}
		arr[size] = data;
		size++;
		guaranteeHeapConditions(data);
	}
	
	private void expandArray() {
		T[] aux = arr;
		int lenght = aux.length;
		this.arr = (T[]) new Comparable[arraySize*2];
		for(int i=0; i<lenght; i++) {
			arr[i] = aux[i];
		}
		arraySize = arraySize * 2;
	}
	
	private void guaranteeHeapConditions(T data) {
		
	}

	@Override
	public T deleteMin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int size() {
		return size;
	}
	
	public int leftSon(int index) {
		return 2*index + 1; 
	}
	
	public int rightSon(int index) {
		return 2*(index + 1); 
	}
	
	public int parent(int index) {
		return (index-1)/2 %2;
	}

}
