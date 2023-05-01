package R613;

import java.util.ArrayDeque;

public class DequeLinkedList< E > implements IDeque < E > {

	private ArrayDeque<E> deque = new ArrayDeque<E>();

	@Override
	public int size() {	
		return deque.size();
	}

	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	@Override
	public E first() {	
		return deque.getFirst();
	}

	@Override
	public E last() {
		return deque.getLast();
	}

	@Override
	public void addFirst(E e) {
		 deque.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		 deque.addLast(e);
	}

	@Override
	public E removeFirst() {
		return deque.removeFirst();
	}

	@Override
	public E removeLast() {
		return deque.removeLast();
	}
	
	
}
