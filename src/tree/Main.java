package tree;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        binaryNotBalancedTree();
    }

    private static void some() {
        Random random = new Random(1);
        List<Integer> list = new ArrayList<>();

        IntStream.range(0, 1000).forEach(list::add);

        RandomTree<Integer> tree = new RandomTree<>();
        list.forEach(tree::insert);
        printTreeStats(tree);

        Collections.shuffle(list);
        list.forEach(e -> {
            if (random.nextInt(100) < 1) {
                return;
            }
            tree.remove(e);
        });
        printTreeStats(tree);

    }

    private static void printTreeStats(RandomTree<Integer> tree) {
        System.out.printf("Size: %s. BalanceFactor: %s%n", tree.getSize(), tree.calculateBalanceFactor());
    }


    public static void binaryNotBalancedTree() {
        BinaryNotBalancedTree <Integer> binaryNotBalancedTree = new BinaryNotBalancedTree<>();
        binaryNotBalancedTree.insert(5);
        binaryNotBalancedTree.insert(2);
        binaryNotBalancedTree.insert(3);
        binaryNotBalancedTree.insert(7);
        binaryNotBalancedTree.insert(6);
        binaryNotBalancedTree.insert(7);
        binaryNotBalancedTree.print();
//        tree.remove(5);
        binaryNotBalancedTree.print();

        MyClass myClassInstance = new MyClass();
        MyClass compareWith = new MyClass();

        boolean equals = myClassInstance.compareTo(compareWith) == 0;
        boolean myClassInstanceMoreThanCompareWith = myClassInstance.compareTo(compareWith) > 0;
        boolean myClassInstanceLessThanCompareWith = myClassInstance.compareTo(compareWith) < 0;
    }

    public static void randomTree(){
        RandomTree <Integer> randomTree= new RandomTree<>();
        for (int j = 0; j < 5; j++){
            int rand = (int) (Math.random()*10);
            randomTree.insert(rand);
        }
//        randomTree.insert(4);
//        randomTree.insert(2);
//        randomTree.insert(6);
//        randomTree.insert(3);
//        randomTree.insert(8);
//        randomTree.insert(1);
//        randomTree.insert(0);
//        randomTree.insert(9);
//        randomTree.insert(5);

        randomTree.printTree();
        System.out.println(Arrays.toString(randomTree.getElements()));
        System.out.println(randomTree.calculateBalanceFactor());

//        randomTree.remove(5);
//        randomTree.remove(3);
//        randomTree.printTree();
//        System.out.println(Arrays.toString(randomTree.getElements()));

//        randomTree.print();

//        print10raz();

    }

    private static void print10raz() {
        RandomTree<Integer> randomTree = new RandomTree<>();
        for (int j = 0; j < 10; j++){
            int rand = (int) (Math.random()*10);
            randomTree.insert(rand);
        }
        randomTree.printTree();
        randomTree.printTree();
        randomTree.printTree();
        randomTree.printTree();
        randomTree.printTree();
        randomTree.printTree();
        randomTree.printTree();
        randomTree.printTree();
        randomTree.printTree();
        randomTree.printTree();

    }
}
