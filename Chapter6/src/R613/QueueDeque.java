package R613;


public class QueueDeque<E> implements Queue<E>{
	public DequeLinkedList< E > deque = new DequeLinkedList< E > ();

	@Override
	public int size() {
		return deque.size();
	}

	@Override
	public boolean isEmpty() {
		return  deque.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		deque.addFirst(e);
	}

	@Override
	public E first() {
		return deque.first();
	}

	@Override
	public E dequeue() {
		return deque.removeLast();
	}
	
	
}
