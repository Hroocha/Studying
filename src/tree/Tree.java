package tree;

public interface Tree<T extends Comparable<T>> {
    void insert(T value);

    void remove(T value);

    T[] getElements();

    long getSize();
}
