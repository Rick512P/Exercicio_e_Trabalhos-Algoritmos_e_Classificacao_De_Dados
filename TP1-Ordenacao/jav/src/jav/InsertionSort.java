package jav;

public class InsertionSort {

    public static void main(String[] args) {
        Integer[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array antes da ordenação:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;

            // Move elementos de arr[0..i-1] que são maiores que key
            // para uma posição à frente de sua posição atual
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static <T> void printArray(T[] arr) {
        for (T elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
