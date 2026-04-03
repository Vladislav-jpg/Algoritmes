package algFind;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int iterations = 5000;
        System.out.println("count" + "    " + "average time");
        for (int count = 1000; count < 10000; count += 1000) {
            int[] arr = new int[count];
            long totaltime = 0;
            for (int rep = 0; rep < iterations; rep++) {
                for (int i = 0; i < count; i++) {
                    arr[i] = rand.nextInt(10000);
                }
                int key = rand.nextInt(10000);
                Arrays.sort(arr);
                long start = System.nanoTime();
                int res = BinarySearch(arr, key);
                totaltime += System.nanoTime() - start;

                // чтобы JVM не оптимизировала код
                if (res == -200){
                    System.out.println();
                }

            }

            System.out.println(count + "    " + totaltime/iterations);
        }
    }


    public static int LinearSearchWall(int[] arr, int key){
        for (int i = 0; ; i++){
            if (arr[i] == key){
                return i;
            }
        }
    }

    public static int LinearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] arr, int key){
            int left = 0;
            int right = arr.length - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (arr[mid] == key){
                    return mid;
                }
                else if (arr[mid] < key){
                    left = mid + 1;
                }
                else if (arr[mid] > key){
                    right = mid - 1;
                }
            }
        return -1;
    }

    public static int RecBinarySearch(int[] arr, int key, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == key){
            return mid;
        }
        else if (arr[mid] < key){
            return RecBinarySearch(arr, key, left, mid - 1);
        }
        else if (arr[mid] > key){
            return RecBinarySearch(arr, key, mid + 1, right);
        }
        return -1;
    }
}