package maps;

public class HashNode<K, V> {
	public K key;
	V value;
	public final int hashCode;

	
	HashNode<K, V> next;

	// Constructor
	public HashNode(K key, V value, int hashCode)
	{
		this.key = key;
		this.value = value;
		this.hashCode = hashCode;
	}
}
