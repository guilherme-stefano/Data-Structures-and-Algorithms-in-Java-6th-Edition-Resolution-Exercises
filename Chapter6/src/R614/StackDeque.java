package R614;

public class StackDeque<E> implements Stack<E> {
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
	public void push(E e) {
		deque.addFirst(e);
	}

	@Override
	public E top() {
		return deque.first();
	}

	@Override
	public E pop() {
		return deque.removeFirst();
	}
	
	
}
