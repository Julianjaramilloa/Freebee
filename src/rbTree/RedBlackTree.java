package rbTree;

import java.time.LocalDate;

import logic.Transaction;
import logic.User;

public class RedBlackTree extends BaseBinaryTree implements BinarySearchTree {

	  int size;
	  static final boolean RED = false;
	  static final boolean BLACK = true;
	  
	  public int getSize() {
		  return size;
	  }

	  @Override
	  public RbNode searchNode(String key) {
		RbNode node = root;
	    while (node != null) {
	    	if (key.compareToIgnoreCase(node.username) == 0) {
	        return node;
	      } else if (key.compareToIgnoreCase(node.username) < 0) {
	        node =  node.left;
	      } else {
	        node = node.right;
	      }
	    }
	    return null;
	  }

	  // -- Insertion ----------------------------------------------------------------------------------

	  @Override
	  public void insertNode(String key, User user) {
	    RbNode node = root;
	    RbNode parent = null;

	    while (node != null) {
	      parent = node;
	      if (key.compareToIgnoreCase(node.username) < 0) {
	        node = node.left;
	      } else if (key.compareToIgnoreCase(node.username) > 0) {
	        node = node.right;
	      } else {
	        throw new IllegalArgumentException("BST already contains a node with key " + key);
	      }
	    }

	    // Insert new node
	    RbNode newNode = new RbNode(user);
	    newNode.color = RED;
	    if (parent == null) {
	    	root = newNode;
	    } else if (key.compareToIgnoreCase(parent.username) < 0) {
	      parent.left = newNode;
	    } else {
	      parent.right = newNode;
	    }
	    newNode.parent = parent;

	    fixRedBlackPropertiesAfterInsert(newNode);
	    size++;
	  }

	  private void fixRedBlackPropertiesAfterInsert(RbNode node) {
	    RbNode parent = node.parent;

	    // Case 1: padre es null, llegamos al root.
	    if (parent == null) {
	      return;
	    }

	    // si el padre es negro no hacemos nada
	    if (parent.color == BLACK) {
	      return;
	    }

	    // Si el padre es rojo
	    RbNode grandparent = parent.parent;

	    // Case 2:
	    //si no tenemos un abuelo entonces el padre es el root y por lo 
	    //tanto lo volvemos negro
	    
	    if (grandparent == null) {
	      parent.color = BLACK;
	      return;
	    }

	    RbNode uncle = getUncle(parent);

	    // Case 3: tio es rojo -> recoloreamos el padre, abuelo y tio
	    if (uncle != null && uncle.color == RED) {
	      parent.color = BLACK;
	      grandparent.color = RED;
	      uncle.color = BLACK;

	      //volvemos a llamar la funcion para el abuelo ya que ahora es rojo
	      //Puede ser root or padre puede ser rojo por lo tanto hay mas
	      //propiedades por arreglar
	      fixRedBlackPropertiesAfterInsert(grandparent);
	    }


	    //padre es el hijo izquiero del abuelo
	    else if (parent == grandparent.left) {
	      // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
	      // Case 4a: tio es negro y el nodo es hijo derecho del abuelo
	      if (node == parent.right) {
	        rotateLeft(parent);

	        //el padre apunta al nuevo root del subarbol rotado.
	        //el cual tiene que ser recoloreado
	        parent = node;
	      }

	      // Case 5a: tio es negro y el node es hijo externo del abuelo
	      rotateRight(grandparent);

	      // recoloreamos el padre y abuelo original
	      parent.color = BLACK;
	      grandparent.color = RED;
	    }

	    // padre es hijo derecho del abuelo
	    else {
	      // Case 4b: tio es negro y el nodo es hijo interno del abuelo	
	      if (node == parent.left) {
	        rotateRight(parent);
	        parent = node;
	      }

	      // Case 5b: tio es negro, nodo es hijo externo del abuelo
	      rotateLeft(grandparent);

	      // recoloreamos el padre y abuelo
	      parent.color = BLACK;
	      grandparent.color = RED;
	    }
	  }

	  private RbNode getUncle(RbNode parent) {
	    RbNode grandparent = parent.parent;
	    if (grandparent.left == parent) {
	      return grandparent.right;
	    } else if (grandparent.right == parent) {
	      return grandparent.left;
	    } else {
	      throw new IllegalStateException("Parent is not a child of its grandparent");
	    }
	  }

	  // -- Deletion -----------------------------------------------------------------------------------

	  @Override
	  public void deleteNode(String key) {
	    RbNode node = root;

	    // buscamos el nodo que queremos eliminar
	    while (node != null && node.username.compareToIgnoreCase(key) != 0) {
	      // traversamos el arbol haciendo comparaciones lexicograficas
	      if (key.compareToIgnoreCase(node.username) < 0) {
	        node = node.left;
	      } else {
	        node = node.right;
	      }
	    }

	    // si no se encuentra el nodo
	    if (node == null) {
	      return;
	    }


	    size--;
	    RbNode movedUpNode;
	    boolean deletedNodeColor;

	    // nodo tiene 0 o 1 hijo
	    if (node.left == null || node.right == null) {
	      movedUpNode = deleteNodeWithZeroOrOneChild(node);
	      deletedNodeColor = node.color;
	    }

	    // nodo tiene 2 hijos
	    else {
	      // buscamos el nodo minimo
	      RbNode inOrderSuccessor = findMinimum(node.right);

	      node.username = inOrderSuccessor.username;

	      movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
	      deletedNodeColor = inOrderSuccessor.color;
	    }

	    if (deletedNodeColor == BLACK) {
	      fixRedBlackPropertiesAfterDelete(movedUpNode);

	      // eliminamos el nodo temporal nil
	      if (movedUpNode.getClass() == NilNode.class) {
	        replaceParentsChild(movedUpNode.parent, movedUpNode, null);
	      }
	    }
	  }

	  private RbNode deleteNodeWithZeroOrOneChild(RbNode node) {
		// el nodo solo tiene un hijo izquierdo  
	    if (node.left != null) {
	      replaceParentsChild(node.parent, node, node.left);
	      return node.left; // moved-up node
	    }

	    // nodo solo tiene hijo derecho
	    else if (node.right != null) {
	      replaceParentsChild(node.parent, node, node.right);
	      return node.right; // moved-up node
	    }

	    // nodo no tiene hijos
	    else {
	      RbNode newChild = node.color == BLACK ? new NilNode() : null;
	      replaceParentsChild(node.parent, node, newChild);
	      return newChild;
	    }
	  }

	  private RbNode findMinimum(RbNode node) {
	    while (node.left != null) {
	      node = node.left;
	    }
	    return node;
	  }

	  private void fixRedBlackPropertiesAfterDelete(RbNode node) {
	    // Case 1: si el nodo es root
	    if (node == root) {

	      return;
	    }

	    RbNode sibling = getSibling(node);

	    // Case 2: hermano rojo
	    if (sibling.color == RED) {
	      handleRedSibling(node, sibling);
	      sibling = getSibling(node); 
	    }

	    // Cases 3+4: hermano negro con dos hijos negros
	    if (isBlack(sibling.left) && isBlack(sibling.right)) {
	      sibling.color = RED;

	      //Case 3: hermano negro con dos hijos negros y padre rojo
	      if (node.parent.color == RED) {
	        node.parent.color = BLACK;
	      }

	      // Caso 4: hermano negro con dos hijos negros y padre negro
	      else {
	        fixRedBlackPropertiesAfterDelete(node.parent);
	      }
	    }

	    // Case 5+6: hermano negro con al menos un hijo rojo
	    else {
	      handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
	    }
	  }

	  private void handleRedSibling(RbNode node, RbNode sibling) {
	    sibling.color = BLACK;
	    node.parent.color = RED;

	    if (node == node.parent.left) {
	      rotateLeft(node.parent);
	    } else {
	      rotateRight(node.parent);
	    }
	  }

	  private void handleBlackSiblingWithAtLeastOneRedChild(RbNode node, RbNode sibling) {
	    boolean nodeIsLeftChild = node == node.parent.left;

	    // Case 5: hermano negro con al menos un hijo rojo, primo externo es negro

	    if (nodeIsLeftChild && isBlack(sibling.right)) {
	      sibling.left.color = BLACK;
	      sibling.color = RED;
	      rotateRight(sibling);
	      sibling = node.parent.right;
	    } else if (!nodeIsLeftChild && isBlack(sibling.left)) {
	      sibling.right.color = BLACK;
	      sibling.color = RED;
	      rotateLeft(sibling);
	      sibling = node.parent.left;
	    }


	    //Case 6: hermano negro con al menos un hijo rojo, primo externo es rojo
	    sibling.color = node.parent.color;
	    node.parent.color = BLACK;
	    if (nodeIsLeftChild) {
	      sibling.right.color = BLACK;
	      rotateLeft(node.parent);
	    } else {
	      sibling.left.color = BLACK;
	      rotateRight(node.parent);
	    }
	  }

	  private RbNode getSibling(RbNode node) {
	    RbNode parent = node.parent;
	    if (node == parent.left) {
	      return parent.right;
	    } else if (node == parent.right) {
	      return parent.left;
	    } else {
	      throw new IllegalStateException("Parent is not a child of its grandparent");
	    }
	  }

	  private boolean isBlack(RbNode node) {
	    return node == null || node.color == BLACK;
	  }

	  private static class NilNode extends RbNode {
	    private NilNode() {
	      super(0);
	      this.color = BLACK;
	    }
	  }

	  // -- Helpers for insertion and deletion ---------------------------------------------------------

	  private void rotateRight(RbNode node) {
	    RbNode parent = node.parent;
	    RbNode leftChild = node.left;

	    node.left = leftChild.right;
	    if (leftChild.right != null) {
	      leftChild.right.parent = node;
	    }

	    leftChild.right = node;
	    node.parent = leftChild;

	    replaceParentsChild(parent, node, leftChild);
	  }

	  private void rotateLeft(RbNode node) {
	    RbNode parent = node.parent;
	    RbNode rightChild = node.right;

	    node.right = rightChild.left;
	    if (rightChild.left != null) {
	      rightChild.left.parent = node;
	    }

	    rightChild.left = node;
	    node.parent = rightChild;

	    replaceParentsChild(parent, node, rightChild);
	  }

	  private void replaceParentsChild(RbNode parent, RbNode oldChild, RbNode newChild) {
	    if (parent == null) {
	      root = newChild;
	    } else if (parent.left == oldChild) {
	      parent.left = newChild;
	    } else if (parent.right == oldChild) {
	      parent.right = newChild;
	    } else {
	      throw new IllegalStateException("Node is not a child of its parent");
	    }

	    if (newChild != null) {
	      newChild.parent = parent;
	    }
	  }

	  // -- For toString() -----------------------------------------------------------------------------

	  @Override
	  protected void appendNodeToString(RbNode node, StringBuilder builder) {
	    builder.append(node.username).append(node.color == RED ? "[R]" : "[B]");
	  }


	}
