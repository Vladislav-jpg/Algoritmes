package part5;
import java.util.Random;

public class MergeSort {
    public static long comparisons = 0;
    public static long moves = 0;
    public static void main(String[] args) {
        System.out.println("Размер" + "    " + "Сумма сравнений" +"    "+ "Сумма пересылок");
        for (int size = 100000; size < 1000000000; size+= 100000) {
            for (int iteraions =0; iteraions < 100; iteraions++) {
                int[] arr = new int[size];
                Random rand = new Random();
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = rand.nextInt(10000);
                }
                mergeSort(arr);
            }
            System.out.println(size +"    " + comparisons +"          "+ moves);
            moves = 0;
            comparisons = 0;
        }
    }
    public static void mergeSort(int[] array) {
        if (array.length <= 1) return;

        int mid =  array.length / 2;

        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
            moves++;
        }

        for (int i = mid; i<array.length; i++) {
            right[i - mid] = array[i];
            moves++;
        }

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);

    }
    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0; // left
        int j = 0; // right
        int k = 0; // main array

        while (i < left.length && j < right.length) {
            comparisons++;
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            }
            else {
                array[k] = right[j];
                j++;
            }
            k++;
            moves++;
        }
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
            moves++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
            moves++;
        }
    }
}
