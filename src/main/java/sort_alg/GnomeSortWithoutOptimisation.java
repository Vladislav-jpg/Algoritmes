package sort_alg;

import java.util.Arrays;
import java.util.Random;

public class GnomeSortWithoutOptimisation {
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
                gnomesortwithoutoptimisation(array);
                totaltime += System.nanoTime() - start;
            }
            System.out.println(count + "    " + totaltime / iterations);

        }
    }
    static void gnomesortwithoutoptimisation(int[] arr){
        int i = 1;
        while (i < arr.length){
            if (i == 0 || arr[i - 1] <= arr[i]){
                i++;
            }
            else {
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                i--;
            }
        }
    }

    static void gnomesortwithOptimisation(int[] arr){
        int i = 1;
        int j = 2;
        while (i < arr.length) {
            if (i == 0){
                i = j;
                j ++;
            }
            else if (arr[i-1] <= arr[i]) {
                i = j;
                j++;
            }
            else {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }
}
