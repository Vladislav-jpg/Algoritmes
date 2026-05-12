package part5;

import java.util.Arrays;
import java.util.Random;

public class MyQsort_vs_libQsort {
    public static void main(String[] args) {
        System.out.println("count" + "    " + "average time My sort" + "     " + "average time lib");
        for (int count = 100000; count < 10000000; count += 100000){
            int[] arr = new int[count];
            long totaltimemy = 0;
            long totaltimelib = 0;
            for (int iterations = 0; iterations < 10; iterations ++){
                Random rand = new Random();
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = rand.nextInt(10000);
                }
                int[] copyarr = Arrays.copyOf(arr, arr.length);
                long start1 = System.nanoTime();
                Arrays.sort(copyarr);
                totaltimelib += System.nanoTime() - start1;

                long start2 = System.nanoTime();
                myqsort(arr, 0, arr.length-1);
                totaltimemy += System.nanoTime() - start2;

            }
            System.out.println(count + "    " + totaltimemy /10 + "     " + totaltimelib/10);


        }

    }


    public static void myqsort(int[] array, int from, int to) {
        if (from < to){
            int divideIndex = partition(array, from, to);
            myqsort(array, from, divideIndex-1);
            myqsort(array, divideIndex, to);
        }
    }
    private static int partition(int[] array, int from, int to){
        int rightIndex = to;
        int leftIndex = from;
        int pivot = array[from + (to - from) / 2]; // середина
        //int pivot = array[from]; // начало
        //int pivot = array[to]; // конец

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

