package my_collections;

public class LinkedList<T> {

    private int size = 0;
    private Node head;

    private final class Node {
        T value;
        Node next;
        public Node(T value){
            this.value = value;
        }
    }

    void add(T value){ this.add(value,size);}
//        if (size == 0) {
//            head  = new Node(value);
//            size++;
//            return;
//        }
//        Node node = head;
//        while (node.next != null ) {
//            node = node.next;
//        }
//        node.next = new Node(value);
//        size++;
//    }
    void add(T value, int i) throws IndexOutOfBoundsException {
        if (i == 0){
            Node node = new Node(value);
            node.next = head;
            head = node;
            size++;
            return;
        }
        else if (i <= size) {
            Node node = head;
            while (i != 1) { // стоим перед нужным нам индексом
                node = node.next;
                i--;
            }
            Node node2 = new Node(value);
            node2.next = node.next;
            node.next = node2;
            size++;
        }
        else {
            throw new IndexOutOfBoundsException("не добавлено");}
    }
    void remove() { this.removeFrom(size-1);}
//        if (size == 0)  {
//            throw new IndexOutOfBoundsException("пусто, нечего удалять");}
//
//        Node node = head;
//        while (node.next.next != null ) {
//            node = node.next;
//        }
//        node.next = null;
//        size--;
//    }
    void removeFrom(int i) throws IndexOutOfBoundsException {
        if (size == 0)  {
            throw new IndexOutOfBoundsException("пусто, нечего удалять");}
        else if (i == 0){
            head = head.next;
            size--;
            return;
        }
        Node node = head;
        while (i != 1) {
            node = node.next;
            i--;
        }
        node.next = node.next.next;
        size--;
    }
    void print() {
        if (size == 0){
            System.out.println("пусто");
            return;
        }
        Node node = head;
        System.out.println(node.value);
        while (node.next != null ) {
            node = node.next;
            System.out.println(node.value);
        }
        System.out.println();
    }
}
