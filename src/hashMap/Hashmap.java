package hashMap;

import java.util.*;

public class Hashmap<K extends Comparable<K>, V extends Comparable<V>> implements Map<K, V> {

    /*
    - в пустой мапе размер равен 16
    -
     */

    int size;

    Node<K, V>[] table;
    Set<K> keys;
    Set<V> values;
    int capacity = 16;
    int capacityForVK = 2;

    public Hashmap() {
        this.size = 0;
        this.table = new Node[capacity];
        this.keys = new HashSet<>(capacityForVK);
        this.values = new HashSet<>(capacityForVK);
    }

    private static class Node<K, V> {
        int hash;
        V value;
        K key;
        Node<K, V> next;

        public Node(K key, V value) {
            this.value = value;
            this.key = key;
            this.next = null;

        }

        public int getHash() {
            return hash;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }

    @Override
    public boolean isEmpty() {  // работает правильно
        return size == 0;
    }

    @Override
    public void put(K k, V v) {
        size++; // не всегда
        keys.add(k);
        values.add(v);
        if (k == null) { // если ключ равен null, то элемент помещается на 0 индекс массива
            if (table[0] == null) {
                table[0] = new Node<K, V>(k, v);
            } else
                table[0].value = v; // у него могут быть ссылки на след ноды в цепочке, поэтому только перезапишем значение, если перезаписать на новый нод, то
            return; // пропадет ссылка на следующие ноды в цепочке
        }
        int index = (table.length - 1) & hash(k); // определение индекса в массиве, находится hashcode ключа(так надо), через hash, но она сложная, я ее ворую
        Node<K, V> newNode = new Node<>(k, v);
        newNode.hash = newNode.key.hashCode();                       // в hash хранится хэш ключа (оказывается)
        if (table[index] == null) {                     // проверяем пусто ли там
            table[index] = newNode;        // если пусто то записываем
        } else  // если есть
            isIdentical(table[index], newNode);
        if(size == capacity) capacity *= 2;
        if(keys.size() == capacityForVK) capacityForVK *= 2;
    }

    private void isIdentical(Node<K, V> curNode, Node<K, V> newNode) { // плохое название
        if (curNode.hash == newNode.hash) {  // проверяем node hashcode на совпадение, если совпали, то проверяем их ключи
            if (Objects.equals(curNode.key,newNode.key)) { // если все совпало, то перезаписываем
                curNode.value = newNode.value; // меняю только значение, а то слетят ссылки на след. элемент
                return;
            }
        }
        if (curNode.next == null) {
            curNode.next = newNode;
        } else {
            isIdentical(curNode.next, newNode);
        }
    }

    static int hash(Object key) { // не мое, но логику поняла, или почти поняла
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); // зачем так делают, почему так работает хэш
    }

    @SuppressWarnings("unchecked")
    @Override
    public void remove(K value) throws NoSuchElementException { // работает с коллизией, проверила
        keys.remove(value);
        int index = (table.length - 1) & hash(value);
        if (table[index] == null) { // если в таком индексе пусто, то не существует нода с таким ключом
            throw new NoSuchElementException("такого ключа не существует");
        } else if (Objects.equals(table[index].key,value)) { // если нужный нод первый из списка, лежит прям в массиве, то перезаписываем его на след. нод
            values.remove(table[index].value);
            table[index] = table[index].next;
        } else {
            Node<K, V>[] nextContainingNode = new Node[]{null};
            passList(table[index], value, nextContainingNode);
            values.remove(nextContainingNode[0].next.value);
            nextContainingNode[0].next = nextContainingNode[0].next.next;
        }
    }

    private void passList(Node<K, V> curNode, K key, Node<K, V>[] nextContainingNode) {
        if (curNode.next == null) {
            throw new NullPointerException("такого ключа не существует");
        } else if (Objects.equals(curNode.next.key,key)) { // если нашли
            nextContainingNode[0] = curNode;
        } else {
            passList(curNode.next, key, nextContainingNode);
        }
    }

    @Override
    public void clear() { // работает правильно
        if (table != null) {
            size = 0;
            Arrays.fill(table, null);
            keys.clear();
            values.clear();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K k) {
        int index = (table.length - 1) & hash(k);
        if (table[index] == null) { // если в таком индексе пусто, то не существует нода с таким ключом
            throw new NullPointerException("такого ключа не существует");
        } else if (Objects.equals(table[index].key,k)) { // если нужный нод первый из списка, лежит прям в массиве, то перезаписываем его на след. нод
            return table[index].value;
        } else {
            Node<K, V>[] nextContainingNode = new Node[]{null};
            passList(table[index], k, nextContainingNode);
            return nextContainingNode[0].next.value;
        }
    }


    @Override
    public boolean containsKey(K k) {
        return keys.contains(k);
    }

    @Override
    public boolean containsValue(V v) {
        return values.contains(v);
    }

    @Override
    public Set<K> keySet() {
        return keys;
    }


    @Override
    public Set<V> values() {
        return values;
    }

    public void print() {
        for (Node<K, V> node : table) {
            if (node != null) {
                System.out.print(node.key + " - " + node.value + "    ");
                while (node.next != null) {
                    node = node.next;
                    System.out.println(node.key + " - " + node.value + "    ");
                }
                System.out.println();
            }
        }
    }


}
