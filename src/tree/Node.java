package tree;

public class Node <T> {
//    int key;
    T value;
    Node<T> leftChild;
    Node<T>  rightChild;
    Node<T>  child;

    public Node(T value){
        this.value = value;
//        this.key = key;
    }

}
