package C326;

public class Program {
	
	public static void main(String[] args) {

		DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
		DoublyLinkedList<Integer> list2 = new DoublyLinkedList<Integer>();
		
		list1.addLast(1);
		list1.addLast(2);
		list1.addLast(3);
		
		list2.addLast(4);
		list2.addLast(5);
		list2.addLast(6);
		
		list1.addRange(list2);
		list2 = null;
		list1.print();
		
		
		
		
	}
	
}
