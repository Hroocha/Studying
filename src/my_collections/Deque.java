package my_collections;

public class Deque<T> {

    private final Object[] deque;

    public Deque(int initialCapacity) {
        this.deque = new Object[initialCapacity];
    }

    private int fullCells = 0;
    private int head;
    private int tail;

    void addFirst(T value) {
        if (fullCells == 0) {
            head = tail = 0;
            deque[head] = value;
            ++fullCells;
            return;
        }
        ++fullCells;
        head = CycleUtils.stepLeft(head, deque.length);
        deque[head] = value;
    }

    void addLast(T value) {
        if (fullCells == 0) {
            head = tail = 0;
            deque[tail] = value;
            ++fullCells;
            return;
        }
        ++fullCells;
        tail = CycleUtils.stepRight(tail, deque.length);
        deque[tail] = value;
    }

    T pollFirst() {
        if (fullCells == 0) {
            return null;
        }
        T value = (T) deque[head];
        deque[head] = null;
        head = CycleUtils.stepRight(head, deque.length);
        --fullCells;
        return value;
    }

    ;

    T pollLast() {
        if (fullCells == 0) {
            return null;
        }
        T value = (T) deque[tail];
        deque[tail] = null;
        tail = CycleUtils.stepLeft(tail, deque.length);
        --fullCells;
        return value;
    }

    ;


    T getFirst() {
        return (T) deque[head];
    }

    ;

    T getLast() {
        return (T) deque[tail];
    }

    ;


    void print() {
        for (int i = 0; i < deque.length; i++) {
            System.out.println(deque[i]);
//            if(queue[i] != null) {
//                System.out.println(queue[i]);
//            }
        }
        System.out.println("Заполненных ячеек: " + fullCells);
        System.out.println("Индекс первого элемента " + head);
        System.out.println("Индекс последнего элемента " + tail);
        System.out.println();
    }


}
