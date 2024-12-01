package jav;

public class BubbleSort {
    public static void main(String[] args) {
        // Exemplo com Integer, que implementa Comparable<Integer>
        Integer[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Array antes da ordenação:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    // Método de ordenação genérico usando Comparable
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Usa compareTo para comparar elementos
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Troca arr[j] e arr[j+1]
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Método genérico para imprimir o array
    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}