package my_collections;

public class LinkedList2<T> {


    private int size = 0;
    private Node head;
    private Node tail;

    private final class Node {
        T value;
        Node next;
        Node prev;

        public Node(T value) {
            this.value = value;
        }
    }

    void add(T value) {
        this.add(value, size);
    }

    void add(T value, int i) throws IndexOutOfBoundsException {
        Node node = new Node(value);
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
            size++;
            return;
        } else if (i == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
            return;
        } else if (i >= size) {
            throw new IndexOutOfBoundsException("значение " + value + " не добавлено");
        } else if (i <= size / 2) {
            node = head;
            while (i != 0) {
                node = node.next;
                i--;
            }
        } else if (i > size / 2) {
            node = tail;
            int j = size - 1;
            while (i != j) {
                node = node.prev;
                j--;
            }
        }
        node.prev.next = newNode;
        newNode.prev = node.prev;
        newNode.next = node;
        node.prev = newNode;
        size++;
    }

    void remove() { this.removeFrom(size-1);}

    void removeFrom(int i) throws IndexOutOfBoundsException {
        Node node = head;
        if (size == 0) {
            throw new IndexOutOfBoundsException("пусто, нечего удалять");
        } else if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("такого места нет, не удалено");
        } else if (i == size - 1) {
            tail.prev.next = null;
            tail = tail.prev;
            size--;
            return;
        } else if (i == 0) {
            head.next.prev = null;
            head = head.next;
            size--;
            return;
        } else if (i <= size / 2) {
            while (i != 0) {
                node = node.next;
                i--;
            }
            size--;
        } else if (i > size / 2) {
            node = tail;
            int j = size - 1;
            while (i != j) {
                node = node.prev;
                j--;
            }
            size--;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void print() {
        Node node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println();
    }
}



