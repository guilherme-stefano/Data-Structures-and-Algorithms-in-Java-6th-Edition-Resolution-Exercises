public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    // Construtor para inicializar chave e valor
    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Retorna a chave
    @Override
    public K getKey() {
        return key;
    }

    // Retorna o valor
    @Override
    public V getValue() {
        return value;
    }

    // Define um novo valor e retorna o valor antigo
    @Override
    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    // Método para comparar se dois MapEntry são iguais
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapEntry<?, ?> other = (MapEntry<?, ?>) o;
        return (key == null ? other.key == null : key.equals(other.key)) &&
               (value == null ? other.value == null : value.equals(other.value));
    }

    // Método para gerar um código hash com base na chave e no valor
    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^
               (value == null ? 0 : value.hashCode());
    }

    // Retorna uma representação de string da entrada de mapa
    @Override
    public String toString() {
        return key + "=" + value;
    }
}
