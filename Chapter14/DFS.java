import java.util.Map;
import java.util.Set;

public class DFS {
/** Performs depth-first search of Graph g starting at Vertex u. */
public static <V, E> void DFS(Graph<V, E> g, Vertex<V> u,
                               Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
    known.add(u); // u has been discovered
    for (Edge<E> e : g.outgoingEdges(u)) { // for every outgoing edge from u
        Vertex<V> v = g.opposite(u, e);
        if (!known.contains(v)) {
            forest.put(v, e); // e is the tree edge that discovered v
            DFS(g, v, known, forest); // recursively explore from v
        }
    }
}

}
