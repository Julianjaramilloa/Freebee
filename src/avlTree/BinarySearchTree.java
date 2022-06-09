package avlTree;

public interface BinarySearchTree<T> extends BinaryTree<T> {
	  Node<T> searchNode(T key);
	  void insertNode(T key);
	  void deleteNode(T key);
	}
