package my_collections;

public class Stack<T> {
    private final Object[] stack;

    private int fullCells = 0;

    public Stack(int initialCapacity) {
        this.stack = new Object[initialCapacity];
    }

    void push(T value) throws IndexOutOfBoundsException {
            if (fullCells == stack.length){
                throw new IndexOutOfBoundsException("переполнено, некуда добавлять");}
        stack[fullCells++] = value;

//        при вставке выходим за рамки стека, выдать исключение что мы выходим за рамки стека
//        в методе поп, при выходе за рамки стека (в минус, с др. стороны), тоже дать исключение
//        посмотреть какие есть классы исключений в джаве, и узанть какие мне подойдут, подобрать
    }

    T pop() throws IndexOutOfBoundsException {
        if (fullCells == 0){
            throw new IndexOutOfBoundsException("пусто, нечего удалять");}
        T value = (T) stack[fullCells - 1];
        stack[--fullCells] = null;
        return value;
    }
    @SuppressWarnings("unchecked")
    T peek() {
        return (T) stack[fullCells - 1];
    }

    void print () {
        for (int i = 0; i < fullCells; i++) {
            System.out.println(stack[i]);
        }
    }

}
