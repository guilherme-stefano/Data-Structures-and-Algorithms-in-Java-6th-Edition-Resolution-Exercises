package C328;

public class SinglyLinkedList < E > {
  private static class Node < E > {
    private E element; // reference to the element stored at this node
    private Node <E> next; // reference to the subsequent node in the list
    public Node(E e, Node <E> n) {
      element = e;
      next = n;
    }

    public E getElement() {
      return element;
    }

    public Node <E> getNext() {
      return next;
    }

    public void setNext(Node < E > n) {
      next = n;
    }
  }
  // instance variables of the SinglyLinkedList
  private Node < E > head = null; // head node of the list (or null if empty)
  private Node < E > tail = null; // last node of the list (or null if empty)
  private int size = 0; // number of nodes in the list
  public SinglyLinkedList() {} // constructs an initially empty list
  // access methods
  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  public E first() { // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return head.getElement();
  }
  
  public E last() { // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }
  
  // update methods
  public void addFirst(E e) { // adds element e to the front of the list
    head = new Node <E> (e, head); // create and link a new node
    if (size == 0)
      tail = head; // special case: new node becomes tail also
    size++;
  }
  
  public void addLast(E e) { // adds element e to the end of the list
    Node < E > newest = new Node <E> (e, null); // node will eventually be the tail
    if (isEmpty())
      head = newest; // special case: previously empty list
    else
      tail.setNext(newest); // new node after existing tail
    tail = newest; // new node becomes the tail
    size++;
  }
  
  public E removeFirst() { // removes and returns the first element
    if (isEmpty()) return null; // nothing to remove
    E answer = head.getElement();
    head = head.getNext(); // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null; // special case as list is now empty
    return answer;
  }
  

  public void addRange(SinglyLinkedList < E >  list) {
	  Node< E > n = this.head;
	  this.tail.setNext(list.head);
	  this.tail = list.tail;
	  this.size = this.size + list.size;
  }
  
  
  public void print() {
	  Node< E > n = this.head;
	  
	  while(n != null) {
		   System.out.println(n.element);
		   
		   n = n.getNext();
	  }
  }
  
  public void swap(int a, int b) {
	  
	  Node< E > nodea = head;
	  Node< E > nodeb = head;
	  
	  
	  for(int i=1 ; i<a; i++) {
		nodea  = nodea.getNext();
	  }
	  
	  for(int i=1 ; i<b; i++) {
		nodeb  = nodeb.getNext();
	  }
	  
	  this.swap(nodea, nodeb);
  }
  
  public void swap(Node< E > a, Node< E > b) {
	  
	  Node< E > nodeAPrev = null;
	  Node< E > nodeBPrev = null;
	  
	  if(a.equals(b)) {
		  return;
	  }
	  
	  if(!a.equals( this.head) ) {
		  nodeAPrev = head;
		  while(!nodeAPrev.getNext().equals(a)) {
			  nodeAPrev = nodeAPrev.getNext();
		  }
	  }
	  
	  if(!b.equals(this.head) ) {
		  nodeBPrev = head;
		  while(!nodeBPrev.getNext().equals(b)) {
			  nodeBPrev = nodeBPrev.getNext();
		  }
	  }
	  
	  if(nodeAPrev!=null) {
		  nodeAPrev.setNext(b);
	  } else {
		  this.head = b;
	  }
	  
	  if(nodeBPrev!=null) {
		  nodeBPrev.setNext(a);
	  } else {
		  this.head = a;
	  }
	  
	  Node<E> nextA = a.getNext();
	  a.setNext(b.getNext());
	  b.setNext(nextA);

  }
  
  public void revert() {
	  for(int i = 1 ; i<=(this.size/2); i++) {
		  this.swap(i, this.size+1-i);
		  this.print();
		  System.out.println("_");
	  }
  }
}