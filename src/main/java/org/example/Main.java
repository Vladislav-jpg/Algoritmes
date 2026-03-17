package org.example;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int randNum =  new Random().nextInt(100);
        int[] arr =  new int[randNum];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10);
        }
        int key = new Random().nextInt(10);
        System.out.println(Arrays.toString(arr));
        System.out.println(key);
        System.out.println(LinearSearch(arr, key));

    }
    public static int LinearSearchWall(int[] arr, int key){
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = key;
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
}