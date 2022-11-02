package C333.CircularExtendsDoubly;

/** A basic doubly linked list implementation. */
public class CircularlyLinkedList < E > extends  DoublyLinkedList{
   private static class CircularNode < E > extends DoublyNode {
	   public CircularNode(Object e, DoublyNode p, DoublyNode n) {
			super(e, p, n);
		}
	} 

   public CircularlyLinkedList(){
	   super();
	   header.setPrev(trailer);
	   trailer.setNext(header);
   }
 
 }