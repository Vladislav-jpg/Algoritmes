package sort_alg;

import java.util.Random;

public class OddEvenSort {
    public static void main(String[] args) {
        int iterations = 500;
        Random random = new Random();

        System.out.println("count" + "    " + "average time");
        for (int count = 1000; count < 10000; count += 1000){
            long totaltime = 0;
            for (int rep = 0; rep < iterations; rep++){
                int[] array = new int[count];
                for (int i = 0; i < count; i++){
                    array[i] = random.nextInt();
                }
                long start = System.nanoTime();
                oddEvenSort(array);
                totaltime += System.nanoTime() - start;
            }
            System.out.println(count + "    " + totaltime / iterations);

        }
    }
    public static void oddEvenSort(int[] arr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            //нечетная фаза
            for (int i = 1; i < arr.length - 1; i+=2) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            //четная фаза
            for (int i = 0; i < arr.length - 1; i+=2) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }

        }
    }
}
