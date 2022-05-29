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
		Node toInsert = new Node(key);
		
		while(candidate != null) {
			if(key < candidate.data ) {
				candidate = candidate.left;
			}else if(key > candidate.data) {
				candidate = candidate.right;
			}else {
				throw new IllegalArgumentException("El árbol ya contiene el dato " + key);
			}
		}
		candidate = toInsert;
		//updateAndCheckBalance(candidate);
	}
	
	private void updateAndCheckBalance(Node child) {
		while(child.parent != null) {
			if(child.parent.height == child.height) {
				child.parent.height = child.height;
			}
			child = child.parent;
		}
	}
	
	private void balance(int key) {
		
	}

	@Override
	public void deleteNode(int key) {
		// TODO Auto-generated method stub
		
	}
	


}
