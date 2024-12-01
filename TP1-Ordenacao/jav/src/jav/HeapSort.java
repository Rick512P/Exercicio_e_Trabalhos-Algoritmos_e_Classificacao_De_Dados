package jav;

public class HeapSort {

    public static void main(String[] args) {
        Integer[] arr = {64, 25, 12, 22, 11, 90, 33, 50};

        System.out.println("Array antes da ordenação:");
        printArray(arr);

        heapSort(arr);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        int n = arr.length;

        // Constrói o heap (reorganiza o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrai um elemento do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o final
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Chama heapify na heap reduzida
            heapify(arr, i, 0);
        }
    }

    // Para reorganizar o subárvore enraizada no nó i
    // n é o tamanho do heap
    public static <T extends Comparable<T>> void heapify(T[] arr, int n, int i) {
        int largest = i; // Inicializa o maior como raiz
        int left = 2 * i + 1; // Filho à esquerda
        int right = 2 * i + 2; // Filho à direita

        // Se o filho à esquerda é maior que a raiz
        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        // Se o filho à direita é maior que o maior atual
        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        // Se o maior não é a raiz
        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente reorganiza a subárvore afetada
            heapify(arr, n, largest);
        }
    }

    public static <T> void printArray(T[] arr) {
        for (T elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
