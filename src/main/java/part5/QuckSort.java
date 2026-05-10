package part5;

import java.util.Arrays;

public class QuckSort {
    public static void main(String[] args) {
        System.out.println("QuickSort");
        int[] arr = new int[] {5, 3, 5, 7, 9, 942, 24, 643, 236, 2, 56, 98};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] array, int from, int to){
        if (from < to){
            int divideIndex = partition(array, from, to);
            quickSort(array, from, divideIndex-1);
            quickSort(array, divideIndex, to);
        }

    }
    private static int partition(int[] array, int from, int to){
        int rightIndex = to;
        int leftIndex = from;
        int pivot = array[from + (to - from) / 2]; // середина

        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
                leftIndex++;
            }
            while (array[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;


                leftIndex++;
                rightIndex--;
            }
        }
    return leftIndex;
    }
}
