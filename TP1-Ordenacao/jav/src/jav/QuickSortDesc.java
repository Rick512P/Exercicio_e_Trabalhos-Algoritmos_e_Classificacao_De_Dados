package jav;

public class QuickSortDesc {

    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Mudança para ordenar de forma decrescente
            if (arr[j].compareTo(pivot) >= 0) { // Maior ou igual ao pivô
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {64, 25, 12, 22, 11, 90, 33, 50};

        System.out.println("Array antes da ordenação:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }
}
