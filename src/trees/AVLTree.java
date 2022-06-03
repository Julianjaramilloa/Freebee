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
		    
		

		
		updateAndCheckBalance(toInsert);
	}
	
	private void updateAndCheckBalance(Node child) {
		System.out.println("Inserted: " + child.data);
		while(child != null) {
			updateHeight(child);
			System.out.println(child.data + ": " +height(child));
			child = child.parent;
		}
	}
	
	private void updateHeight(Node n) {
		n.height = 1 + Math.max(height(n.left), height(n.right));
	}
	
	private int height(Node n) {
		if(n == null) {
			return -1;
		}else {
			return (n.height);
		}
	}
	
	private void balance(int key) {
		
	}

	@Override
	public void deleteNode(int key) {
		// TODO Auto-generated method stub
		
	}
	


}
