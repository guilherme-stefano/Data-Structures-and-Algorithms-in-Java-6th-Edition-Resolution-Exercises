
private class ArrayIterator implements Iterator<E> {
    private int j = 0;

    private boolean removable = false;

    public boolean hasNext() { return j < size; } 

    public E next() throws NoSuchElementException {
        if (j == size) throw new NoSuchElementException("No next element");
        removable = true;
        return data[j++];
    }

    public void remove() throws IllegalStateException {
        if (!removable) throw new IllegalStateException("nothing to remove");
        ArrayList.this.remove(j-1);
        j--;
        removable = false;
    }
} 

public Iterator<E> iterator() {
    return new ArrayIterator();
}