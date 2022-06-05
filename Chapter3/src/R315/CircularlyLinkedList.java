package R315;

public class CircularlyLinkedList <E> {
  private static class Node <E> {
    private E element; // reference to the element stored at this node
    private Node <E> next; // reference to the subsequent node in the list
    public Node(E e, Node <E> n) {
      element = e;
      next = n;
    }

    public E getElement() {
      return element;
    }

    public Node < E > getNext() {
      return next;
    }

    public void setNext(Node < E > n) {
      next = n;
    }
  }

  // instance variables of the CircularlyLinkedList
  private Node < E > tail = null; // we store tail (but not head)
  private int size = 0; // number of nodes in the list
  public CircularlyLinkedList() {} // constructs an initially empty list
  // access methods
  public int size() {
    return size;
  }
  public boolean isEmpty() {
    return size == 0;
  }
  public E first() { // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return tail.getNext().getElement(); // the head is *after* the tail
  }
  public E last() { // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }
  // update methods
  public void rotate() { // rotate the first element to the back of the list
    if (tail != null) // if empty, do nothing
      tail = tail.getNext(); // the old head becomes the new tail
  }
  public void addFirst(E e) { // adds element e to the front of the list
    if (size == 0) {
      tail = new Node < > (e, null);
      tail.setNext(tail); // link to itself circularly
    } else {
      Node < E > newest = new Node < > (e, tail.getNext());
      tail.setNext(newest);
    }
    size++;
  }
  public void addLast(E e) { // adds element e to the end of the list
    addFirst(e); // insert new element at front of list
    tail = tail.getNext(); // now new element becomes the tail
  }
  public E removeFirst() { // removes and returns the first element
    if (isEmpty()) return null; // nothing to remove
    Node < E > head = tail.getNext();
    if (head == tail) tail = null; // must be the only node left
    else tail.setNext(head.getNext()); // removes ”head” from the list
    size--;
    return head.getElement();
  }
  
  public boolean equals(CircularlyLinkedList<E> linkedList) {
	  
	  if(isEmpty() && linkedList.isEmpty()) {
		  return true;
	  } else if(isEmpty())  {
		  return false; 
	  }else if(linkedList.isEmpty())  {
		  return false; 
	  }
	  
	  if(size != linkedList.size) {
		  return false;
	  }

	  
	  Node<E> current = tail.getNext();
	  Node<E> currentToCompare = linkedList.tail.getNext();
	  while(current != tail) {
		  if(current.element != currentToCompare.element) {
			  return false;
		  }
		  current = current.getNext();
		  currentToCompare = currentToCompare.getNext();
	  }
	  
	  return true;
  }
  
  public static void main(String[] args) {
	  CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
		  list.addFirst("a");
		  list.addFirst("b");
		  list.addFirst("c");
		  list.addFirst("d");
		  list.addFirst("e");
		  list.addFirst("f");
		  list.addFirst("g");
		  list.addFirst("i");

	  CircularlyLinkedList<String> list2 = new CircularlyLinkedList<String>();
	  	list2.addFirst("a");
	  	list2.addFirst("b");
	  	list2.addFirst("c");
	  	list2.addFirst("s");
	  	list2.addFirst("e");
	  	list2.addFirst("f");
	  	list2.addFirst("g");
	  	list2.addFirst("i");
		  
	   boolean equals = list.equals(list2);
		  
	   System.out.println(equals);  
	  }
  
  
}