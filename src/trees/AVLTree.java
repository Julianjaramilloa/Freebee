package trees;

public class AVLTree extends BaseBinaryTree implements BinarySearchTree{

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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Node searchNode(int key) {
		Node aux = root;
		while(aux != null) {	
			if(aux.data == key) {
				return aux;
			}else if(key > aux.data) {
				aux = aux.right;
			}else{
				aux = aux.right;
			}
		}
		return null;
	}
	
	private void updateHeightsAndGuaranteeBalance(Node current) {
		//System.out.println("Inserted: " + current.data);
		while(current != null) {
			updateHeight(current);
			int bf = balanceFactor(current);
			if( bf <-1 || bf> 1 ) {
				balance(current, bf);
			}
			current = current.parent;
		}
		//System.out.println(toString());
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
}
