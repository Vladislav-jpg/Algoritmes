package new_sort_alg;

import java.util.Random;

public class CombSort {
    public static long C = 0; // Сравнения
    public static long M = 0; // Пересылки

    public static void main(String[] args) {
        Random rand = new Random();
        int length = 32768; // 2^15
        int[] original_array = new int[length];

        for (int i = 0; i < length; i++) {
            original_array[i] = rand.nextInt(10000);
        }

        System.out.println("Тест сортировки расчёской");


        for (double alpha = 1.1; alpha <= 2.9; alpha += 0.01) {
            C = 0;
            M = 0;
            int[] copyArr = original_array.clone();

            combSort(copyArr, alpha);

            System.out.println(alpha + "  " + (C + M));
        }

    }

    public static void combSort(int[] arr, double alpha) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;

        while (gap > 1 || swapped) {
            // Уменьшаем шаг
            gap = (int) (gap / alpha);
            if (gap < 1) gap = 1;

            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                C++;
                if (arr[i] > arr[i + gap]) {
                    // Обмен элементами
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    M += 3; // Стандартный swap = 3 пересылки
                    swapped = true;
                }
            }
        }
    }
}