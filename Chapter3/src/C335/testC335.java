package C335;


public class testC335 {
	public static void main(String args[]) {
		DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
		
		test.addFirst(1);
		test.addFirst(2);
		test.addLast(5);
		test.addLast(6);
		
		DoublyLinkedList<Integer> test2 = test.clone();
	}
}
