package rbTree;

import java.time.LocalDate;

public interface BinarySearchTree extends BinaryTree {
	  RbNode searchNode(LocalDate key);
	  void insertNode(LocalDate key);
	  void deleteNode(LocalDate key);
	}
