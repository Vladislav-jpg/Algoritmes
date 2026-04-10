package sort_alg;

import java.util.Random;

public class ShakerSort {
    public static void main(String[] args) {
        int iterations = 500;
        Random random = new Random();

        System.out.println("count" + "    " + "average time");
        for (int count = 1000; count < 10000; count += 1000){
            long totaltime = 0;
            for (int rep = 0; rep < iterations; rep++){
                int[] array = new int[count];
                for (int i = 0; i < count; i++){
                    array[i] = random.nextInt(100);
                }
                long start = System.nanoTime();
                shakerSort(array);
                totaltime += System.nanoTime() - start;
            }
            System.out.println(count + "    " + totaltime / iterations);

        }
    }
    public static void shakerSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for  (int i = left; i <= right - 1; i++) {
                if  (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            right--;

            for (int i = right - 1; i>= left; i--) {
                if  (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            left++;
        }
    }
}
