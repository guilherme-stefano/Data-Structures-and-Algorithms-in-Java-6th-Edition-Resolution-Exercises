/**
 * Maintains a list of elements ordered according to access frequency.
 */
public class FavoritesList<E> {

    // Nested Item class
    protected static class Item<E> {
        private E value;
        private int count = 0;

        /**
         * Constructs a new item with an initial count of zero.
         */
        public Item(E val) {
            value = val;
        }

        public int getCount() {
            return count;
        }

        public E getValue() {
            return value;
        }

        public void increment() {
            count++;
        }
    } // End of nested Item class

    // List of Items
    PositionalList<Item<E>> list = new LinkedPositionalList<>();

    /**
     * Constructs an initially empty favorites list.
     */
    public FavoritesList() {
    }

    // Non-public utilities

    /**
     * Provides shorthand notation to retrieve the user's element stored at Position p.
     */
    protected E value(Position<Item<E>> p) {
        return p.getElement().getValue();
    }

    /**
     * Provides shorthand notation to retrieve the count of the item stored at Position p.
     */
    protected int count(Position<Item<E>> p) {
        return p.getElement().getCount();
    }

    /**
     * Returns the Position having an element equal to e (or null if not found).
     */
    protected Position<Item<E>> findPosition(E e) {
        Position<Item<E>> walk = list.first();

        while (walk != null && !e.equals(value(walk))) {
            walk = list.after(walk);
        }

        return walk;
    }

        /**
     * Moves the item at Position p earlier in the list based on access count.
     */
    protected void moveUp(Position<Item<E>> p) {
        int cnt = count(p); // Revised count of accessed item
        Position<Item<E>> walk = p;

        while (walk != list.first() && count(list.before(walk)) < cnt) {
            walk = list.before(walk);
        }

        // Found smaller count ahead of the item
        if (walk != p) {
            list.addBefore(walk, list.remove(p)); // Remove/reinsert item
        }
    }

    // Public methods

    /**
     * Returns the number of items in the favorites list.
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns true if the favorites list is empty.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Accesses element e (possibly new), increasing its access count.
     */
    public void access(E e) {
        Position<Item<E>> p = findPosition(e); // Try to locate existing element

        if (p == null) {
            p = list.addLast(new Item<E>(e)); // If new, place at the end
        }

        p.getElement().increment(); // Always increment count
        moveUp(p); // Consider moving forward
    }

    /**
     * Removes the element equal to e from the list of favorites (if found).
     */
    public void remove(E e) {
        Position<Item<E>> p = findPosition(e); // Try to locate existing element

        if (p != null) {
            list.remove(p);
        }
    }

    /**
     * Returns an iterable collection of the k most frequently accessed elements.
     */
    public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
        if (k < 0 || k > size()) {
            throw new IllegalArgumentException("Invalid k");
        }

        PositionalList<E> result = new LinkedPositionalList<>();
        Iterator<Item<E>> iter = list.iterator();

        for (int j = 0; j < k; j++) {
            result.addLast(iter.next().getValue());
        }

        return result;
    }
}