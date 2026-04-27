package new_sort_alg;

import java.util.Random;

public class ShellSortCustomOneGap {
    public static long C = 0; // Сравнения
    public static long M = 0; // Пересылки

    public static void main(String[] args) {
        Random rand = new Random();
        int length = 32768;
        int[] original_array = new int[length];

        for (int i = 0; i < length; i++) {
            original_array[i] = rand.nextInt(10000);
        }

        System.out.println("Shell с одним gap (моя версия)");

        C = 0;
        M = 0;

        int[] copyArr = original_array.clone();
        shellsort(copyArr);

        System.out.println("Сравнений " + C);
        System.out.println("Пересылок " + M);
        System.out.println("Общий " + (C + M));
    }

    public static void shellsort(int[] arr) {
        int n = arr.length;

        // 🔥 фиксированный i
        int i = 10;

        // формула
        int gap = (int)(9 * Math.pow(2, i) - 9 * Math.pow(2, i / 2.0) + 1);

        // чтобы не вышел за границы
        if (gap >= n) gap = n / 2;
        if (gap < 1) gap = 1;

        // один проход с этим gap
        for (int j = gap; j < n; j++) {
            int temp = arr[j];
            M++;

            int k = j;
            while (k >= gap) {
                C++;
                if (arr[k - gap] > temp) {
                    arr[k] = arr[k - gap];
                    M++;
                    k -= gap;
                } else {
                    break;
                }
            }

            arr[k] = temp;
            M++;
        }

        // 🔥 обязательно добиваем gap = 1
        gap = 1;
        for (int j = gap; j < n; j++) {
            int temp = arr[j];
            M++;

            int k = j;
            while (k >= gap) {
                C++;
                if (arr[k - gap] > temp) {
                    arr[k] = arr[k - gap];
                    M++;
                    k -= gap;
                } else {
                    break;
                }
            }

            arr[k] = temp;
            M++;
        }
    }
}