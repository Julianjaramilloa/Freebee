package rbTree;

import java.time.LocalDate;

import logic.Transaction;

public interface BinarySearchTree extends BinaryTree {
	  RbNode searchNode(LocalDate key);
	  void insertNode(LocalDate key,Transaction transaction);
	  void deleteNode(LocalDate key);
	}
