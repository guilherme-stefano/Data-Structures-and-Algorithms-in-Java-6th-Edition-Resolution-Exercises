import java.util.ArrayList;

public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    private MapEntry<K, V>[] table; // tabela hash
    private MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null); // marca de slot excluído

    // Construtores
    public ProbeHashMap() {
        super();
    }

    public ProbeHashMap(int capacity) {
        super(capacity);
    }

    public ProbeHashMap(int capacity, int prime) {
        super(capacity, prime);
    }

    // Cria a tabela com capacidade especificada
    @SuppressWarnings("unchecked")
    protected void createTable() {
        table = (MapEntry<K, V>[]) new MapEntry[capacity];
    }

    // Retorna o valor associado a uma chave, ou null se não encontrado
    public V get(K key) {
        int j = findSlot(hashValue(key), key);
        if (j < 0) return null;
        return table[j].getValue();
    }

    // Insere uma nova chave-valor ou atualiza uma existente
    public V put(K key, V value) {
        int j = findSlot(hashValue(key), key);
        if (j >= 0) { // chave encontrada, atualizar valor
            V oldValue = table[j].getValue();
            table[j].setValue(value);
            return oldValue;
        } else { // chave não encontrada, inserir novo par
            int availableSlot = -j - 1;
            table[availableSlot] = new MapEntry<>(key, value);
            n++;
            return null;
        }
    }

    // Remove a chave-valor associado a uma chave e retorna o valor
    public V remove(K key) {
        int j = findSlot(hashValue(key), key);
        if (j < 0) return null; // chave não encontrada
        V oldValue = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return oldValue;
    }

    // Encontra o slot para uma chave usando sondagem linear
    private int findSlot(int h, K key) {
        int j = h;
        int step = 1;
        while (table[j] != null) {
            if (table[j] != DEFUNCT && table[j].getKey().equals(key))
                return j; // posição da chave encontrada
            j = (j + step) % capacity;
        }
        return -j - 1; // posição livre ou para inserir nova chave
    }

    // Itera pela tabela de hash e coleta todas as entradas válidas
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int i = 0; i < capacity; i++)
            if (table[i] != null && table[i] != DEFUNCT)
                buffer.add(table[i]);
        return buffer;
    }
}
