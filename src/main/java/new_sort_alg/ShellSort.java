package new_sort_alg;

import java.util.Random;

public class ShellSort {
    public static long C = 0; // Сравнения
    public static long M = 0; // Пересылки

    public static void main(String[] args) {
        Random rand = new Random();
        int length = 32768;
        int[] original_array = new int[length];

        for (int i = 0; i < length; i++) {
            original_array[i] = rand.nextInt(10000);
        }

        System.out.println("Тест сортировки Шелла");
        double[] alphas = {2.0, 2.2, 2.4, 2.6};
        for (double alpha : alphas) {
            C = 0;
            M = 0;
            int[] copyArr = original_array.clone();
            shellsort(copyArr, alpha);
            System.out.println("Alpha " + alpha + " Сравнений " + C + " Пересылок " + M + " Общий " + (C+M));

        }

    }

    public static void shellsort(int[] arr, double alpha) {
        int n = arr.length;
        // Вариант 1а: изменение шага h = h / alpha
        for (int gap = (int)(n / alpha); gap > 0; gap = (int)(gap / alpha)) {

            // Сортировка вставками внутри шага
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                M++; // Пересылка в temp

                int j = i;
                while (j >= gap) {
                    C++; // Сравнение
                    if (arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        M++; // Пересылка при сдвиге
                        j -= gap;
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
                M++; // Пересылка из temp обратно
            }
        }
    }
}
