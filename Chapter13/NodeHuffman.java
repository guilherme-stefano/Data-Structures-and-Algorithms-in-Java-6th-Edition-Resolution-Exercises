// Classe do nó da árvore binária
class NodeHuffman implements Comparable<NodeHuffman> {
    char character;
    int frequency;
    NodeHuffman left, right;

    // Construtor para folha
    public NodeHuffman(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    // Construtor para nós internos
    public NodeHuffman(NodeHuffman left, NodeHuffman right) {
        this.character = '\0';  // nó interno não armazena caracteres
        this.frequency = left.frequency + right.frequency;
        this.left = left;
        this.right = right;
    }

    // Implementação da interface Comparable para ordenar pela frequência
    @Override
    public int compareTo(NodeHuffman other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}