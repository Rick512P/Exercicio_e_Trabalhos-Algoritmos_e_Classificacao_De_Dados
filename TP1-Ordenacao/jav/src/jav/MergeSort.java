package jav;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] arr = {64, 25, 12, 22, 11, 90, 33, 50};

        System.out.println("Array antes da ordenação:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            // Encontra o meio do array
            int middle = left + (right - left) / 2;

            // Ordena a primeira e a segunda metade
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Junta as duas metades ordenadas
            merge(arr, left, middle, right);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int left, int middle, int right) {
        // Tamanhos dos subarrays para combinar
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arrays temporários
        T[] L = (T[]) new Comparable[n1];
        T[] R = (T[]) new Comparable[n2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        // Índices iniciais dos subarrays e do array combinado
        int i = 0, j = 0;
        int k = left;

        // Junta os arrays L e R de volta no array original
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de L, se houver algum
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de R, se houver algum
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static <T> void printArray(T[] arr) {
        for (T elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
