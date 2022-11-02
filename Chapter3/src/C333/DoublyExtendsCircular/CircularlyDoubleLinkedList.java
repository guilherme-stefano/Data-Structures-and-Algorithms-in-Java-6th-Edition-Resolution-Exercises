package C333.DoublyExtendsCircular;


public class CircularlyDoubleLinkedList<E> extends CircularlyLinkedList {
	  
	  protected CircularlyNode < E > tail; // header sentinel
	  
	  public E first() {
	  
	  }
	  
	  public E last() { 
	  
	  }

	  public void rotate() {
	  
	  }

	  public void  addFirst(E e) {

	  }

	  public void addLast(E e) {
	  
	  }
	  
	  public E removeFirst() { 
	  
	  }
	  
	   public E removeLast() {

	   }
	

	   protected void addBetween(E e, DoublyNode < E > predecessor, DoublyNode < E > successor) {
	     // create and link a new node
	     DoublyNode < E > newest = new DoublyNode < > (e, predecessor, successor);
	     predecessor.setNext(newest);
	     successor.setPrev(newest);
	     size++;
	   }

	   protected E remove(DoublyNode < E > node) {
	     DoublyNode < E > predecessor = node.getPrev();
	     DoublyNode < E > successor = node.getNext();
	     predecessor.setNext(successor);
	     successor.setPrev(predecessor);
	     size--;
	     return node.getElement();
	   }
}
