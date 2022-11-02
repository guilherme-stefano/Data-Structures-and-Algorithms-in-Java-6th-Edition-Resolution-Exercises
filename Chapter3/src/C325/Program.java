package C325;

public class Program {
	
	public static void main(String[] args) {

		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
		
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
