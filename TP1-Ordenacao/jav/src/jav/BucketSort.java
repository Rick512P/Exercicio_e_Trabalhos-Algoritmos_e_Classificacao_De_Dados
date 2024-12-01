package jav;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static <T extends Comparable<T>> void bucketSort(T[] arr) {
        T max = findMax(arr);
        T min = findMin(arr);

        int numBuckets = (int) Math.sqrt(arr.length);
        ArrayList<T>[] buckets = new ArrayList[numBuckets];

        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribui os elementos nos buckets, ajustando para o intervalo correto
        for (T num : arr) {
            int bucketIndex = (int) (((double) (num.compareTo(min))) / (max.compareTo(min) + 1) * numBuckets);
            buckets[bucketIndex].add(num);
        }

        // Ordena cada bucket e concatena no array original
        int index = 0;
        for (ArrayList<T> bucket : buckets) {
            Collections.sort(bucket);
            for (T num : bucket) {
                arr[index++] = num;
            }
        }
    }

    private static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];
        for (T num : arr) {
            if (num.compareTo(max) > 0) max = num;
        }
        return max;
    }

    private static <T extends Comparable<T>> T findMin(T[] arr) {
        T min = arr[0];
        for (T num : arr) {
            if (num.compareTo(min) < 0) min = num;
        }
        return min;
    }

    public static void main(String[] args) {
        // Exemplo com Integer, que implementa Comparable<Integer>
        Integer[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Array antes da ordenação:");
        printArray(arr);

        bucketSort(arr);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    // Método genérico para imprimir o array
    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
