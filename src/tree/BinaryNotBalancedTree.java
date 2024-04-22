package tree;


public class BinaryNotBalancedTree<T extends Comparable<T>> implements Tree<T>{
    Node<T> root;
    Node<T>  nodeParent = null;
    Node<T>  nodeToDel = null;
    Node<T>  max = null;
    int size = 0;
    @Override
    public void insert(T value) {
        if (root == null) {
            root = new Node<T> (value);
            size++;
        } else doInsert(root, value);
    }

    private void doInsert(Node<T>  node, T value) {
        if (value.compareTo(node.value) < 0) {
            if (node.leftChild == null) {
                node.leftChild = new Node<T> (value);
            } else doInsert(node.leftChild, value);
        } else if (value.compareTo(node.value) > 0) {
            if (node.rightChild == null) {
                node.rightChild = new Node<T> (value);
            } else doInsert(node.rightChild, value);
        } else { // если не уникальное значение
            if (node.rightChild == null){
                node.rightChild = new Node<T> (value);
            } else {
                Node<T> duplicate = new Node<T> (value);
                duplicate.rightChild = node.rightChild;
                node.rightChild = duplicate;
            }
        }
    }
    @Override
    public void remove(T value) throws NullPointerException {
        if (root == null) {
            throw new NullPointerException("дерево пустое, нечего удалять");
        }
        if (value == root.value) { // если удаляемое значение в корне
            nodeParent = null;
            nodeToDel = root;
            doRemove(nodeToDel, value);
            return;
        }
        passTree(root, value); // ищем где удалять и родителя
    }

    private void passTree(Node<T> node, T value) { // проходим дерево от мин к мах, находим nodeParent и nodeToDel
        if (node != null) {
            if (node.leftChild != null) {
                if (value == node.leftChild.value) {
                    nodeParent = node;
                    nodeToDel = nodeParent.leftChild;
                    doRemove(nodeToDel, value);
                    return;
                }
            }
            if (node.rightChild != null) {
                if (value == node.rightChild.value) {
                    nodeParent = node;
                    nodeToDel = nodeParent.rightChild;
                    doRemove(nodeToDel, value);
                    return;
                }
            }
            passTree(node.leftChild, value);
            passTree(node.rightChild, value);
        }
    }

    private void linkToChild(Node<T>  nodeParent, T value) {
        if (nodeParent.leftChild != null && nodeParent.leftChild.value == value) {
            nodeParent.leftChild = nodeParent.child;
        } else {
            nodeParent.rightChild = nodeParent.child;
        }
    }

    private void findMax(Node<T> node) {
        if (node != null) {
            if (node.value.compareTo(max.value) >= 0) {
                nodeParent = max;
                nodeToDel = max = node;
            }
            findMax(node.rightChild);
        }
    }

    private void doRemove(Node<T> nodeToDel, T value) {
//        1. если нет детей, затереть
        if (nodeToDel.leftChild == null && nodeToDel.rightChild == null) {
            linkToChild(nodeParent, value);
            nodeParent.child = null;
        }
//        2. если есть 1 ребенок, перезаписать его
        else if (nodeToDel.rightChild == null) {  // если слева
            nodeToDel.child = nodeToDel.leftChild;
            linkToChild(nodeParent, value);
        } else if (nodeToDel.leftChild == null) { // если справа
            nodeToDel.child = nodeToDel.rightChild;
            linkToChild(nodeParent, value);
        }
//        3. если 2 ребенка найти меньшего и по его ветви найти большего и записать его на место удаляемого
        if (nodeToDel.leftChild != null && nodeToDel.rightChild != null) {
            max = nodeToDel.leftChild;
            findMax(nodeToDel);
            nodeToDel.value = max.value;
            doRemove(max, max.value);
        }

    }

    private void passTreeForPrint(Node<T>  node) { // проходим дерево от меньшего к большему
        if (node != null) {            //  по идее это и есть принт
            passTreeForPrint(node.leftChild);
            System.out.println(node.value);
            passTreeForPrint(node.rightChild);
        }
    }

    public void print() {
        passTreeForPrint(root);
        System.out.println();
    }


    @SuppressWarnings("unchecked")
    @Override
    public T[] getElements() {
        if (root == null) {
            throw new NullPointerException("дерево пустое");
        }
        i = 0;
        Integer[] array = new Integer[size];
        findElements(root, array);
        return (T[]) array;
    }
    int i = 0;
    private void findElements(Node<T> node, Integer[] array) {
        if (node != null) {
            findElements(node.leftChild, array);
            array[i++] = (Integer) node.value;
            findElements(node.rightChild, array);
        }
    }

    @Override
    public long getSize() {
        return this.size;
    }
}
