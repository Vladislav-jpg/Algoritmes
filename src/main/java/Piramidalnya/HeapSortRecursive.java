package Piramidalnya;

import java.util.Random;

public class HeapSortRecursive {

    public static long C = 0; // comparisons
    public static long M = 0; // moves

    public static void main(String[] args) {
        System.out.println("Heap Sort Recursive");
        System.out.println("Размер" + "    " + "Сумма сравнений и пересылок" +"    "+ "Среднее время");
        for (int size = 100000; size < 100000000; size+= 100000){
            long totaltime = 0;
            for(int iterations =0; iterations<100; iterations++){
                int[] arr = new int[size];
                Random rand = new Random();
                for (int i = 0; i < arr.length; i++) arr[i] = rand.nextInt(10000);
                long start = System.nanoTime();
                heapSort(arr);
                totaltime +=  System.nanoTime() - start;
            }
            System.out.println(size + "     " + (C+M) + "       " + totaltime);
        }
    }

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



}