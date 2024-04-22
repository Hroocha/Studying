package tree;

import my_collections.Queue;

import java.util.Random;

public class RandomTree<T extends Comparable<T>> implements Tree<T> {

    private static final Random RANDOM = new Random();

    private static class Node<T extends Comparable<T>> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> root;
    private Node<T> nodeParent = null;
    private Node<T> nodeCur = null;
    private int size = 0;

    @Override
    public void insert(T value) {
        if (root == null) {
            root = new Node<T>(value);
            size++;
            return;
        }
        int[]  countSteps  = new int[]{0};
        if (needRotate(randomChance(root))) { // вставка в корень
            doInsertToRoot(root, value, countSteps);
        } else doInsert(root, value, countSteps);
        size++;
    }

    private boolean needRotate(int root) {
        return root == 0;
    }

    private int randomChance(Node<T> root) {
        return RANDOM.nextInt(countNodes(root));
    }
    private int countNodes(Node<T> root) {
        i = 0;
        Integer[] sumOfNodes = new Integer[size];
        findElements(root,sumOfNodes);
        return sumOfNodes.length;
    }
    private void turnRight(Node<T> node) {
        findParent(root, node);
        if (root == nodeParent) {
            root = node;
            nodeParent.left = node.right;
            node.right = nodeParent;
            nodeCur = node;
            return;
        }
        if (nodeParent == null) {
            nodeCur = node;
            return;
        }
        nodeParent.left = node.right;
        node.right = nodeParent;
        greatParentsSonIntoNodeCur(node);
        nodeCur = node;
    }

    private void turnLeft(Node<T> node) {
        findParent(root, node);
        if (root == nodeParent) {
            root = node;
            nodeParent.right = node.left;
            node.left = nodeParent;
            nodeCur = node;
            return;
        }
        if (nodeParent == null) {
            nodeCur = node;
            return;
        }
        nodeParent.right = node.left;
        node.left = nodeParent;
        greatParentsSonIntoNodeCur(node);
        nodeCur = node;
    }

    private void greatParentsSonIntoNodeCur(Node<T> node) {
        Node<T> parent = nodeParent;
        findParent(root, parent);
        if (nodeParent == null) {
            nodeCur = node;
            return;
        }
        if (nodeParent.left == parent) {
            nodeParent.left = node;
        } else {
            nodeParent.right = node;
        }
    }

    private void findParent(Node<T> root, Node<T> node) {
        if (root != null) {
            if (node == this.root) {
                nodeParent = null;
                return;
            }
            if (root.left != null) {
                if (node == root.left) {
                    nodeParent = root;
                    return;
                } else {
                    findParent(root.left, node);
                }
            }
            if (root.right != null) {
                if (node == root.right) {
                    nodeParent = root;
                } else {
                    findParent(root.right, node);
                }
            }
        }
    }

    private void doStepUpAndTurn(int steps) {
        while (steps != 0) { // делаем шаг на родителя и поварачиваем с нашим нодoм, до нужного места
//                    if(this.root != null){
            findParent(this.root, nodeCur);
//                    }
            if (nodeParent == null) {
                return;
            } else if (nodeParent.left == nodeCur) { // повыарачивать влево или вправо
                turnRight(nodeCur);
            } else {
                turnLeft(nodeCur);
            }
            steps--;
        }
    }

    private void doInsertToRoot(Node<T> root, T value, int[]  countSteps) { // нашли нод в который хотим записать новый нод
        if (value.compareTo(root.value) <= 0) { //идем влево
            if (root.left == null) {
                root.left = new Node<T>(value);
                turnRight(root.left);
                doStepUpAndTurn(countSteps[0]);
            } else {
                countSteps[0]++;
                doInsertToRoot(root.left, value, countSteps);
            }
        } else if (value.compareTo(root.value) > 0) { //идем вправо
            if (root.right == null) {
                root.right = new Node<T>(value);
                turnLeft(root.right);
                doStepUpAndTurn(countSteps[0]);
            } else {
                countSteps[0]++;
                doInsertToRoot(root.right, value, countSteps);
            }
        }
    }

    private void doInsert(Node<T> root, T value, int[]  countSteps) { // работает правильно
//        countSteps[0] = 0;
        if (value.compareTo(root.value) <= 0) {  //идем влево
            if (root.left == null) {
                root.left = new Node<T>(value);
            } else {
                if (needRotate(randomChance(root.left))) {
                    doInsertToRoot(root.left, value, countSteps);
                } else {
                    doInsert(root.left, value, countSteps);
                }
            }
        } else if (value.compareTo(root.value) > 0) { //идем вправо
            if (root.right == null) {
                root.right = new Node<T>(value);
            } else {
                if (needRotate(randomChance(root.right))) {
                    doInsertToRoot(root.right, value, countSteps);
                } else {
                    doInsert(root.right, value, countSteps);
                }
            }
        }
    }

    /**
     * @return средняя длина пути до произвольного узла
     */
    public double calculateBalanceFactor() {
//        throw new UnsupportedOperationException();
        int curDepth = -1;
        double[] commonDepth = new double[]{0};
        findCommonDepth(curDepth,root,commonDepth);
        return commonDepth[0]/size;
    }

    private void findCommonDepth(int curDepth, Node<T> node, double[] commonDepth) { // работает правильно
        curDepth++;
        if (node != null) {
            commonDepth[0] += curDepth;
            findCommonDepth(curDepth, node.left, commonDepth);
            findCommonDepth(curDepth, node.right, commonDepth);
        }
    }

    @Override
    public void remove(T value) {
        if (root == null) {
            throw new NullPointerException("дерево пустое, нечего удалять");
        }
        if (needRotate(value.compareTo(root.value))) { // если удаляемое значение в корне
            nodeParent = null;
            nodeCur = root;
            doRemove(nodeCur, value);
            size--;
            return;
        }
        findNodeToDel(root, value); // ищем где удалять и родителя
    }

    private void findNodeToDel(Node<T> node, T value) { // проходим дерево от мин к мах, находим nodeParent и nodeToDel
        if (node != null) {
            if (node.left != null) {
                if (needRotate(value.compareTo(node.left.value))) {
                    nodeParent = node;
                    nodeCur = nodeParent.left;
                    doRemove(nodeCur, value);
                    size--;
                    return;
                }
            }
            if (node.right != null) {
                if (needRotate(value.compareTo(node.right.value))) {
                    nodeParent = node;
                    nodeCur = nodeParent.right;
                    doRemove(nodeCur, value);
                    size--;
                    return;
                }
            }
            findNodeToDel(node.left, value);
            findNodeToDel(node.right, value);
        }
    }

    private void doRemove(Node<T> nodeCur, T value) {
        if (needRotate(value.compareTo(nodeCur.value))) {
            Node<T> nodeNewRoot = union(nodeCur.left, nodeCur.right); // объединяю левую и правую ветвь удаляемого нода
            findParent(root, nodeCur);
            if (nodeParent != null && nodeParent.left == nodeCur) { // меняю ссылки у родителя
                nodeParent.left = nodeNewRoot;
            } else if (nodeParent != null && nodeParent.right == nodeCur) {
                nodeParent.right = nodeNewRoot;
            } else { // если удаляем из головы
                root = nodeNewRoot;
            }
        } else if (value.compareTo(nodeCur.left.value) <= 0) { // иду влево
            doRemove(nodeCur.left, value);
        } else { // идем вправо
            doRemove(nodeCur.right, value);
        }
    }

    private Node<T> union(Node<T> nodeLeft, Node<T> nodeRight) { // придумать как слить ноды в один
        if (nodeLeft == null) {
            return nodeRight;
        }
        if (nodeRight == null) {
            return nodeLeft;
        }
        int sumOfLeft = countNodes(nodeLeft);
        int chance = (int) (Math.random() * (sumOfLeft + countNodes(nodeRight) + 1));
        if (chance <= sumOfLeft) {
            nodeCur = nodeLeft;
            nodeLeft.right = union(nodeCur.right, nodeRight);
            return nodeLeft;
        } else {
            nodeCur = nodeRight;
            nodeRight.left = union(nodeLeft, nodeCur.left);
            return nodeRight;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] getElements() {
//        throw new UnsupportedOperationException();
        if (root == null) {
            throw new NullPointerException("дерево пустое");
        }
        i = 0;
        Integer[] array = new Integer[size];
        findElements(root, array);
        return (T[]) array;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    int i = 0;
    private void findElements(Node<T> node, Integer[] array) {
        if (node != null) {
            findElements(node.left, array);
            array[i++] = (Integer) node.value;
            findElements(node.right, array);
        }
    }

    public void printTree() { // работает
        int curDepth = 0; // уровни/divisor
        int[] maxDepth = new int[]{0};
        findDepth(curDepth, root, maxDepth);
        int level = maxDepth[0] + 1;
        Queue<Node<T>> nodeQueueParents = new Queue<>((int) Math.pow(2, level));
        Queue<Node<T>> nodeQueue = new Queue<>((int) Math.pow(2, level));
        nodeQueue.add(root);
        printFromQueue(nodeQueue, level--, nodeQueueParents); // 1
        while (maxDepth[0]-- != 0) {
            findChildren(nodeQueueParents, nodeQueue);
            printFromQueue(nodeQueue, level--, nodeQueueParents);
        }
    }

    private void findDepth(int curDepth, Node<T> node, int[] maxDepth) { // работает правильно
        curDepth++;
        if (node != null) {
            if (curDepth > maxDepth[0]) {
                maxDepth[0] = curDepth;
            }
            findDepth(curDepth, node.left, maxDepth);
            findDepth(curDepth, node.right, maxDepth);
        }
    }

    private void findChildren(Queue<Node<T>> nodeQueueParents, Queue<Node<T>> nodeQueue) {
        if (nodeQueueParents == null || nodeQueueParents.isEmpty()) {
            return;
        }
        while (!nodeQueueParents.isEmpty()) {
            childrenToQueue(nodeQueueParents.remove(), nodeQueue);
        }
    }

    private void childrenToQueue(Node<T> node, Queue<Node<T>> nodeQueue) {
        Node<T> nodeEmpty = null;
        if (node != null) {
            if (node.left != null) {
                nodeQueue.add(node.left);
            } else {
                nodeQueue.add(nodeEmpty);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
            } else {
                nodeQueue.add(nodeEmpty);
            }
        } else {
            nodeQueue.add(nodeEmpty);
            nodeQueue.add(nodeEmpty);
        }
    }

    private void printFromQueue(Queue<Node<T>> nodeQueue, int level, Queue<Node<T>> nodeQueueParents) {
        if (nodeQueue == null || nodeQueue.isEmpty()) {
            return;
        }
        // 2 в степени уровня, деленная на количество интервалов между значениями
        int interval = (((int) Math.pow(2, level)) / 2);
        if (needRotate(interval)) {
            return;
        }
        int size = nodeQueue.getSize();
        nodeQueueParents.add(nodeQueue.peekFirst()); // печатаем певрве значение из очереди отступая интервал
        printNode(nodeQueue.peekFirst(), interval);
        nodeQueue.remove();
        size--;
        while (size != 0) {
            size--;
            nodeQueueParents.add(nodeQueue.peekFirst());
            printNode(nodeQueue.remove(), (interval * 2) - 1);
        }
        System.out.println();
    }

    private void printNode(Node<T> node, int interval) {
        if (node != null) {
            while (interval-- != 0) {
                System.out.print(" ");
            }
            System.out.print(node.value);
        } else {
            while (interval-- != 0) {
                System.out.print(" ");
            }
            System.out.print(" ");
        }
    }

    private void passTreeForPrint(Node<T> node) { // проходим дерево от меньшего к большему
        if (node != null) {            //  по идее это и есть принт
            passTreeForPrint(node.left);
            System.out.println(node.value);
            passTreeForPrint(node.right);
        }
    }

    public void print() {
        passTreeForPrint(root);
        System.out.println();
    }

}
