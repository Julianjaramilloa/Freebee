package seqDataStructures;

public interface List<T> {
	public void add(T data, int index);
	public void pushBack(T data);
	public void remove(int index);
	public void removeKey(T key);
	public void replace(int index, T data);
	public T get(int index);
	public void clear();
	public int size();
	public boolean isEmpty();
}
