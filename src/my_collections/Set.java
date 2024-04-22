package my_collections;

public class Set<T> {
    public final Object[] set;

    public Set(int initialCapacity) {
        this.set = new Object[initialCapacity];
    }

    void add(T value) {
        for (int i = 0; i < set.length; i++) {
            if (value.equals(set[i])){
                break;
            } else if (set[i] == null) {
                set[i] = value;
                break;
            }
        }
    }

    void remove(T value) {
        for (int i = 0; i < set.length; i++) {
            if (set[i].equals(value)) {
                set[i] = null;
                break;
            }
        }
    }

    void print() {
        for (int i = 0; i < set.length; i++) {
            System.out.println(set[i]);
        }
        System.out.println();
    }
}
