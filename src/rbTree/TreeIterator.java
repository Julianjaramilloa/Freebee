package rbTree;

import java.util.NoSuchElementException;

public class TreeIterator {
    private RbNode next;

    public TreeIterator(RbNode root) {
        next = root;
        if(next == null)
            return;

        while (next.left != null)
           next = next.left;
    }

    public boolean hasNext(){
        return next != null;
    }

    public RbNode next(){
        if(!hasNext()) throw new NoSuchElementException();
        RbNode r = next;

        // If you can walk right, walk right, then fully left.
        // otherwise, walk up until you come from left.
        if(next.right != null) {
            next = next.right;
            while (next.left != null)
                next = next.left;
            return r;
        }

        while(true) {
            if(next.parent == null) {
                next = null;
                return r;
            }
            if(next.parent.left == next) {
                next = next.parent;
               return r;
            }
            next = next.parent;
        }
     }
 }
