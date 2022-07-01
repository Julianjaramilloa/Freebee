package maps;


import java.util.ArrayList;
import java.util.Objects;


public class hashtable<K, V> {
	// Lista para la resolucion de colisiones mediante un encadenamiento separado
	public ArrayList<HashNode<K, V> > bucketArray;
	// Lista con todos los keys para luego poder iterar
	private ArrayList<K> keySet = new ArrayList<>();
	//capacidad actual 
	private int numBuckets;

	// tamaño actual
	private int size;

	
	public ArrayList getBucketArray() {
		return this.bucketArray;
	}
	
	public ArrayList getKeySet() {
		return this.keySet;
	}


	// Constructor 
	public hashtable()
	{
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 0;

		// listas vacias
		for (int i = 0; i < numBuckets; i++)
			bucketArray.add(null);
	}

	public int size() { return size; }
	public boolean isEmpty() { return size() == 0; }
	
	
	// Custom Hashcode
	public final int hashCode(K key) {
        int hash = 0;
        int length = key.toString().length();
        for (int i = 0;i < length;i++) {
        	hash = 37 * hash + key.toString().charAt(i);       	
        }       
        //
        if(hash < 0) {
        	hash += size;
        }        
        return hash;
    }

	
	// usamos la funcion hash para hallar el index del key
	public int getBucketIndex(K key)
	{
		int hashCode = hashCode(key);
		int index = hashCode % numBuckets;
		// por si el hashcode es negativo
		index = index < 0 ? index * -1 : index;
		return index;
	}

	// remover usando el key
	public V remove(K key)
	{
		// funcion hash para hallar el hashcode del key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		// buscamos el key en la lista
		HashNode<K, V> prev = null;
		while (head != null) {
			
			if (head.key.equals(key) && hashCode == head.hashCode)
				break;

			
			prev = head;
			head = head.next;
		}

		
		if (head == null)
			return null;

		
		size--;
		
		// eliminamos el key de la lista
		if (prev != null)
			prev.next = head.next;
		else
			bucketArray.set(bucketIndex, head.next);
		keySet.remove(key);	
		return head.value;
	}

	// obtener el valor del key
	public V get(K key)
	{
		// buscamos el head de la lista de la llave dada
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
	
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		// buscamos en la lista
		while (head != null) {
			if (head.key.equals(key) && head.hashCode == hashCode)
				return head.value;
			head = head.next;
		}

		
		return null;
	}

	// agregamos un key,value a la tabla hash
	public void add(K key, V value)
	{
		// encontramos el head de la lista 
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		// revisamos si ya existe el key
		while (head != null) {
			if (head.key.equals(key) && head.hashCode == hashCode) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		// insertamos en la lista 
		size++;
		head = bucketArray.get(bucketIndex);
		HashNode<K, V> newNode
			= new HashNode<K, V>(key, value, hashCode);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);
		keySet.add(key);


		//si pasamos el factor de carga, incrementamos el tamaño de la table en 2.
		if ((1.0 * size) / numBuckets >= 0.7) {
			ArrayList<HashNode<K, V> > temp = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets = 2 * numBuckets;
			size = 0;
			for (int i = 0; i < numBuckets; i++)
				bucketArray.add(null);

			for (HashNode<K, V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

}
