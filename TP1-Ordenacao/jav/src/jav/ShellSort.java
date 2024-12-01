package jav;

public class ShellSort {

    public static void main(String[] args) {
        Integer[] arr = {64, 25, 12, 22, 11, 90, 33, 50};

        System.out.println("Array antes da ordenação:");
        printArray(arr);

        shellSort(arr);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int n = arr.length;

        // Começa com um gap grande e reduz o gap progressivamente
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Realiza a ordenação por inserção nos subarrays definidos pelo gap
            for (int i = gap; i < n; i++) {
                T temp = arr[i];
                int j;

                // Desloca elementos do subarray até que arr[j - gap] <= temp
                for (j = i; j >= gap && arr[j - gap].compareTo(temp) > 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
