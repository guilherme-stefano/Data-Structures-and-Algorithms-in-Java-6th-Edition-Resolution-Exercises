package C328;

public class Program {
	
	public static void main(String[] args) {
		TestRevert() ;
		//TestDoubleListSwap() ;


	}
	
	public static void TestRevert() {

		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		
		list1.addLast(1);
		list1.addLast(2);
		list1.addLast(3);
		list1.addLast(4);
		list1.addLast(5);
		
		list1.print();
		System.out.println("_");
		list1.revert();
		list1.print();
		

		
	}
	

	
}
