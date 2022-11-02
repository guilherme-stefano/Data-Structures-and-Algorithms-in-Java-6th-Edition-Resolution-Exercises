package C332;

public class test {
	public static void main(String args[]) {
		CircularDoublyLinkedList<Integer> test = new CircularDoublyLinkedList<Integer>();
		
		test.addFirst(1);
		test.addFirst(2);
		test.addLast(5);
		test.addLast(6);
		test.Rotate();
		test.RotateBack();
	}
}
