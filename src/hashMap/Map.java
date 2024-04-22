package hashMap;

import java.util.Set;

public interface Map <K extends Comparable<K>, V extends Comparable<V>>{

    boolean isEmpty();
    void put(K k, V v); //Вставляет запись в вызываемую карту, перезаписывая любое предыдущее значение, связанное с ключом.
                        // Ключ и значения соответствуют k и v. Возвращает ноль, если ключ ещё не существует.
                        // В противном случае возвращается предыдущее значение, связанное с ключом.
    void remove(K value); // удаляет запись с ключом k
    void clear();
    int size(); // возвращает количество пар ключей/значений в карте

    int hashCode();
    boolean equals(Object kv);

    boolean containsKey(K k); // Возвращает true, если вызываемая карта содержит k как ключ. В противном случае, возвращает false.
    boolean containsValue(V v);
    Set<K> keySet();
    Set<V> values();
    V get(K k); // Возвращает значение, связанное с ключом k.

}
