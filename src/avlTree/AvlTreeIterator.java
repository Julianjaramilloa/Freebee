package avlTree;

import java.util.NoSuchElementException;

public class AvlTreeIterator<T> {
    private Node<T> next;

    public AvlTreeIterator(Node<T> root) {
        next = root;
        if(next == null)
            return;

        while (next.left != null)
           next = next.left;
    }

    public boolean hasNext(){
        return next != null;
    }

    public T next(){
        if(!hasNext()) throw new NoSuchElementException();
        Node<T> r = next;

        if(next.right != null) {
            next = next.right;
            while (next.left != null)
                next = next.left;
            return r.data;
        }

        while(true) {
            if(next.parent == null) {
                next = null;
                return r.data;
            }
            if(next.parent.left == next) {
                next = next.parent;
               return r.data;
            }
            next = next.parent;
        }
     }
 }
