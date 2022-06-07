package rbTree;

import logic.User;

public interface BinarySearchTree extends BinaryTree {
	  RbNode searchNode(String key);
	  void insertNode(String key,User user);
	  void deleteNode(String key);
	}
