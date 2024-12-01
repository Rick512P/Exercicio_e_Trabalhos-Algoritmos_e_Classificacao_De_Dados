package jav;

public class CountingSort {

    public static void countingSort(Integer[] arr) {
        if (arr.length == 0) {
            return;
        }

        // Encontrar o maior e o menor valor no array para definir o intervalo
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Inicializar o array de contagem
        int range = max - min + 1;
        int[] count = new int[range];

        // Contar a frequência de cada valor no array original
        for (int num : arr) {
            count[num - min]++;
        }

        // Modificar o array original com os valores ordenados
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;  // Ajuste para obter o valor correto
                count[i]--;
            }
        }
    }

    // Método para exibir o array
    public static void printArray(Integer[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Exemplo com Integer
        Integer[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Array antes da ordenação:");
        printArray(arr);

        countingSort(arr);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }
}
