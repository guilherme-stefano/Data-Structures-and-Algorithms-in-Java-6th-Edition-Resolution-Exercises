import java.util.Random;

public abstract class AbstractHashMap<K, V> {
    protected int n = 0; // número de pares chave-valor no mapa
    protected int capacity; // capacidade atual do mapa
    private int prime; // número primo para uso no cálculo do hash
    private long scale, shift; // fatores de escala e deslocamento para hash

    // Construtores
    public AbstractHashMap(int capacity, int prime) {
        this.capacity = capacity;
        this.prime = prime;
        Random rand = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int capacity) {
        this(capacity, 109345121); // número primo padrão
    }

    public AbstractHashMap() {
        this(17); // capacidade padrão
    }

    // Métodos de suporte
    protected int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    protected void resize(int newCap) {
        Iterable<Entry<K, V>> buffer = entrySet();
        capacity = newCap;
        createTable();
        n = 0; // redefinir tamanho para 0 antes de reinserir as entradas
        for (Entry<K, V> e : buffer)
            put(e.getKey(), e.getValue());
    }

    // Métodos abstratos que devem ser implementados pelas subclasses
    protected abstract void createTable();
    public abstract V get(K key);
    public abstract V put(K key, V value);
    public abstract V remove(K key);
    public abstract Iterable<Entry<K, V>> entrySet();

    // Classe interna para representar pares chave-valor
    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }
}
