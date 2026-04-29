package new_sort_alg;

import java.util.Random;

public class HybridShellSort {
    public static long C = 0; // Сравнения
    public static long M = 0; // Пересылки

    public static void main(String[] args) {
        double alpha = 1.7;
        System.out.println("Размер" + "    " + "Сумма пересылок и сравнений");
        for (int size = 100000; size < 100000000; size+= 100000) {
            for (int iteraions =0; iteraions < 100; iteraions++) {
                int[] arr = new int[size];
                generate_random_array(arr);
                hybridShellSort(arr, alpha);
            }
            System.out.println(size +"    " + (C+M));
            C = 0;
            M = 0;
        }
    }

    public static void findAlpha() {
        Random rand = new Random();
        int length = 32768;
        int[] original_array = new int[length];

        for (int i = 0; i < length; i++) {
            original_array[i] = rand.nextInt(10000);
        }

        System.out.println("Гибридная сортировка (Shell + вставки)");

        double[] alphas = {1.3, 1.5, 1.6, 1.7, 2.0}; // 1.7 лучшая

        for (double alpha : alphas) {
            C = 0;
            M = 0;

            int[] copyArr = original_array.clone();

            for (int iterations = 0; iterations < 1000; iterations++) {
                hybridShellSort(copyArr, alpha);
                generate_random_array(copyArr);
            }

            System.out.println("Alpha " + alpha +
                    " Сравнений " + C +
                    " Пересылок " + M +
                    " Общий " + (C + M));
        }
    }

    public static void generate_random_array(int[] array) {
        ShellSort.generate_random_array(array);
    }

    public static void hybridShellSort(int[] arr, double alpha) {
        int n = arr.length;

        int gap = (int) (n / alpha);

        //  Shell sort
        while (gap > 10) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                M++;

                int j = i;
                while (j >= gap) {
                    C++;
                    if (arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        M++;
                        j -= gap;
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
                M++;
            }
            gap = (int) (gap / alpha);
        }

        //  вставки (gap = 1)
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            M++;

            int j = i;
            while (j > 0) {
                C++;
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    M++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j] = temp;
            M++;
        }
    }
}