package C327;

public class Program {
	
	public static void main(String[] args) {
		TestSingleListSwap() ;
		//TestDoubleListSwap() ;


	}
	
	public static void TestSingleListSwap() {

		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		
		list1.addLast(1);
		list1.addLast(2);
		list1.addLast(3);
		list1.addLast(4);
		list1.addLast(5);
		
		list1.print();
		
		list1.swap(2,4);
		
		list1.print();
		
		list1.swap(1,2);
		
	}
	
	public static void TestDoubleListSwap() {
		DoublyLinkedList<Integer> list2 = new DoublyLinkedList<Integer>();
		list2.addLast(1);
		list2.addLast(2);
		list2.addLast(3);
		list2.addLast(4);
		list2.addLast(5);
		
		list2.print();
		
		list2.swap(2,4);
		
		list2.print();
	}
	
}
