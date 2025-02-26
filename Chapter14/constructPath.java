/** Returns an ordered list of edges comprising the directed path from u to v. */
public static <V, E> PositionalList<Edge<E>> constructPath(Graph<V, E> g, Vertex<V> u, Vertex<V> v,
                                                           Map<Vertex<V>, Edge<E>> forest) {
    PositionalList<Edge<E>> path = new LinkedPositionalList<>();
    if (forest.get(v) != null) { // v was discovered during the search
        Vertex<V> walk = v; // we construct the path from back to front
        while (walk != u) {
            Edge<E> edge = forest.get(walk);
            path.addFirst(edge); // add edge to *front* of path
            walk = g.opposite(walk, edge); // repeat with opposite endpoint
        }
    }
    return path;
}
