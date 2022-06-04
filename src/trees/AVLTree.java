package trees;

public class AVLTree extends BaseBinaryTree implements BinarySearchTree{

	
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
	
	private void updateHeightsAndGuaranteeBalance(Node current) {
		System.out.println("Inserted: " + current.data);
		while(current != null) {
			updateHeight(current);
			int bf = balanceFactor(current);
			if( bf <-1 || bf> 1 ) {
				System.out.println("bf: " + bf);
				balance(current, bf);
				current = current.parent.parent;
				System.out.println("Nuevo Current: " + current);
			}else {
				current = current.parent;
			}
			//System.out.println(current.data + ": " +height(current));
			//System.out.println("Balance Factor: " + balanceFactor(current));
			
		}
		//System.out.println("Balance Factor Tree: " + balanceFactor(root));
		System.out.println(toString());
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
		if(height(toBalance.right.right) > height(toBalance.right.left)) {
			Node rotated = rotateLeft(toBalance);
			subTreeParent.right = rotated;
			rotated.parent = subTreeParent;
		}else {
			toBalance.right = rotateRight(toBalance.right);
			toBalance.right.parent = toBalance;
			
			Node rotated = rotateLeft(toBalance);
			subTreeParent.left = rotated;
			rotated.parent = subTreeParent;
		}
	}
	
	private void leftBalance(Node toBalance) {
		Node subTreeParent = toBalance.parent;
		if(height(toBalance.left.left) > height(toBalance.left.right)) {
			Node rotated = rotateRight(toBalance);
			subTreeParent.left = rotated;
			rotated.parent = subTreeParent;
		}else {
			toBalance.left = rotateLeft(toBalance.left);
			toBalance.left.parent = toBalance;
			
			Node rotated = rotateRight(toBalance);
			subTreeParent.right = rotated;
			rotated.parent = subTreeParent;
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
