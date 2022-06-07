package avlTree;

public class AVLTree implements BinarySearchTree{

	protected Node root;
	
	@Override
	public void insertNode(int key) {
		Node candidate = root;
		Node parent = null;
		Node toInsert = new Node(key);
		
		while(candidate != null) {
			parent = candidate;
			if(key < candidate.data ) {
				candidate = candidate.left;
			}else if(key > candidate.data) {
				candidate = candidate.right;
			}else {
				throw new IllegalArgumentException("El árbol ya contiene el dato " + key);
			}
		}
		
		if (parent == null) {
		      root = toInsert;
		}else if(key < parent.data) {
		      parent.left = toInsert;
		}else{
		      parent.right = toInsert;
		}
		    toInsert.parent = parent;
		
		updateHeightsAndGuaranteeBalance(toInsert);
	}
	
	@Override
	public void deleteNode(int key) {
		Node toDelete = null;
		try {
			toDelete = searchNode(key);
		}catch (NullPointerException npe) {
			System.err.println("El dato que está intentado eliminar no está presente en el árbol");
		}			
		Node parent = toDelete.parent;
		
		if(height(toDelete) == 0) {
			if(parent.right == toDelete) {
				parent.right = null;
			}else {
				parent.left = null;
			}
			updateHeightsAndGuaranteeBalance(parent);
		}else if(toDelete.right == null){
			Node replacement = toDelete.left;
			if(parent.right == toDelete) {
				parent.right = replacement;
			}else {
				parent.left = replacement;
			}
			replacement.parent = parent;
			updateHeightsAndGuaranteeBalance(replacement);
		}
		else if(toDelete.left == null){
			Node replacement = toDelete.right;
			if(parent.right == toDelete) {
				parent.right = replacement;
			}else {
				parent.left = replacement;
			}
			replacement.parent = parent;
			updateHeightsAndGuaranteeBalance(replacement);
		}else{
			Node replacement = toDelete.right;
			while(replacement.left != null) {
				replacement = replacement.left;
			}
			Node repParent = replacement.parent;
			if(parent.right == toDelete) {
				parent.right = replacement;
			}else {
				parent.left = replacement;
			}
			replacement.parent = parent;
			updateHeightsAndGuaranteeBalance(repParent);
		}
		
	}
	
	@Override
	public Node searchNode(int key) {
		Node aux = root;
		boolean found = false;
		while(aux != null ||  found == false) {	
			if(aux.data == key) {
				found = true;
			}else if(key > aux.data) {
				aux = aux.right;
			}else{
				aux = aux.left;
			}
		}
		return aux;
	}
	
	private void updateHeightsAndGuaranteeBalance(Node current) {
		while(current != null) {
			updateHeight(current);
			int bf = balanceFactor(current);
			if( bf <-1 || bf> 1 ) {
				balance(current, bf);
			}
			current = current.parent;
		}
	}
	
	private void updateHeight(Node n) {
		n.height = (1 + Math.max(height(n.left), height(n.right)));
	}
	
	private int height(Node n) {
		if(n == null) {
			return -1;
		}else {
			return (n.height);
		}
	}
	
	private int balanceFactor(Node n) {
		if(n == null) {
			return 0;
		}else {
			return (height(n.right) - height(n.left));
		}
	}
	
	private void balance(Node toBalance, int balanceFactor) {
		if(balanceFactor > 1) {
			rightBalance(toBalance);
		}else if(balanceFactor < -1){
			leftBalance(toBalance);
		}else{
			throw new RuntimeException ("El árbol actual no necesita ser desbalanceado");
		}
		
	}
	
	private void rightBalance(Node toBalance) {
		Node subTreeParent = toBalance.parent;
		boolean treeComesFromLeft = treeComesFromLeft(subTreeParent, toBalance);
		if(height(toBalance.right.right) > height(toBalance.right.left)) {
			Node balanced = rotateLeft(toBalance);
			adjustParentOfBalancedSubtree(balanced, subTreeParent, treeComesFromLeft);
		}else {
			toBalance.right = rotateRight(toBalance.right);
			toBalance.right.parent = toBalance;
			
			Node balanced = rotateLeft(toBalance);
			adjustParentOfBalancedSubtree(balanced, subTreeParent, treeComesFromLeft);
		}
	}
	
	private void leftBalance(Node toBalance) {
		Node subTreeParent = toBalance.parent;
		boolean treeComesFromLeft = treeComesFromLeft(subTreeParent, toBalance);
		if(height(toBalance.left.left) > height(toBalance.left.right)) {
			Node balanced = rotateRight(toBalance);
			adjustParentOfBalancedSubtree(balanced, subTreeParent, treeComesFromLeft);
		}else {
			toBalance.left = rotateLeft(toBalance.left);
			toBalance.left.parent = toBalance;
			
			Node balanced = rotateRight(toBalance);
			adjustParentOfBalancedSubtree(balanced, subTreeParent, treeComesFromLeft);
		}
	}
	
	private boolean treeComesFromLeft(Node subTreeParent, Node toBalance) {
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
	
	private void adjustParentOfBalancedSubtree(Node balancedTreeRoot, Node subTreeParent, boolean isParentLeft) {
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
	 *Las palabras "oldRoot" y "newRoot" se refieren aquí a la raíz del subárbol que estamos balanceando,
	 *          no tienen necesariamente que ser la raíz de todo el árbol 
	 */
	
	public Node rotateRight(Node oldRoot) {
		Node newRoot = oldRoot.left;
		Node toAdjust = newRoot.right;
		
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
	
	public Node rotateLeft(Node oldRoot) {
		Node newRoot = oldRoot.right;
		Node toAdjust = newRoot.left;
		
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
	public Node getRoot() {
	  	  return root;
	}

	  @Override
	  public String toString() {
	    if(root == null) {
	    	return "Árbol Vacío";
	    }else {
	    	StringBuilder builder = new StringBuilder();
	  	    appendNodeToStringRecursive(getRoot(), builder);
	  	    return builder.toString();
	    }
	  }

	  private void appendNodeToStringRecursive(Node node, StringBuilder builder) {
	    appendNodeToString(node, builder);
	    if (node.left != null) {
	      builder.append(" L{");
	      appendNodeToStringRecursive(node.left, builder);
	      builder.append('}');
	    }
	    if (node.right != null) {
	      builder.append(" R{");
	      appendNodeToStringRecursive(node.right, builder);
	      builder.append('}');
	    }
	  }

	  protected void appendNodeToString(Node node, StringBuilder builder) {
	    builder.append(node.data + "-" + node.height);
	  }
	
	
}
