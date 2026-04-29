package new_sort_alg;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public static long C = 0; // Сравнения
    public static long M = 0; // Пересылки

    public static void main(String[] args) {
        double alpha = 2.8;
        System.out.println("Размер" + "    " + "Сумма пересылок и сравнений");
        for (int size = 100000; size < 100000000; size+= 100000) {
            for (int iteraions =0; iteraions < 100; iteraions++) {
                int[] arr = new int[size];
                generate_random_array(arr);
                shellsort(arr, alpha);
            }
            System.out.println(size +"    " + (C+M));
            C = 0;
            M = 0;
        }
    }

    public static void FindAlpha() {
        Random rand = new Random();
        int length = 32768;
        int[] original_array = new int[length];

        for (int i = 0; i < length; i++) {
            original_array[i] = rand.nextInt(10000);
        }

        System.out.println("Тест сортировки Шелла");
        double[] alphas = {1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0, 2.2, 2.4, 2.6, 2.7, 2.8, 2.9, 3.0};
        for (double alpha : alphas) {
            C = 0;
            M = 0;
            int[] copyArr = original_array.clone();
            for (int iterations = 0; iterations<1000; iterations++ ) {
                shellsort(copyArr, alpha);
                generate_random_array(copyArr);
                System.out.println(Arrays.toString(copyArr));

            }
            System.out.println("Alpha " + alpha + " Сравнений " + C + " Пересылок " + M + " Общий " + (C+M));

        }

    }
    public static void generate_random_array(int[] array){
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10000);
        }
    }
    public static void shellsort(int[] arr, double alpha) {
        int n = arr.length;

        int gap = (int)(n / alpha);

        // Shell (gap > 1)
        while (gap > 1) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                M++;

                int j = i;

                while (j >= gap && arr[j - gap] > temp) {
                    C++;
                    arr[j] = arr[j - gap];
                    M++;
                    j -= gap;
                }

                if (j >= gap) C++; // учёт последнего сравнения

                arr[j] = temp;
                M++;
            }

            gap = (int)(gap / alpha);
            if (gap < 1) gap = 1;
        }

        // вставки
        gap = 1;

        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            M++;

            int j = i;

            while (j >= gap && arr[j - gap] > temp) {
                C++;
                arr[j] = arr[j - gap];
                M++;
                j -= gap;
            }

            if (j >= gap) C++;

            arr[j] = temp;
            M++;
        }
    }
}

