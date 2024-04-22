package my_collections;

public class Queue<T> {

    private Object[] queue;
    private int fullCells = 0;

    public Queue(int initialCapacity) {
        System.out.println("Requested queue capacity: " + initialCapacity);
        this.queue = new Object[initialCapacity];
    }

    private int head;
    private int tail = -1;

    public boolean isEmpty() {
        return fullCells == 0;
    }
    public int getSize() {
        return fullCells;
    }

    public void add(T value) throws IndexOutOfBoundsException {
        if (fullCells == queue.length) {
//                Object[] queueNew = queue;
//                queue = new Object[queue.length * 2];
//                for (int i = 0; i < queueNew.length; i++) {
//                    queue[i] = queueNew[i];
//                }
            throw new IndexOutOfBoundsException("переполнено, некуда добавлять");
        }
        ++fullCells;
        tail = CycleUtils.stepRight(tail, queue.length);
        queue[tail] = value;
    }
    public T remove() throws IndexOutOfBoundsException {
        if (fullCells == 0) {
            throw new IndexOutOfBoundsException("пусто, нечего удалять");
        }
        fullCells--;
        T value = (T) queue[head];
        head = ++head % queue.length;
        return value;
    }

    public T peekFirst() throws IndexOutOfBoundsException {
        if (fullCells == 0) {
            throw new IndexOutOfBoundsException("пусто, нечего достать");
        }
        return (T) queue[head];
    }

    void print() {
        if (fullCells == 0){
            return;
        }
        for (int i = 0; i < fullCells; i++) {
            System.out.println(queue[(head+i) % queue.length]);
//            if(queue[i] != null) {
//                System.out.println(queue[i]);
//            }
        }
        System.out.println("Заполненных ячеек: " + fullCells);
        System.out.println("Индекс первого элемента " + head);
        System.out.println();

    }


}
