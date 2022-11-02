package C334;

public class testC334 {
	public static void main(String args[]) {
		CircularlyLinkedList<Integer> test = new CircularlyLinkedList<Integer>();
		
		test.addFirst(1);
		test.addFirst(2);
		test.addLast(5);
		test.addLast(6);
		
		CircularlyLinkedList<Integer> test2 = test.clone();
		
	}
}
