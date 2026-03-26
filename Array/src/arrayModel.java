import java.util.Random;
import java.util.Scanner;

public class arrayModel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introduction
        System.out.println("-------------------- Welcome to array model --------------------");
        System.out.println("Let's create an array first");

        // Length of the array from user
        int length;
        do {
            System.out.print("Enter the length of the array (max 30): ");
            length = scanner.nextInt();
            if (length < 0 || length > 30) {
                System.out.println("Invalid! Please enter between 0 to 30 (both inclusive)");
                System.out.println();
            }
        } while (length < 0 || length > 30);
        int[] array = new int[length];

        int elementType;
        do {
            System.out.println();
            System.out.println("1. Random elements");
            System.out.println("2. Enter elements");
            System.out.print("Choose an option from above: ");
            elementType = scanner.nextInt();
            if(elementType != 1 && elementType != 2) {
                System.out.println("Invalid! Please enter between 1 or 2");
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
        System.out.println("-------------------- Display Results --------------------");
        System.out.println("Length of the array: " + length);
        System.out.print("Array: ");
        System.out.println();
        displayArray(array);

        System.out.println();
        System.out.println("-------------------- Array algorithms --------------------");
        int operation;
        do {
            System.out.println("1. Search in an array");
            System.out.println("2. Sort an array");
            System.out.print("Choose an operation to perform on an array: ");
            operation = scanner.nextInt();
            if(operation != 1 && operation != 2) {
                System.out.println("Invalid! Please enter between 1 or 2");
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
        for (int i=0; i<array.length; i++) {
            System.out.print(" " + array[i] + " ");
        }
        System.out.println("]");
    }

    private static void searchAlgorithms() {
        System.out.println();
        System.out.println("-------------------- Searching Algorithms --------------------");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.println("3. Jump Search");
        System.out.println("4. Interpolation Search");
        System.out.println("5. Exponential Search");
    }

    private static void sortingAlgorithms() {
        System.out.println();
        System.out.println("-------------------- Sorting Algorithms --------------------");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Heap Sort");
        System.out.println("7. Counting Sort");
        System.out.println("8. Radix Sort");
        System.out.println("9. Shell Sort");
        System.out.println("10. Tim Sort (Java's default)");
    }
}