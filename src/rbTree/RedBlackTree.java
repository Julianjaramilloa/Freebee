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
	      if (key == node.username) {
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

	    // Traverse the tree to the left or right depending on the key
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

	  @SuppressWarnings("squid:S125") // Ignore SonarCloud complains about commented code line 70.
	  private void fixRedBlackPropertiesAfterInsert(RbNode node) {
	    RbNode parent = node.parent;

	    // Case 1: Parent is null, we've reached the root, the end of the recursion
	    if (parent == null) {
	      // Uncomment the following line if you want to enforce black roots (rule 2):
	      // node.color = BLACK;
	      return;
	    }

	    // Parent is black --> nothing to do
	    if (parent.color == BLACK) {
	      return;
	    }

	    // From here on, parent is red
	    RbNode grandparent = parent.parent;

	    // Case 2:
	    // Not having a grandparent means that parent is the root. If we enforce black roots
	    // (rule 2), grandparent will never be null, and the following if-then block can be
	    // removed.
	    if (grandparent == null) {
	      // As this method is only called on red nodes (either on newly inserted ones - or -
	      // recursively on red grandparents), all we have to do is to recolor the root black.
	      parent.color = BLACK;
	      return;
	    }

	    // Get the uncle (may be null/nil, in which case its color is BLACK)
	    RbNode uncle = getUncle(parent);

	    // Case 3: Uncle is red -> recolor parent, grandparent and uncle
	    if (uncle != null && uncle.color == RED) {
	      parent.color = BLACK;
	      grandparent.color = RED;
	      uncle.color = BLACK;

	      // Call recursively for grandparent, which is now red.
	      // It might be root or have a red parent, in which case we need to fix more...
	      fixRedBlackPropertiesAfterInsert(grandparent);
	    }

	    // Note on performance:
	    // It would be faster to do the uncle color check within the following code. This way
	    // we would avoid checking the grandparent-parent direction twice (once in getUncle()
	    // and once in the following else-if). But for better understanding of the code,
	    // I left the uncle color check as a separate step.

	    // Parent is left child of grandparent
	    else if (parent == grandparent.left) {
	      // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
	      if (node == parent.right) {
	        rotateLeft(parent);

	        // Let "parent" point to the new root node of the rotated sub-tree.
	        // It will be recolored in the next step, which we're going to fall-through to.
	        parent = node;
	      }

	      // Case 5a: Uncle is black and node is left->left "outer child" of its grandparent
	      rotateRight(grandparent);

	      // Recolor original parent and grandparent
	      parent.color = BLACK;
	      grandparent.color = RED;
	    }

	    // Parent is right child of grandparent
	    else {
	      // Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
	      if (node == parent.left) {
	        rotateRight(parent);

	        // Let "parent" point to the new root node of the rotated sub-tree.
	        // It will be recolored in the next step, which we're going to fall-through to.
	        parent = node;
	      }

	      // Case 5b: Uncle is black and node is right->right "outer child" of its grandparent
	      rotateLeft(grandparent);

	      // Recolor original parent and grandparent
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

	  @SuppressWarnings("squid:S2259") // SonarCloud issues an incorrect potential NPE warning
	  @Override
	  public void deleteNode(String key) {
	    RbNode node = root;

	    // Find the node to be deleted
	    while (node != null && node.username.compareToIgnoreCase(key) != 0) {
	      // Traverse the tree to the left or right depending on the key
	      if (key.compareToIgnoreCase(node.username) < 0) {
	        node = node.left;
	      } else {
	        node = node.right;
	      }
	    }

	    // Node not found?
	    if (node == null) {
	      return;
	    }

	    // At this point, "node" is the node to be deleted

	    // In this variable, we'll store the node at which we're going to start to fix the R-B
	    // properties after deleting a node.
	    size--;
	    RbNode movedUpNode;
	    boolean deletedNodeColor;

	    // Node has zero or one child
	    if (node.left == null || node.right == null) {
	      movedUpNode = deleteNodeWithZeroOrOneChild(node);
	      deletedNodeColor = node.color;
	    }

	    // Node has two children
	    else {
	      // Find minimum node of right subtree ("inorder successor" of current node)
	      RbNode inOrderSuccessor = findMinimum(node.right);

	      // Copy inorder successor's data to current node (keep its color!)
	      node.date = inOrderSuccessor.date;

	      // Delete inorder successor just as we would delete a node with 0 or 1 child
	      movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
	      deletedNodeColor = inOrderSuccessor.color;
	    }

	    if (deletedNodeColor == BLACK) {
	      fixRedBlackPropertiesAfterDelete(movedUpNode);

	      // Remove the temporary NIL node
	      if (movedUpNode.getClass() == NilNode.class) {
	        replaceParentsChild(movedUpNode.parent, movedUpNode, null);
	      }
	    }
	  }

	  private RbNode deleteNodeWithZeroOrOneChild(RbNode node) {
	    // Node has ONLY a left child --> replace by its left child
	    if (node.left != null) {
	      replaceParentsChild(node.parent, node, node.left);
	      return node.left; // moved-up node
	    }

	    // Node has ONLY a right child --> replace by its right child
	    else if (node.right != null) {
	      replaceParentsChild(node.parent, node, node.right);
	      return node.right; // moved-up node
	    }

	    // Node has no children -->
	    // * node is red --> just remove it
	    // * node is black --> replace it by a temporary NIL node (needed to fix the R-B rules)
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

	  @SuppressWarnings("squid:S125") // Ignore SonarCloud complains about commented code line 256.
	  private void fixRedBlackPropertiesAfterDelete(RbNode node) {
	    // Case 1: Examined node is root, end of recursion
	    if (node == root) {
	      // Uncomment the following line if you want to enforce black roots (rule 2):
	      // node.color = BLACK;
	      return;
	    }

	    RbNode sibling = getSibling(node);

	    // Case 2: Red sibling
	    if (sibling.color == RED) {
	      handleRedSibling(node, sibling);
	      sibling = getSibling(node); // Get new sibling for fall-through to cases 3-6
	    }

	    // Cases 3+4: Black sibling with two black children
	    if (isBlack(sibling.left) && isBlack(sibling.right)) {
	      sibling.color = RED;

	      // Case 3: Black sibling with two black children + red parent
	      if (node.parent.color == RED) {
	        node.parent.color = BLACK;
	      }

	      // Case 4: Black sibling with two black children + black parent
	      else {
	        fixRedBlackPropertiesAfterDelete(node.parent);
	      }
	    }

	    // Case 5+6: Black sibling with at least one red child
	    else {
	      handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
	    }
	  }

	  private void handleRedSibling(RbNode node, RbNode sibling) {
	    // Recolor...
	    sibling.color = BLACK;
	    node.parent.color = RED;

	    // ... and rotate
	    if (node == node.parent.left) {
	      rotateLeft(node.parent);
	    } else {
	      rotateRight(node.parent);
	    }
	  }

	  private void handleBlackSiblingWithAtLeastOneRedChild(RbNode node, RbNode sibling) {
	    boolean nodeIsLeftChild = node == node.parent.left;

	    // Case 5: Black sibling with at least one red child + "outer nephew" is black
	    // --> Recolor sibling and its child, and rotate around sibling
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

	    // Fall-through to case 6...

	    // Case 6: Black sibling with at least one red child + "outer nephew" is red
	    // --> Recolor sibling + parent + sibling's child, and rotate around parent
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
	    builder.append(node.date).append(node.color == RED ? "[R]" : "[B]");
	  }


	}
