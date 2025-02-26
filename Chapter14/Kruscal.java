import java.util.Map;
import java.util.PriorityQueue;

public class Kruscal {
    /**
 * Computes a minimum spanning tree of graph g using Kruskal's algorithm.
 */
public static <V> PositionalList<Edge<Integer>> MST(Graph<V, Integer> g) {
    // tree is where we will store result as it is computed
    PositionalList<Edge<Integer>> tree = new LinkedPositionalList<>();

    // pq entries are edges of graph, with weights as keys
    PriorityQueue<Integer, Edge<Integer>> pq = new HeapPriorityQueue<>();

    // union-find forest of components of the graph
    Partition<Vertex<V>> forest = new Partition<>();

    // map each vertex to the forest position
    Map<Vertex<V>, Position<Vertex<V>>> positions = new ProbeHashMap<>();

    // Initialize the union-find structure with vertices
    for (Vertex<V> v : g.vertices())
        positions.put(v, forest.makeGroup(v));

    // Insert all edges into the priority queue with their weights as keys
    for (Edge<Integer> e : g.edges())
        pq.insert(e.getElement(), e);

    int size = g.numVertices();

    // While the tree is not spanning and there are edges to process
    while (tree.size() != size - 1 && !pq.isEmpty()) {
        Entry<Integer, Edge<Integer>> entry = pq.removeMin();
        Edge<Integer> edge = entry.getValue();
        Vertex<V>[] endpoints = g.endVertices(edge);

        // Find the sets of the edge's endpoints
        Position<Vertex<V>> a = forest.find(positions.get(endpoints[0]));
        Position<Vertex<V>> b = forest.find(positions.get(endpoints[1]));

        // If endpoints are in different sets, add the edge to the tree
        if (a != b) {
            tree.addLast(edge);
            forest.union(a, b);
        }
    }

    return tree;
}

}
