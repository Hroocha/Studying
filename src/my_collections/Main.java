package my_collections;

public class Main {

// 1. Стек реализовать и сделать на основе массива, метод пуш и поп выташить, поп получает элемент и
// вытаскивает его из стека, метод пик peek, который получает верхний элемент в стеке и не удаляет
// 2. Сделать очередь и те же операции


    public static void main(String[] args) {
//        testStack();
//        testQueue();
//        testDeq();
//        testSet();
        testLL();
//        testLL2();

//        int i = 0;
//        int size = 4;
//        for (int j = 0; j < 100; j++) {
//            i = (--i + size) % size;
//            System.out.println(i);
//        }

    }
    public static void testLL2(){
        LinkedList2<Integer> linkedList2 = new LinkedList2<>();
        linkedList2.add(1);
        linkedList2.add(2);
        linkedList2.add(3);
        linkedList2.add(1,2);
        linkedList2.print();
        linkedList2.remove();
        linkedList2.print();
    }

    public static void testLL() {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(1,1);
        linkedList.print();
        linkedList.remove();
        linkedList.add(7);
        linkedList.print();




    }

    private static void testSet() {
        Set<Integer> set = new Set<>(3);
        set.add(1);
        set.add(2);
        set.add(3);
        set.print();
        set.remove(2);
        set.print();
        set.add(1);
        set.print();
    }

    private static void testDeq() {
        Deque<Integer> deque = new Deque<Integer>(3);
        deque.addLast(1);
        deque.addFirst(2);
        deque.print();
        System.out.println("При удалении вернул " + deque.pollLast());
        deque.print();
        System.out.println("При удалении вернул " + deque.pollFirst());
        deque.print();
        deque.addLast(1);
        deque.print();
        deque.addLast(1);
        deque.print();
        System.out.println("При удалении вернул " + deque.pollLast());
        deque.print();
    }

    private static void testQueue() {
        Queue<String> queue = new Queue<>(3);
//        queue.peekFirst();
        queue.add("uwu");
        queue.add("aww");
        queue.add("eww");
//        queue.add("eww");
        queue.print();
        System.out.println("При удалении вернул " + queue.remove());
        queue.print();
        queue.add("new1");
        queue.print();
        System.out.println("При удалении вернул " + queue.remove());
        queue.print();
        queue.add("new2");
        queue.print();
        System.out.println("При удалении вернул " + queue.remove());
        queue.print();
//        System.out.println("При удалении вернул " + queue.remove());
//        queue.print();
//        System.out.println("При удалении вернул " + queue.remove());
//        queue.print();
    }

    private static void testStack() {
        Stack<String> stack = new Stack<>(3);
        Stack<Long> longStack = new Stack<>(3);
        stack.print();
        stack.push("пися");
        stack.push("попа");
        stack.print();
        System.out.println("Вернул " + stack.pop());
        stack.print();
        System.out.println("Вернул " + stack.peek());
        stack.print();
    }


}
