package part5;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Merge Sort");
        int[] array = new int[]{5, 3, 2, 77, 314, 124};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSort(int[] array) {
        if (array.length <= 1) return;

        int mid =  array.length / 2;

        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i<array.length; i++) {
            right[i - mid] = array[i];
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
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
                k++;
            }
            else {
                array[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
