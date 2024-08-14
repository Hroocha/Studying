package algorithms;

public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,9,912,4,7,90,2};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int [] arr, int left, int right){
        if (arr.length == 0 || left >= right) {
            return;
        }

        int middleIndex = left + (right - left)/2;
        int middleNumber = arr[middleIndex];

        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < middleNumber) i++; // ищем числа для swap
            while (arr[j] > middleNumber) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (left < j) quickSort(arr, left, j);
        if (right > i) quickSort(arr, i, right);
    }

    private static void swap(int [] arr, int i, int j){
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }



}
