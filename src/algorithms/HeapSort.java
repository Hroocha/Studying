package algorithms;

import tasks.p7.Array;

public class HeapSort { // пирамидальная
    public static void main(String[] args) {
        int[] arr =
                {7, 3, 1, 7, 0, 43, 9, 912, 4, 7, 90, 2};
//        {7,3,0,2,6,9,1,4,8,5};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    // 1. построить heap
    // 2. вынимать большее значение
    // 3. повторять

    // ищу с середины, проверяю левого и правого, ищу большего
    // и если он больше родителя, то меняю местами и для всех его потомков
    // реверсивно делаю то же самое
    // потом прохожусь по каждому элементу с конца масива
    // меняю местами первый(нибольший элемент) и последний
    // передаю в heapify массив с началом в 0,
    // а конец это индекс наибольшего элемента -1
    // т.е каждый раз передаю в heapify все меньший массив на рассмотрение
    public static void heapSort(int [] arr){
        int size = arr.length;
        for (int i = size/2; i >= 0; i--) {
            heapify(arr, i, size-1);
        }
        for (int i = size-1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr,0, i-1);
        }
    }

    private static void heapify(int[] arr, int i, int to) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if(left <= to && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right <= to && arr[right] > arr[largest]) {
            largest = right;
        }

        if(i != largest){
            swap(arr, i, largest);
            heapify(arr,largest, to);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int variable = arr[y];
        arr[y] = arr[x];
        arr[x] = variable;
    }


}
