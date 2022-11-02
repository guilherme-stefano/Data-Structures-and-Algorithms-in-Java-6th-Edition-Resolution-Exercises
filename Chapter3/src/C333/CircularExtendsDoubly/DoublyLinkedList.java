package C333.CircularExtendsDoubly;


class DoublyNode < E > {
    private E element; // reference to the element stored at this node
    private DoublyNode < E > prev; // reference to the previous node in the list
    private DoublyNode < E > next; // reference to the subsequent node in the list
    public DoublyNode(E e, DoublyNode < E > p, DoublyNode < E > n) {
      element = e;
      prev = p;
      next = n;
    }
    public E getElement() {
      return element;
    }
    public DoublyNode < E > getPrev() {
      return prev;
    }
    public DoublyNode < E > getNext() {
      return next;
    }
    public void setPrev(DoublyNode < E > p) {
      prev = p;
    }
    public void setNext(DoublyNode < E > n) {
      next = n;
    }
  } //----------- end of nested Node class -----------

/** A basic doubly linked list implementation. */
public class DoublyLinkedList < E > {
   //---------------- nested Node class ----------------
  

   // instance variables of the DoublyLinkedList
   protected DoublyNode < E > header; // header sentinel
   protected DoublyNode < E > trailer; // trailer sentinel
   protected int size = 0; // number of elements in the list
   /** Constructs a new empty list. */
   public DoublyLinkedList() {
     header = new DoublyNode < > (null, null, null); // create header
     trailer = new DoublyNode < > (null, header, null); // trailer is preceded by header
     header.setNext(trailer); // header is followed by trailer
   }
   /** Returns the number of elements in the linked list. */
   public int size() {
     return size;
   }
   /** Tests whether the linked list is empty. */
   public boolean isEmpty() {
     return size == 0;
   }
   /** Returns (but does not remove) the first element of the list. */
   public E first() {
     if (isEmpty()) return null;
     return header.getNext().getElement(); // first element is beyond header
   }
   /** Returns (but does not remove) the last element of the list. */
   public E last() {
     if (isEmpty()) return null;
     return trailer.getPrev().getElement(); // last element is before trailer
   }
   // public update methods
   /** Adds element e to the front of the list. */
   public void addFirst(E e) {
     addBetween(e, header, header.getNext()); // place just after the header
   }
   /** Adds element e to the end of the list. */
   public void addLast(E e) {
     addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
   }
   /** Removes and returns the first element of the list. */
   public E removeFirst() {
     if (isEmpty()) return null; // nothing to remove
     return remove(header.getNext()); // first element is beyond header
   }
   /** Removes and returns the last element of the list. */
   public E removeLast() {
     if (isEmpty()) return null; // nothing to remove
     return remove(trailer.getPrev()); // last element is before trailer
   }

   // private update methods
   /** Adds element e to the linked list in between the given nodes. */
   protected void addBetween(E e, DoublyNode < E > predecessor, DoublyNode < E > successor) {
     // create and link a new node
     DoublyNode < E > newest = new DoublyNode < > (e, predecessor, successor);
     predecessor.setNext(newest);
     successor.setPrev(newest);
     size++;
   }
   /** Removes the given node from the list and returns its element. */
   protected E remove(DoublyNode < E > node) {
     DoublyNode < E > predecessor = node.getPrev();
     DoublyNode < E > successor = node.getNext();
     predecessor.setNext(successor);
     successor.setPrev(predecessor);
     size--;
     return node.getElement();
   }
 } //----------- end of DoublyLinkedList class -----------