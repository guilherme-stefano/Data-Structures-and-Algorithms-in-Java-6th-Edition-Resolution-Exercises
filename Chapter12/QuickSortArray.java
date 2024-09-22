/** Quick-sort contents of a queue. */
public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
    int n = S.size();
    if (n < 2) return; // queue is trivially sorted

    // divide
    K pivot = S.first(); // using first as arbitrary pivot
    Queue<K> L = new LinkedQueue<>(); // queue for elements less than pivot
    Queue<K> E = new LinkedQueue<>(); // queue for elements equal to pivot
    Queue<K> G = new LinkedQueue<>(); // queue for elements greater than pivot

    while (!S.isEmpty()) { // divide original into L, E, and G
        K element = S.dequeue();
        int c = comp.compare(element, pivot);
        if (c < 0)
            L.enqueue(element); // element is less than pivot
        else if (c == 0)
            E.enqueue(element); // element is equal to pivot
        else
            G.enqueue(element); // element is greater than pivot
    }

    // conquer
    quickSort(L, comp); // sort elements less than pivot
    quickSort(G, comp); // sort elements greater than pivot

    // concatenate results
    while (!L.isEmpty())
        S.enqueue(L.dequeue());
    while (!E.isEmpty())
        S.enqueue(E.dequeue());
    while (!G.isEmpty())
        S.enqueue(G.dequeue());
}
