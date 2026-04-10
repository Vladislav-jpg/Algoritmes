package sort_alg;
import java.util.Random;
public class BubbleSort {
    public static void main(String[] args) {
        int iterations = 500;
        Random random = new Random();
        System.out.println("count" + "    " + "average time");
        for (int count = 1000; count < 10000; count += 1000) {
            int[] arr = new int[count];
            long totaltime = 0;
            for (int rep = 0; rep < iterations; rep++) {
                for (int i = 0; i < count; i++) {
                    arr[i] = random.nextInt(100);
                }
                long start = System.nanoTime();
                bubbleSort(arr);
                totaltime += System.nanoTime() - start;
            }

            System.out.println(count + "    " + totaltime/iterations);


        }
    }

    public static void bubbleSort(int[] array){
        for(int j=0;j<array.length;j++){
            boolean flag = false;
            for(int k=0;k<array.length-j - 1;k++){
                if(array[k]>array[k+1]){
                    int temp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
