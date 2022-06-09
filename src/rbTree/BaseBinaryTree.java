package rbTree;

public class BaseBinaryTree implements BinaryTree {

	  protected RbNode root;

	  @Override
	  public RbNode getRoot() {
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

	  private void appendNodeToStringRecursive(RbNode node, StringBuilder builder) {
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

	  protected void appendNodeToString(RbNode node, StringBuilder builder) {
	    builder.append(node.toString() + "-" );
	  }


	
	}
