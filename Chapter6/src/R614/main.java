package R614;

public class main {
	public static DequeLinkedList< Integer > deque = new DequeLinkedList< Integer > ();
	public static StackDeque< Integer > stack = new StackDeque< Integer >();
	
	public static void main(String[] args) {
		
		deque.addLast(1);
		deque.addLast(2);
		deque.addLast(3);
		deque.addLast(4);
		deque.addLast(5);
		deque.addLast(6);
		deque.addLast(7);
		deque.addLast(8);
		
		while(!deque.isEmpty()){
			stack.push(deque.removeLast());
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
	}

}
