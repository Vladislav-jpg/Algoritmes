package Piramidalnya;

import java.util.Arrays;
import java.util.Random;

public class HeapSortRecursive {

    public static long C = 0; // comparisons
    public static long M = 0; // moves

    public static void heapify(int[] arr, int n, int i) {

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            C++;
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            C++;
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }

        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            M += 3;

            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {

        int n = arr.length;

        // build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // sorting
        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            M += 3;

            heapify(arr, i, 0);
        }
    }

    public static int[] generateArray(int n) {

        Random rand = new Random();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100000);
        }

        return arr;
    }

    public static void main(String[] args) {

        int size = 20;

        int[] arr = generateArray(size);
        System.out.println(Arrays.toString(arr));

        heapSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Recursive Heap Sort");
        System.out.println("Comparisons: " + C);
        System.out.println("Moves: " + M);
    }
}