import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class arrayModel {

    // ANSI color constants
    static final String RESET        = "\u001B[0m";
    static final String RED          = "\u001B[31m";
    static final String GREEN        = "\u001B[32m";
    static final String BLUE         = "\u001B[34m";
    static final String BOLD         = "\u001B[1m";

    static int[] array;
    static int length;
    static int target;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introduction
        System.out.println(GREEN + "-------------------- Welcome to array model --------------------");
        System.out.println("Let's create an array first" + RESET);

        // Length of the array from user
        do {
            System.out.print("Enter the length of the array (max 30): ");
            length = scanner.nextInt();
            if (length < 0 || length > 30) {
                System.out.println(RED + "Invalid!" + RESET + " Please enter between 0 and 30 (both inclusive)");
                System.out.println();
            }
        } while (length < 0 || length > 30);
        array = new int[length];

        int elementType;
        do {
            System.out.println();
            System.out.println(GREEN + "1. Random elements");
            System.out.println("2. Enter elements" + RESET);
            System.out.print("Choose an option from above: ");
            elementType = scanner.nextInt();
            if(elementType != 1 && elementType != 2) {
                System.out.println(RED + "Invalid!" + RESET + "Please enter between 1 or 2");
                System.out.println();
            }
        } while (elementType != 1 && elementType != 2);
        if (elementType == 1) {
            for (int i=0; i<length; i++) {
                Random random = new Random();
                array[i] = random.nextInt(-200, 201);
            }
        } else {
            System.out.print("Enter the elements with a space apart (from -200 to 200): ");
            for (int i=0; i<length; i++) {
                array[i] = scanner.nextInt();
            }
        }

        System.out.println();
        System.out.println(BLUE + "-------------------- Display Results --------------------");
        System.out.println("Length of the array: " + length);
        System.out.print("Array: ");
        displayArray(array);

        System.out.println();
        System.out.println( RESET + GREEN + "-------------------- Array algorithms --------------------" + RESET);
        int operation;
        do {
            System.out.println(GREEN + "1. Search in an array");
            System.out.println("2. Sort an array" + RESET);
            System.out.print("Choose an operation to perform on an array: ");
            operation = scanner.nextInt();
            if(operation != 1 && operation != 2) {
                System.out.println(RED + "Invalid!" + RESET + "Please enter between 1 or 2");
                System.out.println();
            }
        } while (operation != 1 && operation != 2);
        if (operation == 1) {
            searchAlgorithms();
        } else {
            sortingAlgorithms();
        }
        scanner.close();
    }

    public static void displayArray(int[] array) {
        System.out.print("[");
        for (int j : array) {
            System.out.print(" " + j + " ");
        }
        System.out.println("]");
    }

    private static void searchAlgorithms() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the element you want search in the array: ");
        target = scanner.nextInt();
        System.out.println(GREEN);
        System.out.println("-------------------------------------------------- SEARCHING ALGORITHMS --------------------------------------------------");
        System.out.println();
        System.out.println("  #  |   Algorithm             |                Time Complexity              |   Space Complexity  |   Required Sorted ?  ");
        System.out.println("     |                         |    Best   |   Average       |   Worst       |                     |                      ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("  1  |   Linear Search         |    O(1)   |   O(n)          |   O(n)        |   O(1)              |    No                ");
        System.out.println("  2  |   Binary Search         |    O(1)   |   O(logn)       |   O(logn)     |   O(1) iterative    |    Yes               ");
        System.out.println("  3  |   Jump Search           |    O(1)   |   O(sqrt(n))    |   O(sqrt(n))  |   O(1)              |    Yes               ");
        System.out.println("  4  |   Interpolation Search  |    O(1)   |   O(loglog n)   |   O(n)        |   O(1)              |    Yes               ");
        System.out.println("  5  |   Exponential Search    |    O(1)   |   O(logn)       |   O(logn)     |   O(logn)           |    Yes               ");
        System.out.println(RESET);
        int choice;
        do {
            System.out.print("Enter which algorithm you want to try: ");
            choice = scanner.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println(RED);
                System.out.println("Invalid!" + RESET + "Please enter the number associated to the algorithm in the table");
            }
        } while (choice < 1 || choice > 5);
        int index = -1;
        switch (choice) {
            case 1:
                index = linearSearch();
                break;
            case 2:
                index = binarySearch();
                break;
            case 3:
                index = jumpSearch();
                break;
            case 4:
                index = interpolationSearch();
                break;
            case 5:
                index = exponentialSearch();
                break;
            default:
                break;
        }
        if (index == -1) {
            System.out.println(RED + "Element not found" + RESET);
        } else {
            System.out.println(BLUE + "Element found at " + index + "th index" + RESET);
        }
        scanner.close();
    }

    private static void sortingAlgorithms() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN);
        System.out.println("-------------------------------------------------- SORTING ALGORITHMS ----------------------------------------------------------");
        System.out.println();
        System.out.println("  #   |   Algorithm                  |                Time Complexity             |   Space Complexity  |  Stable  |  In-place  ");
        System.out.println("      |                              |   Best      |    Average    |   Worst      |                     |                       ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("  1   |   Bubble Sort                |   O(n)      |    O(n^2)     |   O(n^2)     |    O(1)             |   Yes    |   Yes      ");
        System.out.println("  2   |   Selection Sort             |   O(n^2)    |    O(n^2)     |   O(n^2)     |    O(1)             |   No     |   Yes      ");
        System.out.println("  3   |   Insertion Sort             |   O(n)      |    O(n^2)     |   O(n^2)     |    O(1)             |   Yes    |   Yes      ");
        System.out.println("  4   |   Merge Sort                 |   O(nlogn)  |    O(nlogn)   |   O(nlogn)   |    O(n)             |   Yes    |   No       ");
        System.out.println("  5   |   Quick Sort                 |   O(nlogn)  |    O(nlogn)   |   O(n^2)     |    O(logn)          |   No     |   Yes      ");
        System.out.println("  6   |   Heap Sort                  |   O(nlogn)  |    O(nlogn)   |   O(nlogn)   |    O(1)             |   No     |   Yes      ");
        System.out.println("  7   |   Counting Sort              |   O(n+k)    |    O(n+k)     |   O(n+k)     |    O(n+k)           |   Yes    |   No       ");
        System.out.println("  8   |   Radix Sort                 |   O(nk)     |    O(nk)      |   O(nk)      |    O(n+b)           |   Yes    |   No       ");
        System.out.println("  9   |   Shell Sort                 |   O(nlogn)  |    It varies  |   O(n^2)     |    O(1)             |   No     |   Yes      ");
        System.out.println("  10  |   Tim Sort (Java's default)  |   O(n)      |    O(nlogn)   |   O(nlogn)   |    O(n)             |   Yes    |   No       ");
        System.out.println(RESET);
        int choice;
        do {
            System.out.print("Enter which algorithm you want to try: ");
            choice = scanner.nextInt();
            if (choice < 1 || choice > 10) {
                System.out.println(RED);
                System.out.println("Invalid!" + RESET + "Please enter the number associated to the algorithm in the table");
            }
        } while (choice < 1 || choice > 10);
        switch (choice) {
            case 1:
                bubbleSort();
                break;
            case 2:
                selectionSort();
                break;
            case 3:
                insertionSort();
                break;
            case 4:
                mergeSort();
                break;
            case 5:
                quickSort();
                break;
            case 6:
                heapSort();
                break;
            case 7:
                countingSort();
                break;
            case 8:
                radixSort();
                break;
            case 9:
                shellSort();
                break;
            case 10:
                timSort();
                break;
            default:
                break;
        }
        scanner.close();
    }

    // Searching algorithms
    private static int linearSearch() {
        System.out.println(GREEN);
        System.out.println("------------------------------ LINEAR SEARCH ------------------------------");
        System.out.println("Concept: Check each element one by one from left to right until the target is found or the array ends.");
        System.out.println(RESET);
        // Algorithm
        for(int i=0; i<array.length; i++) {
            if(array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch() {
        System.out.println(GREEN);
        System.out.println("------------------------------ BINARY SEARCH ------------------------------");
        System.out.println("Concept: Repeatedly divide the sorted array in half. Compare the target with the middle element.");
        System.out.println("         if equal, found");
        System.out.println("         if target is smaller, search the left half");
        System.out.println("         if target is larger, search the right half");
        System.out.println(RESET);
        // Algorithm
        Arrays.sort(array);
        System.out.print(BLUE + "Sorted array: ");
        displayArray(array);
        System.out.print(RESET);
        int low = 0, high = array.length - 1;
        while ( low <= high ) {
            int mid = low + (high - low) / 2;
            if(array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] array, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] < target) {
            return binarySearchRecursive(array, mid + 1, high, target);
        }
        return binarySearchRecursive(array, low, mid - 1, target);
    }

    private static int jumpSearch() {
        System.out.println(GREEN);
        System.out.println("------------------------------ JUMP SEARCH ------------------------------");
        System.out.println("Concept: Jump ahead by fixed steps of size sqrt(n).");
        System.out.println("         When a jump overshoots the target, do a linear search in the previous block.");
        System.out.println(RESET);
        // Algorithm
        Arrays.sort(array);
        System.out.print(BLUE + "Sorted array: ");
        displayArray(array);
        System.out.print(RESET);
        int n = array.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;
        while (array[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1;
        }
        while (array[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }
        return (array[prev] == target) ? prev : -1;
    }

    private static int interpolationSearch() {
        System.out.println(GREEN);
        System.out.println("------------------------------ INTERPOLATION SEARCH ------------------------------");
        System.out.println("Concept: Improvement over binary search for uniformly distributed data.");
        System.out.println("         Instead of checking the middle, it estimates the position of the target using interpolation formula.");
        System.out.println(RESET);
        // Algorithm
        Arrays.sort(array);
        System.out.print(BLUE + "Sorted array: ");
        displayArray(array);
        System.out.print(RESET);
        int low = 0, high = array.length - 1;
        while (low <= high && target >= array[low] && target <= array[high]) {
            if (low == high) {
                if (array[low] == target) {
                    return low;
                }
                return -1;
            }
            int pos = low + ((target - array[low]) * (high -low)) / (array[high] - array[low]);
            if (array[pos] == target) {
                return pos;
            }
            if (array[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return -1;
    }

    private static int exponentialSearch() {
        System.out.println(GREEN);
        System.out.println("------------------------------ EXPONENTIAL SEARCH ------------------------------");
        System.out.println("Concept: Find the range where the target might exist (by doubling the index), then apply binary search within that range.");
        System.out.println("         Useful for unbounded/infinite arrays.");
        System.out.println(RESET);
        // Algorithm
        Arrays.sort(array);
        System.out.print(BLUE + "Sorted array: ");
        displayArray(array);
        System.out.print(RESET);
        if (array[0] == target) {
            return 0;
        }
        int i = 1;
        while (i < array.length && array[i] <= target) {
            i *= 2;
        }
        return binarySearchRecursive(array, i / 2, Math.min(i, array.length - 1), target);
    }

    // Sorting algorithms
    private static void bubbleSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ BUBBLE SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }

    private static void selectionSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ SELECTION SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }

    private static void insertionSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ INSERTION SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }

    private static void mergeSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ MERGE SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }

    private static void quickSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ QUICK SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }

    private static void heapSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ HEAP SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }

    private static void countingSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ COUNTING SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }

    private static void radixSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ RADIX SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }

    private static void shellSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ SHELL SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }

    private static void timSort() {
        System.out.println(GREEN);
        System.out.println("------------------------------ TIM SORT ------------------------------");
        System.out.println("Concept: ");
        System.out.println(RESET);
    }
}