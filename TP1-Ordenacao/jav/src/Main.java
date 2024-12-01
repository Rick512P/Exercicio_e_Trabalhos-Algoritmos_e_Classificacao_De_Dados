import jav.BubbleSort;
import jav.BucketSort;
import jav.CountingSort;
import jav.InsertionSort;
import jav.SelectionSort;
import jav.ShellSort;
import jav.HeapSort;
import jav.MergeSort;
import jav.QuickSort;
import jav.QuickSortDesc;
import jav.RadixSort;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 10;
        Scanner scanner = new Scanner(System.in);
        int[] sizes;
        System.out.println("Seja Bem Vindo");
        while (x != 0) {
            System.out.println("\n1: Ordenação Aleatória\n2: Ordenação com vetor ordenado -> Crescente e Decrescente\n0: Sair");
            x = scanner.nextInt();
            switch (x) {
                case 1:
                    System.out.println("\n=== Vetores aleatórios em ordem aleatória ===");
                    sizes = new int[]{100, 1000, 10000, 100000, 1000000}; // Tamanhos de vetor para teste
                    for (int size : sizes) {
                        System.out.println("\nTamanho do Vetor: " + size);

                        // Para cada tamanho, gerar 30 vetores aleatórios
                        Integer[][] randomArrays = new Integer[30][];
                        for (int i = 0; i < 30; i++) {
                            randomArrays[i] = generateRandomArray(size);
                        }
            
                        // Testar com vetores em ordem crescente
                        testAllAlgorithmsWithAverage(randomArrays, "");
                    }
                    break;
                case 2:
                    sizes = new int[]{1000, 100000}; // Tamanhos de vetor para teste

                    for (int size : sizes) {
                        System.out.println("\nTamanho do Vetor: " + size);
            
                        // Para cada tamanho, gerar 30 vetores aleatórios
                        Integer[][] randomArrays = new Integer[30][];
                        for (int i = 0; i < 30; i++) {
                            randomArrays[i] = generateRandomArray(size);
                        }
            
                        // Testar com vetores em ordem crescente
                        System.out.println("\n=== Vetores em Ordem Crescente ===");
                        testAllAlgorithmsWithAverage(randomArrays, "ascending");
            
                        // Testar com vetores em ordem decrescente
                        System.out.println("\n=== Vetores em Ordem Decrescente ===");
                        testAllAlgorithmsWithAverage(randomArrays, "descending");
                    }
                    break;
                case 0:
                default:
                    break;
            }
        }
        scanner.close();
    }

    public static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    public static <T extends Comparable<T>> void testAllAlgorithmsWithAverage(T[][] arrays, String type) {
        double bubbleSortTotalTime = 0, insertionSortTotalTime = 0, selectionSortTotalTime = 0;
        double shellSortTotalTime = 0, heapSortTotalTime = 0, mergeSortTotalTime = 0;
        double quickSortTotalTime = 0, countingSortTotalTime = 0, radixSortTotalTime = 0;
        double bucketSortTotalTime = 0;

        for (int i = 0; i < 30; i++) {
            T[] arrCopy = arrays[i].clone();
            if (type.equals("ascending")) {
                QuickSort.quickSort(arrCopy, 0, arrCopy.length - 1);
            } else if (type.equals("descending")) {
                QuickSortDesc.quickSort(arrCopy, 0, arrCopy.length - 1);
            }
            bubbleSortTotalTime += testSortingAlgorithm("BubbleSort", arrCopy.clone());
            insertionSortTotalTime += testSortingAlgorithm("InsertionSort", arrCopy.clone());
            selectionSortTotalTime += testSortingAlgorithm("SelectionSort", arrCopy.clone());
            shellSortTotalTime += testSortingAlgorithm("ShellSort", arrCopy.clone());
            heapSortTotalTime += testSortingAlgorithm("HeapSort", arrCopy.clone());
            mergeSortTotalTime += testSortingAlgorithm("MergeSort", arrCopy.clone());
            quickSortTotalTime += testSortingAlgorithm("QuickSort", arrCopy.clone());
            countingSortTotalTime += testCountingSort((Integer[]) arrays[i].clone());  // Chamada específica para CountingSort
            radixSortTotalTime += testSortingAlgorithm("RadixSort", arrCopy.clone());
            bucketSortTotalTime += testSortingAlgorithm("BucketSort", arrCopy.clone());
        }

        System.out.printf("\nMédia para BubbleSort: %.6f segundos.%n", bubbleSortTotalTime / 30);
        System.out.printf("Média para InsertionSort: %.6f segundos.%n", insertionSortTotalTime / 30);
        System.out.printf("Média para SelectionSort: %.6f segundos.%n", selectionSortTotalTime / 30);
        System.out.printf("Média para ShellSort: %.6f segundos.%n", shellSortTotalTime / 30);
        System.out.printf("Média para HeapSort: %.6f segundos.%n", heapSortTotalTime / 30);
        System.out.printf("Média para MergeSort: %.6f segundos.%n", mergeSortTotalTime / 30);
        System.out.printf("Média para QuickSort: %.6f segundos.%n", quickSortTotalTime / 30);
        System.out.printf("Média para CountingSort: %.6f segundos.%n", countingSortTotalTime / 30);
        System.out.printf("Média para RadixSort: %.6f segundos.%n", radixSortTotalTime / 30);
        System.out.printf("Média para BucketSort: %.6f segundos.%n", bucketSortTotalTime / 30);
    }

    public static <T extends Comparable<T>> double testSortingAlgorithm(String algorithmName, T[] arr) {
        long startTime;
        long endTime;

        switch (algorithmName) {
            case "BubbleSort":
                startTime = System.nanoTime();
                BubbleSort.bubbleSort(arr);
                endTime = System.nanoTime();
                break;
            case "InsertionSort":
                startTime = System.nanoTime();
                InsertionSort.insertionSort(arr);
                endTime = System.nanoTime();
                break;
            case "SelectionSort":
                startTime = System.nanoTime();
                SelectionSort.selectionSort(arr);
                endTime = System.nanoTime();
                break;
            case "ShellSort":
                startTime = System.nanoTime();
                ShellSort.shellSort(arr);
                endTime = System.nanoTime();
                break;
            case "HeapSort":
                startTime = System.nanoTime();
                HeapSort.heapSort(arr);
                endTime = System.nanoTime();
                break;
            case "MergeSort":
                startTime = System.nanoTime();
                MergeSort.mergeSort(arr, 0, arr.length - 1);
                endTime = System.nanoTime();
                break;
            case "QuickSort":
                startTime = System.nanoTime();
                QuickSort.quickSort(arr, 0, arr.length - 1);
                endTime = System.nanoTime();
                break;
            case "RadixSort":
                startTime = System.nanoTime();
                RadixSort.radixSort(arr);
                endTime = System.nanoTime();
                break;
            case "BucketSort":
                startTime = System.nanoTime();
                BucketSort.bucketSort(arr);
                endTime = System.nanoTime();
                break;
            default:
                System.out.println("Algoritmo não encontrado.");
                return 0.0;
        }

        return (endTime - startTime) / 1_000_000_000.0;
    }

    public static double testCountingSort(Integer[] arr) {
        long startTime = System.nanoTime();
        CountingSort.countingSort(arr);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0;
    }
}
