package avlTree;

import seqDataStructures.LinkedList;

public class AVLTree<T extends Comparable<T>> implements BinarySearchTree<T>{

	protected Node<T> root;
	private int size = 0;
	
	@Override
	public void insertNode(T key) {
		Node<T> candidate = root;
		Node<T> parent = null;
		Node<T> toInsert = new Node<T>(key);
		
		while(candidate != null) {
			parent = candidate;
			if(key.compareTo(candidate.data) < 0) {
				candidate = candidate.left;
			}else if(key.compareTo(candidate.data) > 0) {
				candidate = candidate.right;
			}else {
				throw new IllegalArgumentException("El Árbol ya contiene el dato " + key);
			}
		}
		
		if (parent == null) {
		      root = toInsert;
		}else if(key.compareTo(parent.data) < 0) {
		      parent.left = toInsert;
		}else{
		      parent.right = toInsert;
		}
		    toInsert.parent = parent;
		
		updateHeightsAndGuaranteeBalance(toInsert);
		size++;
	}
	
	@Override
	public void deleteNode(T key) {
		Node<T> toDelete = null;
		try {
			toDelete = searchNode(key);
		}catch (NullPointerException npe) {
			System.err.println("El dato que está intentado eliminar no está presente en el árbol");
			npe.printStackTrace();
		}
		
		Node<T> parent = toDelete.parent;
		if(height(toDelete) == 0) {
			if(parent.right == toDelete) {
				parent.right = null;
			}else {
				parent.left = null;

			}
			updateHeightsAndGuaranteeBalance(parent);
		}else if(toDelete.right == null){
			Node<T> replacement = toDelete.left;
			if(parent.right == toDelete) {
				parent.right = replacement;
			}else {
				parent.left = replacement;
			}
			replacement.parent = parent;
			updateHeightsAndGuaranteeBalance(replacement);
		}
		else if(toDelete.left == null){
			Node<T> replacement = toDelete.right;
			if(parent.right == toDelete) {
				parent.right = replacement;
			}else {
				parent.left = replacement;
			}
			replacement.parent = parent;
			updateHeightsAndGuaranteeBalance(replacement);
		}else{
			Node<T> replacement = inorderPredecessor(toDelete);
			Node<T> replacementParent = replacement.parent;
			
			boolean adjustReplacementParent;
			if(replacementParent == toDelete) {
				adjustReplacementParent = false;
			}else {
				adjustReplacementParent = true;
			}
			boolean deletingRoot;
			if(toDelete == root) {
				deletingRoot = true;
			}else {
				deletingRoot = false;
			}
			
			Node<T> preserveRight = toDelete.right;
			Node<T> preserveLeft = toDelete.left;

			if(deletingRoot) {
				replacement.parent = null;
				this.root = replacement;
			}else {
				replacement.parent = parent;
					
				if(parent.right == toDelete) {
					parent.right = replacement;
				}else{
					parent.left = replacement;
				}
			}
			
			if(preserveRight != replacement) {
				replacement.right = preserveRight;
				if(preserveRight != null) {
					preserveRight.parent = replacement;
				}
			}
			
			if(preserveLeft != replacement) {
				replacement.left = preserveLeft;
				if(preserveLeft != null) {
					preserveLeft.parent = replacement;
				}
			}
			
			if(adjustReplacementParent) {
				replacementParent.right = null;
			}
			updateHeightsAndGuaranteeBalance(replacementParent);

		}
		size--;
		
	}
	
	private Node<T> inorderPredecessor (Node<T> succesor) {
		Node<T> inorderPredecessor = succesor.left;
		while(inorderPredecessor.right != null) {
			inorderPredecessor = inorderPredecessor.right;
		}
		return inorderPredecessor;
	}
	
	@Override
	public Node<T> searchNode(T key) {
		Node<T> aux = root;
		Node<T> toReturn = null;
		while(aux != null) {	
			if(aux.data.compareTo(key) == 0) {
				toReturn = aux;
				break;
			}else if(key.compareTo(aux.data)>0) {
				aux = aux.right;
			}else{
				aux = aux.left;
			}
		}
		return toReturn;
		
	}
	
	private void updateHeightsAndGuaranteeBalance(Node<T> current) {
		while(current != null) {
			updateHeight(current);
			int bf = balanceFactor(current);
			if( bf <-1 || bf> 1 ) {
				balance(current, bf);
			}
			current = current.parent;
		}
	}
	
	private void updateHeight(Node<T> n) {
		n.height = (1 + Math.max(height(n.left), height(n.right)));
	}
	
	private int height(Node<T> n) {
		if(n == null) {
			return -1;
		}else {
			return (n.height);
		}
	}
	
	private int balanceFactor(Node<T> n) {
		if(n == null) {
			return 0;
		}else {
			return (height(n.right) - height(n.left));
		}
	}
	
	private void balance(Node<T> toBalance, int balanceFactor) {
		if(balanceFactor > 1) {
			rightBalance(toBalance);
		}else if(balanceFactor < -1){
			leftBalance(toBalance);
		}else{
			throw new RuntimeException ("El ï¿½rbol actual no necesita ser desbalanceado");
		}
		
	}
	
	private void rightBalance(Node<T> toBalance) {
		Node<T> subTreeParent = toBalance.parent;
		boolean treeComesFromLeft = treeComesFromLeft(subTreeParent, toBalance);
		if(height(toBalance.right.right) > height(toBalance.right.left)) {
			Node<T> balanced = rotateLeft(toBalance);
			adjustParentOfBalancedSubtree(balanced, subTreeParent, treeComesFromLeft);
		}else {
			toBalance.right = rotateRight(toBalance.right);
			toBalance.right.parent = toBalance;
			
			Node<T> balanced = rotateLeft(toBalance);
			adjustParentOfBalancedSubtree(balanced, subTreeParent, treeComesFromLeft);
		}
	}
	
	private void leftBalance(Node<T> toBalance) {
		Node<T> subTreeParent = toBalance.parent;
		boolean treeComesFromLeft = treeComesFromLeft(subTreeParent, toBalance);
		if(height(toBalance.left.left) > height(toBalance.left.right)) {
			Node<T> balanced = rotateRight(toBalance);
			adjustParentOfBalancedSubtree(balanced, subTreeParent, treeComesFromLeft);
		}else {
			System.out.println("Sha ca toy");
			toBalance.left = rotateLeft(toBalance.left);
			toBalance.left.parent = toBalance;
			
			Node<T> balanced = rotateRight(toBalance);
			adjustParentOfBalancedSubtree(balanced, subTreeParent, treeComesFromLeft);
		}
	}
	
	private boolean treeComesFromLeft(Node<T> subTreeParent, Node<T> toBalance) {
		boolean comesFromLeft;
		if(subTreeParent == null) {
			comesFromLeft = false;
		}else if(subTreeParent.left == toBalance) {
			comesFromLeft = true;
		}else{
			comesFromLeft = false;
		}
		return comesFromLeft;
	}
	
	private void adjustParentOfBalancedSubtree(Node<T> balancedTreeRoot, Node<T> subTreeParent, boolean isParentLeft) {
		if(subTreeParent == null) {
			this.root = balancedTreeRoot;
			root.parent = null;
		}else{
			balancedTreeRoot.parent = subTreeParent;
			if(isParentLeft) {
				subTreeParent.left = balancedTreeRoot;
			}else {
				subTreeParent.right = balancedTreeRoot;
			}
		}
	}
	
	/*
	 *Las palabras "oldRoot" y "newRoot" se refieren aquï¿½ a la raï¿½z del subï¿½rbol que estamos balanceando,
	 *          no tienen necesariamente que ser la raï¿½z de todo el ï¿½rbol 
	 */
	
	public Node<T> rotateRight(Node<T> oldRoot) {
		Node<T> newRoot = oldRoot.left;
		Node<T> toAdjust = newRoot.right;
		
		newRoot.right = oldRoot;
		oldRoot.parent = newRoot;
		oldRoot.left = toAdjust;
				
		if(toAdjust != null) {
			toAdjust.parent = oldRoot;
		}
		
		updateHeight(oldRoot);
		updateHeight(newRoot);
		
		return(newRoot);
	}
	
	public Node<T> rotateLeft(Node<T> oldRoot) {
		Node<T> newRoot = oldRoot.right;
		Node<T> toAdjust = newRoot.left;
		
		newRoot.left = oldRoot;
		oldRoot.parent = newRoot;
		oldRoot.right = toAdjust;			
		if(toAdjust != null) {
			toAdjust.parent = oldRoot;
		}
		
		updateHeight(oldRoot);
		updateHeight(newRoot);
		
		return(newRoot);
	}
	
	@Override  
	public Node<T> getRoot() {
	  	  return root;
	}
	
	public int size() {
		return size;
	}
	
	//Los mï¿½todos de acï¿½ en adelante sirven para el propósito de mostrar la información del arbol

	  @Override
	  public String toString() {
	    if(root == null) {
	    	return "Ã�rbol VacÃ­o";
	    }else {
	    	StringBuilder builder = new StringBuilder();
	  	    appendNodeToStringRecursive(getRoot(), builder, false);
	  	    return builder.toString();
	    }
	  }
	  
	  public String showHeights() {
		if(root == null) {
		  	return "+Arbol VacÃ­o";
		}else {
		   	StringBuilder builder = new StringBuilder();
		    appendNodeToStringRecursive(getRoot(), builder, true);
		    return builder.toString();
		}	  	  
	  }
	  
	  public String preorderTraverse() {
			if(root == null) {
			  	return "No data";
			}else {
			   	StringBuilder builder = new StringBuilder();
			   	appendNodesInPreorder(getRoot(), builder, false);
			    return builder.toString();
			}	 
	  }

	  private void appendNodeToStringRecursive(Node<T> node, StringBuilder builder, boolean showHeight) {
	    appendNodeToString(node, builder, showHeight);
	    if (node.left != null) {
	      builder.append(" L{");
	      appendNodeToStringRecursive(node.left, builder, showHeight);
	      builder.append('}');
	    }
	    if (node.right != null) {
	      builder.append(" R{");
	      appendNodeToStringRecursive(node.right, builder, showHeight);
	      builder.append('}');
	    }
	  }
	  
	  private void appendNodesInPreorder(Node<T> node, StringBuilder builder, boolean showHeight) {
		    appendNodeToString(node, builder, showHeight);
		    builder.append('\n');
		    if (node.left != null) {
		      appendNodesInPreorder(node.left, builder, showHeight);
		    }
		    if (node.right != null) {
		      appendNodesInPreorder(node.right, builder, showHeight);
		    }
	  }

	  protected void appendNodeToString(Node<T> node, StringBuilder builder, boolean showHeight) {
	    if(showHeight) {
	    	builder.append(node.data + "-" + node.height);
	    }else {
	    	builder.append(node.data);	
	    }
	    
	  }
	  
	 

	
}
