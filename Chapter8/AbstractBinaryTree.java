/**
 * An abstract base class providing some functionality of the BinaryTree interface.
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     */
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);

        if (parent == null) {
            return null; // p must be the root
        }

        if (p == left(parent)) {
            return right(parent); // p is a left child (right child might be null)
        } else {
            return left(parent); // p is a right child (left child might be null)
        }
    }

    /**
     * Returns the number of children of Position p.
     */
    public int numChildren(Position<E> p) {
        int count = 0;

        if (left(p) != null) {
            count++;
        }

        if (right(p) != null) {
            count++;
        }

        return count;
    }

    /**
     * Returns an iterable collection of the Positions representing p's children.
     */
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2); // Max capacity of 2

        if (left(p) != null) {
            snapshot.add(left(p));
        }

        if (right(p) != null) {
            snapshot.add(right(p));
        }

        return snapshot;
    }
}
