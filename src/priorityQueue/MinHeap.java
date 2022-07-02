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
		readjustAfterInsertion(size-1);
	}
	
	@Override
	public T deleteMin() {
		T min = arr[0];
		arr[0] = arr[size-1];
		arr[size-1] = null;
		size--;
		readjustAfterDeletion(0);
		return min;
	}
	
	public T peek() {
		return arr[0];
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		this.arr = (T[]) new Comparable[1];
	}
	
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}else {
			return false;
		}
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
	
	private void readjustAfterInsertion(int node) {
		int parent = parent(node);
		while (node > 0 && arr[parent].compareTo(arr[node]) > 0) {
			T aux = arr[parent];
			arr[parent] = arr[node];
			arr[node] = aux;
			
			node = parent;
			parent = parent(node);
		}
	}

	
	private void readjustAfterDeletion(int node) {
		while(node >= 0) {
			int swap = -1;
			int rightSon = rightSon(node);
			
			if(rightSon < size && arr[rightSon].compareTo(arr[node]) < 0) {
				int leftSon = leftSon(node);
				if(arr[leftSon].compareTo(arr[rightSon]) < 0) {
					swap = leftSon;
				}else {
					swap = rightSon;
				}
			}else{
				int leftSon = leftSon(node);
				if(leftSon < size && arr[leftSon].compareTo(arr[node]) < 0) {
					swap = leftSon;
				}
			}
			
			if(swap >= 0) {
				T aux = arr[swap];
				arr[swap] = arr[node];
				arr[node] = aux;
			}
			
			node = swap;
		}
	}
	

	
	private int leftSon(int index) {
		return 2*index + 1; 
	}
	
	private int rightSon(int index) {
		return 2*(index + 1); 
	}
	
	private int parent(int index) {
		return (index-1)/2;
	}
	
	//Para poder probar la estructura, pues en un minHeap no está está definida la posibilidad
	//de observar u obtener datos que no sean la raíz
	public String toString() {
		String heapInfo = "Heap order: ";
		for(int i=0; i<size; i++) {
			heapInfo += (arr[i].toString() + ", ");
		}
		return heapInfo;
	}

}
