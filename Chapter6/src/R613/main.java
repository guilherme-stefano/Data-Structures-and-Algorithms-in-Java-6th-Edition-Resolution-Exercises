package R613;

public class main {
	public static DequeLinkedList< Integer > deque = new DequeLinkedList< Integer > ();
	public static QueueDeque< Integer > queue = new QueueDeque< Integer >();
	
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
			queue.enqueue(deque.removeLast());
		}
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
		
	}

}
