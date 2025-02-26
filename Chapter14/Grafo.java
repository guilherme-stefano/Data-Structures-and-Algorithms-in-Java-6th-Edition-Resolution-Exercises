import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.text.Position;

public class Grafo {
/**
 * A vertex of an adjacency map graph representation.
 */

 /**
 * Interface Vertex representa um vértice em uma estrutura de grafo.
 *
 * @param <V> o tipo do elemento armazenado neste vértice
 */
interface Vertex<V> {
    
    /**
     * Retorna o elemento armazenado neste vértice.
     *
     * @return o elemento armazenado no vértice
     */
    V getElement();
}

interface Position<E> {
    E getElement() throws IllegalStateException;
}

/**
 * Interface Edge representa uma aresta em uma estrutura de grafo.
 *
 * @param <E> o tipo do elemento armazenado nesta aresta
 */
 interface Edge<E> {
    
    /**
     * Retorna o elemento armazenado nesta aresta.
     *
     * @return o elemento armazenado na aresta
     */
    E getElement();
}

 class InnerVertex<V,E> implements Vertex<V> {
    private V element;   // elemento armazenado no vértice
    private Position<Vertex<V>> pos;  // posição do vértice na lista de vértices do grafo
    private Map<Vertex<V>, Edge<E>> outgoing, incoming; // mapas de arestas de saída e entrada

    /**
     * Construtor para criar uma nova instância de InnerVertex armazenando o elemento fornecido.
     * @param elem elemento associado ao vértice
     * @param graphIsDirected true se o grafo for direcionado
     */
    public InnerVertex(V elem, boolean graphIsDirected) {
        element = elem;
        outgoing = (Map<Vertex<V>, Edge<E>>) new ProbeHashMap<Vertex<V>, Edge<E>>(); // inicializa o mapa de arestas de saída
        if (graphIsDirected)
            incoming = (Map<Vertex<V>, Edge<E>>) new ProbeHashMap<Vertex<V>, Edge<E>>(); // inicializa o mapa de arestas de entrada se for direcionado
        else
            incoming = outgoing; // se for não direcionado, incoming aponta para outgoing
    }

    /** Retorna o elemento associado ao vértice. */
    public V getElement() { return element; }

    /** Armazena a posição deste vértice na lista de vértices do grafo. */
    public void setPosition(Position<Vertex<V>> p) { pos = p; }

    /** Retorna a posição deste vértice na lista de vértices do grafo. */
    public Position<Vertex<V>> getPosition() { return pos; }

    /** Retorna referência ao mapa subjacente de arestas de saída. */
    public Map<Vertex<V>, Edge<E>> getOutgoing() { return outgoing; }

    /** Retorna referência ao mapa subjacente de arestas de entrada. */
    public Map<Vertex<V>, Edge<E>> getIncoming() { return incoming; }
}
//------------ fim da classe InnerVertex ------------

/**
 * An edge between two vertices.
 */
 class InnerEdge<V, E> implements Edge<E> {
    private E element; // elemento armazenado na aresta
    private Position<Edge<E>> pos; // posição da aresta na lista de arestas do grafo
    private Vertex<V>[] endpoints; // array de comprimento 2 contendo os vértices de extremidade

    /**
     * Constrói uma instância de InnerEdge de u para v, armazenando o elemento fornecido.
     * @param u vértice de origem
     * @param v vértice de destino
     * @param elem elemento associado à aresta
     */
    public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
        element = elem;
        endpoints = (Vertex<V>[]) new Vertex[]{u, v}; // inicializa o array com os vértices de extremidade
    }

    /** Retorna o elemento associado à aresta. */
    public E getElement() { return element; }

    /** Retorna referência ao array de vértices de extremidade. */
    public Vertex<V>[] getEndpoints() { return endpoints; }

    /** Armazena a posição desta aresta na lista de arestas do grafo. */
    public void setPosition(Position<Edge<E>> p) { pos = p; }

    /** Retorna a posição desta aresta na lista de arestas do grafo. */
    public Position<Edge<E>> getPosition() { return pos; }
}
//------------ fim da classe InnerEdge ------------

interface Graph<V, E> {
    // Retorna a coleção de todos os vértices no grafo
    Iterable<Vertex<V>> vertices();

    // Retorna a coleção de todas as arestas no grafo
    Iterable<Edge<E>> edges();

    // Retorna a coleção de arestas que estão conectadas a um vértice dado
    Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws IllegalArgumentException;

    // Retorna o vértice oposto ao vértice dado em uma aresta especificada
    Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException;

    // Retorna o número de vértices no grafo
    int numVertices();

    // Retorna o número de arestas no grafo
    int numEdges();

    // Verifica se dois vértices são adjacentes (conectados por uma aresta)
    boolean areAdjacent(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException;

    // Insere um novo vértice com o valor especificado
    Vertex<V> insertVertex(V value);

    // Insere uma nova aresta entre dois vértices com o valor especificado
    Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E value) throws IllegalArgumentException;

    // Remove um vértice e todas as suas arestas incidentes
    void removeVertex(Vertex<V> v) throws IllegalArgumentException;

    // Remove uma aresta do grafo
    void removeEdge(Edge<E> e) throws IllegalArgumentException;
}

class AdjacencyMapGraph<V, E> implements Graph<V, E> {
    // Classes aninhadas InnerVertex e InnerEdge são definidas aqui...
    private boolean isDirected;  // indica se o grafo é direcionado
    private PositionalList<Vertex<V>> vertices = new LinkedPositionalList<>();  // lista de vértices
    private PositionalList<Edge<E>> edges = new LinkedPositionalList<>();  // lista de arestas

    /** Constructs an empty graph (either undirected or directed). */
    public AdjacencyMapGraph(boolean directed) { isDirected = directed; }

    /** Returns the number of vertices of the graph */
    public int numVertices() { return vertices.size(); }

    /** Returns the vertices of the graph as an iterable collection */
    public Iterable<Vertex<V>> vertices() { return vertices; }

    /** Returns the number of edges of the graph */
    public int numEdges() { return edges.size(); }

    /** Returns the edges of the graph as an iterable collection */
    public Iterable<Edge<E>> edges() { return edges; }

    /** Returns the number of edges for which vertex v is the origin. */
    public int outDegree(Vertex<V> v) {
        InnerVertex<V> vert = validate(v);  // valida o vértice
        return vert.getOutgoing().size();  // retorna o número de arestas de saída
    }

    /** Returns an iterable collection of edges for which vertex v is the origin. */
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        InnerVertex<V> vert = validate(v);  // valida o vértice
        return vert.getOutgoing().values();  // retorna as arestas de saída
    }

    /** Returns the number of edges for which vertex v is the destination. */
    public int inDegree(Vertex<V> v) {
        InnerVertex<V> vert = validate(v);  // valida o vértice
        return vert.getIncoming().size();  // retorna o número de arestas de entrada
    }

    /** Returns an iterable collection of edges for which vertex v is the destination. */
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        InnerVertex<V> vert = validate(v);  // valida o vértice
        return vert.getIncoming().values();  // retorna as arestas de entrada
    }

    /** Returns the edge from u to v, or null if they are not adjacent. */
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        InnerVertex<V> origin = validate(u);  // valida o vértice de origem
        return origin.getOutgoing().get(v);  // retorna a aresta de u para v, se existir
    }

    /** Returns the vertices of edge e as an array of length two. */
    public Vertex<V>[] endVertices(Edge<E> e) {
        InnerEdge<E> edge = validate(e);  // valida a aresta
        return edge.getEndpoints();  // retorna os vértices extremos da aresta
    }


    /**
     * Retorna o vértice oposto ao vértice v na aresta e.
     * @param v vértice inicial
     * @param e aresta para encontrar o vértice oposto
     * @return vértice oposto ao vértice v na aresta e
     * @throws IllegalArgumentException se v não está conectado a e
     */
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException {
        InnerEdge<E> edge = validate(e);  // valida e retorna a aresta
        Vertex<V>[] endpoints = edge.getEndpoints();  // obtém os vértices de extremidade
        if (endpoints[0] == v)
            return endpoints[1];  // retorna o vértice oposto
        else if (endpoints[1] == v)
            return endpoints[0];  // retorna o vértice oposto
        else
            throw new IllegalArgumentException("v não está conectado a esta aresta");  // lança exceção se v não for incidente a e
    }

    /**
     * Insere e retorna um novo vértice com o elemento fornecido.
     * @param element elemento a ser armazenado no novo vértice
     * @return o novo vértice inserido
     */
    public Vertex<V> insertVertex(V element) {
        InnerVertex<V> v = new InnerVertex<>(element, isDirected);  // cria um novo vértice
        v.setPosition(vertices.addLast(v));  // adiciona o vértice à lista de vértices e define sua posição
        return v;
    }

    /**
     * Insere e retorna uma nova aresta entre u e v, armazenando o elemento fornecido.
     * @param u vértice de origem
     * @param v vértice de destino
     * @param element elemento a ser armazenado na nova aresta
     * @return a nova aresta inserida
     * @throws IllegalArgumentException se já existir uma aresta entre u e v
     */
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException {
        if (getEdge(u, v) == null) {  // verifica se não existe uma aresta entre u e v
            InnerEdge<E> e = new InnerEdge<>(u, v, element);  // cria uma nova aresta
            e.setPosition(edges.addLast(e));  // adiciona a aresta à lista de arestas e define sua posição
            InnerVertex<V> origin = validate(u);  // valida e retorna o vértice de origem
            InnerVertex<V> dest = validate(v);  // valida e retorna o vértice de destino
            origin.getOutgoing().put(v, e);  // adiciona a aresta ao mapa de saída do vértice de origem
            dest.getIncoming().put(u, e);  // adiciona a aresta ao mapa de entrada do vértice de destino
            return e;
        } else
            throw new IllegalArgumentException("Aresta de u para v já existe");  // lança exceção se a aresta já existe
    }

    /**
     * Remove um vértice e todas as suas arestas incidentes do grafo.
     * @param v vértice a ser removido
     */
    public void removeVertex(Vertex<V> v) {
        InnerVertex<V> vert = validate(v);  // valida e retorna o vértice a ser removido
        // remove todas as arestas de saída
        for (Edge<E> e : vert.getOutgoing().values())
            removeEdge(e);
        // remove todas as arestas de entrada
        for (Edge<E> e : vert.getIncoming().values())
            removeEdge(e);
        // remove este vértice da lista de vértices
        vertices.remove(vert.getPosition());
    }

    public void removeEdge(Edge<E> e) throws IllegalArgumentException {
    InnerEdge<E> edge = validate(e); // Valida e faz o cast da aresta para tipo interno
    
    Vertex<V>[] endpoints = edge.getEndpoints(); // Obtém os vértices de origem e destino
    InnerVertex<V> u = validate(endpoints[0]);
    InnerVertex<V> v = validate(endpoints[1]);
    
    // Remove a aresta dos mapas de adjacências dos vértices de origem e destino
    u.getOutgoing().remove(v);
    v.getIncoming().remove(u);
    
    // Remove a aresta da lista de arestas
    edges.remove(edge.getPosition());
    }

    public boolean areAdjacent(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException {
        InnerVertex<V> origin = validate(u); // Valida e converte o vértice u
        InnerVertex<V> dest = validate(v); // Valida e converte o vértice v
        
        // Verifica se há uma aresta de u para v no mapa de saída de u
        return origin.getOutgoing().containsKey(v);
    }

    public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws IllegalArgumentException {
    InnerVertex<V> vert = validate(v); // Valida e converte o vértice v
    List<Edge<E>> edges = new ArrayList<>(); // Lista para armazenar as arestas incidentes

    // Adiciona todas as arestas de saída (outgoing edges)
    for (Edge<E> e : vert.getOutgoing().values()) {
        edges.add(e);
    }
    
    // Adiciona todas as arestas de entrada (incoming edges) se o grafo for direcionado
    if (isDirected) {
        for (Edge<E> e : vert.getIncoming().values()) {
            edges.add(e);
        }
    }

    return edges; // Retorna a lista de arestas incidentes
}




}
