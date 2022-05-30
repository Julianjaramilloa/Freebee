package seqDataStructures;

import java.util.NoSuchElementException;


//Implementación de Listas Enlazadas
public class LinkedList<T> implements List<T> {
	
	protected Node<T> head = null;
	protected Node<T> tail = null; //Muchas de las inserciones se van a hacer al final. Por eso se incluyó esta referencia
	private int size = 0;
	
	@Override
	public void pushBack(T data) 
	{
		Node<T> aux = new Node<T>(data);
		if(head == null) {
			head = aux;
			tail = head;
		}else {
			tail.next = aux;
			tail = tail.next;
		}
		
		size++;
	}
	
	
	@Override
	public void add(T data, int index) 
	{
		if(size < index) {
			throw new IndexOutOfBoundsException("No se puede introducir un Nodo en ese índice porque el tamaño de la lista ("+ size() +") no alcanza");
		}
		
		Node<T> toInsert = new Node<T>(data);
		
		if((size == 0 && index == 0) || size == index){
			pushBack(data);
			return;
		}else if(index==0){
			toInsert.next = head;
			head = toInsert;
		}else{
	        Node<T> temp = head;	       
	        Node<T> prev = new Node<T>(null);
	        int remainingIterations = index;
	        
	        while (remainingIterations-1 > -1) {
	            prev = temp;
	            temp = temp.next;
	            remainingIterations--;
	        }
	        
	        if(index == (size-1)) {
	        	
	        }
	        prev.next = toInsert;
	        prev.next.next = temp;
		}
		
		size++;
	}
	
	@Override
	public void clear() //Borrar todos los objetos
    {
        head = null;
        size = 0;
    }

	@Override
	public int size() 
	{
		return this.size;	
	}


	@Override
	public boolean isEmpty() 
	{
		if(head == null) {
			return true;
		}else{
			return false;
		}
	}
	
	private void checkIndex(int index) {		
		if(size <= index || index < 0) {
			throw new IndexOutOfBoundsException("El índice es inválido.");
		}
	}
	
	public LinkedLIterator<T> iterate(){
		return new LinkedLIterator<T>(this);
	}
	
	@Override
	public T get(int index) {
		checkIndex(index);
		Node<T> aux = head;
		for(int i=0; i<index;i++) {
			aux = aux.next;
		}
		return aux.data;
	}
	
    /*
     * En los dos siguientes métodos, necesarios para remover elementos de la lista, se debe
     * hacer una iteración. Para esto se necesita tener tres variables: 
     * un nodo anterior, un nodo posterior y un nodo en el medio. Cuando el nodo
     * del medio sea el nodo a eliminar, el apuntador del nodo anterior empieza 
     * a apuntar al posterior y con ello el del medio queda fuera de la lista.
     */

	@Override
	public void remove(int index) //Método para eliminar nodos buscandolos por el índice
	{
		checkIndex(index);
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("La lista está vacía");
		}

        Node<T> prev = new Node<T>(null);
        prev.next = head;
        Node<T> next = head.next;
        Node<T> mid = head;
        
        for(int i=0; i<index; i++) {
            prev = mid;
            mid = mid.next;
            next = mid.next;
        }
        
        prev.next = next;
        size--;
        
	}
	
	@Override
	public void removeKey(T key) //Método que elimina el primer nodo cuyo dato T sea igual a key 
	{

		if(isEmpty()) {
			throw new IndexOutOfBoundsException("La lista está vacía");
		}
 
        Node<T> prev = new Node<T>(null);
        prev.next = head;
        Node<T> next = head.next;
        Node<T> mid = head;
 
        boolean exists = false;
 

        if (head.data == key) {
            head = head.next;
            exists = true;
        }
 
       /*Este ciclo while encuentra el primer caso donde el valor que guarda
        *el nodo es igual al dato key que queremos eliminar de la lista. 
        */
      
        while (mid.next != null) {
            
        	if (String.valueOf(mid.data).equals(String.valueOf(key))) {
                //La siguiente sentencia elimina el nodo del medio de la lista.
            	prev.next = next;

                exists = true;
                break;
            }
            
            prev = mid;
            mid = mid.next;
            next = mid.next;
        }
 
        //Es necesario revisar si la cola de la lista tiene el valor que nos interesa eliminar
        if (exists == false
            && String.valueOf(mid.data).equals(
                String.valueOf(key))) {
            prev.next = null;
 
            exists = true;
        }
 
        if (exists) {
            size --;        
        }else {
            throw new NoSuchElementException("En la lista no existe ningún elemento " + key.toString());
        }
        
	}

	@Override	
	public String toString() {
		if(head == null) 
			return "[Empty]";
		
		String toShow = "[Head: ";
		Iterator<T> it = new LinkedLIterator<T>(this);
		for(int i=0; i<size; i++) {
			String data = it.next().toString();
			toShow += (data + " -> ");
		}
		toShow = toShow.substring(0, toShow.length() - 4);
		toShow += ": Tail]";
		return toShow;
	}


	@Override
	public void replace(int index, T data) {
		checkIndex(index);
		Node<T> aux = head;
		for(int i=0; i<index; i++) {
			aux=aux.next;
		}
		aux.data = data;
	}
	


}


