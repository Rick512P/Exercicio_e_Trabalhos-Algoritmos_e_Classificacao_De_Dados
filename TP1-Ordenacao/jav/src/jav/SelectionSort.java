package jav;

public class SelectionSort {

    public static void main(String[] args) {
        Integer[] arr = {64, 25, 12, 22, 11, 90, 33, 50};

        System.out.println("Array antes da ordenação:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Encontra o índice do menor elemento no subarray arr[i..n-1]
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Troca o elemento de arr[minIndex] com o elemento de arr[i]
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
