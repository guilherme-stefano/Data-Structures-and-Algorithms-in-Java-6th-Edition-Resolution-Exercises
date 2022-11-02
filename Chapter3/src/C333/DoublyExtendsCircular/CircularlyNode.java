package C333.DoublyExtendsCircular;

public class CircularlyNode<E> extends Node {
	private CircularlyNode<E> prev;
	
	public CircularlyNode(E e, CircularlyNode < E > p, CircularlyNode < E > n) {
		super(e, n);
	    prev = p;
	}
	
    public CircularlyNode < E > getPrev() {
	      return prev;
	}
	
    public void setPrev(CircularlyNode < E > p) {
        prev = p;
      }

}