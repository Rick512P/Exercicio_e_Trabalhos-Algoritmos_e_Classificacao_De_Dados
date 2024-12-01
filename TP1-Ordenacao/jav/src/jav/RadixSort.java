package jav;

public class RadixSort {

    public static void main(String[] args) {
        Integer[] arr = {64, 25, 12, 22, 11, 90, 33, 50};

        System.out.println("Array antes da ordenação:");
        printArray(arr);

        radixSort(arr);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    // Função principal do Radix Sort
    public static <T extends Comparable<T>> void radixSort(T[] arr) {
        if (arr.length == 0) {
            return;
        }

        // Encontra o maior número para saber o número de dígitos
        T max = getMax(arr);

        // Executa o Counting Sort para cada dígito, começando pelo menos significativo
        for (int exp = 1; getMaxExp(max, exp) > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    // Função auxiliar para encontrar o maior número no array
    private static <T extends Comparable<T>> T getMax(T[] arr) {
        T max = arr[0];
        for (T num : arr) {
            if (num.compareTo(max) > 0) {
                max = num;
            }
        }
        return max;
    }

    // Função auxiliar para obter o número de dígitos no maior número
    private static <T extends Comparable<T>> int getMaxExp(T max, int exp) {
        return Integer.parseInt(max.toString()) / exp;
    }

    // Função de Counting Sort aplicada a um dígito específico
    private static <T extends Comparable<T>> void countingSortByDigit(T[] arr, int exp) {
        int n = arr.length;
        T[] output = (T[]) new Comparable[n]; // Array de saída para armazenar o resultado temporário
        int[] count = new int[10]; // Array de contagem para os dígitos (0 a 9)

        // Conta as ocorrências dos dígitos
        for (int i = 0; i < n; i++) {
            int digit = (Integer.parseInt(arr[i].toString()) / exp) % 10;
            count[digit]++;
        }

        // Modifica count para que ele contenha a posição de cada dígito no array de saída
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída
        for (int i = n - 1; i >= 0; i--) {
            int digit = (Integer.parseInt(arr[i].toString()) / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copia o array de saída para arr, ordenando os números pelo dígito atual
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Método para exibir o array
    public static <T extends Comparable<T>> void printArray(T[] arr) {
        for (T num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
