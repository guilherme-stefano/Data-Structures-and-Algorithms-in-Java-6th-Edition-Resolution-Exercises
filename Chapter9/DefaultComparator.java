public class DefaultComparator<E> implements Comparator<E> {
    public int compare(E a, E b) throws ClassCastException{
        return((comparable<E>) a).comparetTo(b);
    }
}