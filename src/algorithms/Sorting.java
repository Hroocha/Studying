package algorithms;

public class Sorting {

    public static void main(String[] args) {
        int [] arr = {7,3,1,7,0,43,9,912,4,7,90,2};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int [] arr){
        if(arr.length == 1){
            return;
        }
        int mid = arr.length/2;
        int [] arrOne = new int[mid];
        int [] arrTwo = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            arrOne[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            arrTwo[i-mid] = arr[i];
        }

        mergeSort(arrOne);
        mergeSort(arrTwo);
        merge(arr, arrOne, arrTwo);
    }

    private static void merge(int[] arr, int[] arrOne, int[] arrTwo) {
        int iOne = 0;
        int iTwo = 0;
        int iArr = 0;

        while (iOne < arrOne.length && iTwo < arrTwo.length){
            if(arrOne[iOne] < arrTwo[iTwo]){
                arr[iArr++] = arrOne[iOne++];
            } else {
                arr[iArr++] = arrTwo[iTwo++];
            }
        }

        for (int i = iOne; i < arrOne.length; i++) {
            arr[iArr++] = arrOne[i];
        }
        for (int i = iTwo; i < arrTwo.length; i++) {
            arr[iArr++] = arrTwo[i];
        }
    }
}
