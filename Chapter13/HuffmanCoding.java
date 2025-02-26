import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    // Método principal para construir a árvore de Huffman
    public static NodeHuffman buildHuffmanTree(String X) {
        // Contar a frequência de cada caractere
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : X.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Inicializar uma fila de prioridade (PriorityQueue)
        PriorityQueue<NodeHuffman> Q = new PriorityQueue<>();

        // Para cada caractere, criar um nó e inserir na fila
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            Q.offer(new NodeHuffman(entry.getKey(), entry.getValue()));
        }

        // Construir a árvore de Huffman
        while (Q.size() > 1) {
            NodeHuffman T1 = Q.poll();  // Nó com menor frequência
            NodeHuffman T2 = Q.poll();  // Segundo nó com menor frequência

            // Criar novo nó com T1 e T2 como subárvores
            NodeHuffman T = new NodeHuffman(T1, T2);

            // Inserir o novo nó na fila
            Q.offer(T);
        }

        // O último nó restante na fila é a raiz da árvore de Huffman
        return Q.poll();
    }

    // Função para imprimir a árvore (recursivamente)
    public static void printTree(NodeHuffman root, String prefix) {
        if (root != null) {
            // Nó folha (contém caractere)
            if (root.character != '\0') {
                System.out.println(root.character + ": " + prefix);
            } else {
                // Nó interno
                printTree(root.left, prefix + "0");
                printTree(root.right, prefix + "1");
            }
        }
    }

    public static void main(String[] args) {
        String X = "exemplo de string para codificacao huffman";
        NodeHuffman huffmanTree = buildHuffmanTree(X);

        // Imprime o código de Huffman de cada caractere
        printTree(huffmanTree, "");
    }
}
