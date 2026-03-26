# Java Arrays & Algorithms — Complete Reference Guide

---

## Table of Contents

1. [Arrays in Java — Core Concepts](#1-arrays-in-java--core-concepts)
2. [Array Declaration & Initialization](#2-array-declaration--initialization)
3. [Types of Arrays](#3-types-of-arrays)
4. [Array Operations](#4-array-operations)
5. [Java Arrays Class (java.util.Arrays)](#5-java-arrays-class-javautilarrays)
6. [Arrays as Method Parameters & Return Types](#6-arrays-as-method-parameters--return-types)
7. [Common Array Patterns & Techniques](#7-common-array-patterns--techniques)
8. [Searching Algorithms](#8-searching-algorithms)
9. [Sorting Algorithms](#9-sorting-algorithms)
10. [Algorithm Complexity Summary](#10-algorithm-complexity-summary)

---

## 1. Arrays in Java — Core Concepts

### What is an Array?
An array is a **fixed-size, contiguous block of memory** that stores elements of the **same data type**. Arrays in Java are objects, even when they store primitive types.

### Key Characteristics
- **Fixed size**: The length is set at creation and cannot change.
- **Zero-indexed**: Elements are accessed via indices starting at `0`.
- **Type-safe**: All elements must be the same type (or subtype for reference arrays).
- **Object nature**: Arrays inherit from `Object` class and have a `.length` field.
- **Default values**: Numeric arrays default to `0`, boolean to `false`, references to `null`.

### Memory Layout
```
Index:   [0]   [1]   [2]   [3]   [4]
         +-----+-----+-----+-----+-----+
Values:  | 10  | 20  | 30  | 40  | 50  |
         +-----+-----+-----+-----+-----+
```
Elements are stored in **contiguous memory locations**, enabling O(1) random access.

---

## 2. Array Declaration & Initialization

### Declaration
```java
int[] arr;          // Preferred style
int arr[];          // C-style (valid but discouraged)
String[] names;
double[] prices;
```

### Initialization — With `new`
```java
int[] arr = new int[5];           // [0, 0, 0, 0, 0]
String[] names = new String[3];   // [null, null, null]
```

### Initialization — With Literals
```java
int[] arr = {10, 20, 30, 40, 50};
String[] fruits = {"Apple", "Banana", "Cherry"};
```

### Anonymous Array (inline creation)
```java
printArray(new int[]{1, 2, 3, 4, 5});
```

### Accessing & Modifying Elements
```java
int[] arr = {10, 20, 30};
int x = arr[0];      // Read: x = 10
arr[2] = 99;         // Write: arr is now {10, 20, 99}
int len = arr.length; // Length field (not a method): 3
```

### ArrayIndexOutOfBoundsException
```java
int[] arr = new int[3];
arr[5] = 10; // Throws ArrayIndexOutOfBoundsException at runtime
```
Always validate indices: valid range is `0` to `arr.length - 1`.

---

## 3. Types of Arrays

### 3.1 Single-Dimensional Array
```java
int[] scores = {85, 90, 78, 92, 88};
```

### 3.2 Multi-Dimensional Arrays

#### 2D Array (Matrix)
```java
int[][] matrix = new int[3][4];          // 3 rows, 4 columns
int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9}};

// Access element at row 1, column 2
int val = grid[1][2]; // 6
```

#### Jagged Array (Ragged Array)
Each row can have a different number of columns:
```java
int[][] jagged = new int[3][];
jagged[0] = new int[2];   // Row 0 has 2 elements
jagged[1] = new int[4];   // Row 1 has 4 elements
jagged[2] = new int[1];   // Row 2 has 1 element
```

#### 3D Array
```java
int[][][] cube = new int[2][3][4]; // depth=2, rows=3, cols=4
```

### 3.3 Array of Objects
```java
class Student { String name; int grade; }

Student[] students = new Student[5];
students[0] = new Student();
students[0].name = "Alice";
```

---

## 4. Array Operations

### 4.1 Traversal

#### for loop
```java
int[] arr = {1, 2, 3, 4, 5};
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

#### Enhanced for-each loop
```java
for (int val : arr) {
    System.out.println(val);
}
// Note: Cannot modify elements or access index directly
```

#### Traversing a 2D Array
```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

### 4.2 Copying Arrays

#### Manual Copy
```java
int[] src = {1, 2, 3};
int[] dest = new int[src.length];
for (int i = 0; i < src.length; i++) dest[i] = src[i];
```

#### `System.arraycopy()` — Fastest
```java
// System.arraycopy(src, srcPos, dest, destPos, length)
System.arraycopy(src, 0, dest, 0, src.length);
```

#### `Arrays.copyOf()` — Returns new array
```java
int[] copy = Arrays.copyOf(src, src.length);
int[] extended = Arrays.copyOf(src, 10); // pads with 0s
```

#### `Arrays.copyOfRange()` — Slice
```java
int[] slice = Arrays.copyOfRange(arr, 1, 4); // index 1 to 3 (inclusive)
```

#### `clone()` — Shallow copy
```java
int[] clone = arr.clone();
```

> **Shallow vs Deep Copy**: For arrays of primitives, all copies are deep. For arrays of objects, copies are shallow — the references are copied, not the objects themselves.

### 4.3 Filling Arrays
```java
int[] arr = new int[5];
Arrays.fill(arr, 7);                 // [7, 7, 7, 7, 7]
Arrays.fill(arr, 1, 4, 99);         // [7, 99, 99, 99, 7]
```

### 4.4 Comparing Arrays
```java
int[] a = {1, 2, 3};
int[] b = {1, 2, 3};
System.out.println(a == b);             // false (different references)
System.out.println(Arrays.equals(a, b)); // true (element-wise comparison)

// For 2D arrays:
System.out.println(Arrays.deepEquals(matrix1, matrix2));
```

### 4.5 Converting Array to String
```java
int[] arr = {1, 2, 3};
System.out.println(Arrays.toString(arr));       // [1, 2, 3]
System.out.println(Arrays.deepToString(matrix)); // [[1, 2], [3, 4]]
```

---

## 5. Java Arrays Class (`java.util.Arrays`)

The `Arrays` class provides static utility methods:

| Method | Description |
|---|---|
| `Arrays.sort(arr)` | Sorts array in ascending order |
| `Arrays.sort(arr, from, to)` | Sorts a subarray |
| `Arrays.binarySearch(arr, key)` | Binary search (array must be sorted) |
| `Arrays.equals(a, b)` | Compares two arrays element-by-element |
| `Arrays.deepEquals(a, b)` | Deep comparison for multi-dimensional arrays |
| `Arrays.fill(arr, val)` | Fills all elements with a value |
| `Arrays.copyOf(arr, len)` | Copies array to new length |
| `Arrays.copyOfRange(arr, from, to)` | Copies a range |
| `Arrays.toString(arr)` | Returns string representation |
| `Arrays.deepToString(arr)` | Deep string for multi-dimensional arrays |
| `Arrays.stream(arr)` | Returns an IntStream / Stream |
| `Arrays.asList(arr)` | Converts to List (for object arrays) |

### Sorting with Comparator (Object Arrays)
```java
String[] words = {"banana", "apple", "cherry"};
Arrays.sort(words);                                      // natural order
Arrays.sort(words, (a, b) -> b.compareTo(a));           // reverse order
Arrays.sort(words, Comparator.comparingInt(String::length)); // by length
```

---

## 6. Arrays as Method Parameters & Return Types

```java
// Passing an array (passed by reference)
public static void doubleAll(int[] arr) {
    for (int i = 0; i < arr.length; i++) arr[i] *= 2;
}

// Returning an array
public static int[] createRange(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = i + 1;
    return arr;
}

// Varargs (variable-length argument list — internally an array)
public static int sum(int... nums) {
    int total = 0;
    for (int n : nums) total += n;
    return total;
}
sum(1, 2, 3);           // Works
sum(new int[]{1,2,3});  // Also works
```

---

## 7. Common Array Patterns & Techniques

### 7.1 Finding Min & Max
```java
int min = arr[0], max = arr[0];
for (int val : arr) {
    if (val < min) min = val;
    if (val > max) max = val;
}
```

### 7.2 Reversing an Array
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    int temp = arr[left];
    arr[left++] = arr[right];
    arr[right--] = temp;
}
```

### 7.3 Rotating an Array (Left by k)
```java
// Reverse technique: O(n) time, O(1) space
void rotate(int[] arr, int k) {
    k %= arr.length;
    reverse(arr, 0, k - 1);
    reverse(arr, k, arr.length - 1);
    reverse(arr, 0, arr.length - 1);
}
```

### 7.4 Two-Pointer Technique
```java
// Check if array is palindrome
int l = 0, r = arr.length - 1;
while (l < r) {
    if (arr[l] != arr[r]) { /* not palindrome */ break; }
    l++; r--;
}
```

### 7.5 Sliding Window
```java
// Maximum sum subarray of size k
int windowSum = 0;
for (int i = 0; i < k; i++) windowSum += arr[i];
int maxSum = windowSum;
for (int i = k; i < arr.length; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
}
```

### 7.6 Prefix Sum
```java
int[] prefix = new int[arr.length + 1];
for (int i = 0; i < arr.length; i++)
    prefix[i + 1] = prefix[i] + arr[i];

// Range sum query [l, r] in O(1)
int rangeSum = prefix[r + 1] - prefix[l];
```

### 7.7 Kadane's Algorithm (Maximum Subarray Sum)
```java
int maxSoFar = arr[0], maxEndingHere = arr[0];
for (int i = 1; i < arr.length; i++) {
    maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
    maxSoFar = Math.max(maxSoFar, maxEndingHere);
}
// maxSoFar = answer
```

### 7.8 Frequency Count with Hashing
```java
Map<Integer, Integer> freq = new HashMap<>();
for (int val : arr)
    freq.put(val, freq.getOrDefault(val, 0) + 1);
```

---

## 8. Searching Algorithms

---

### 8.1 Linear Search (Sequential Search)

**Concept**: Check each element one by one from left to right until the target is found or the array ends.

**Works on**: Unsorted or sorted arrays.

```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) return i; // Return index
    }
    return -1; // Not found
}
```

| Property | Value |
|---|---|
| Time — Best | O(1) — target is first element |
| Time — Worst | O(n) — target is last or absent |
| Time — Average | O(n) |
| Space | O(1) |
| Requires sorted? | No |

**When to use**: Small arrays, unsorted data, searching once.

---

### 8.2 Binary Search

**Concept**: Repeatedly divide the sorted array in half. Compare the target with the middle element — if equal, found; if target is smaller, search the left half; if larger, search the right half.

**Prerequisite**: Array must be **sorted**.

#### Iterative Version
```java
public static int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2; // Avoids integer overflow
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}
```

#### Recursive Version
```java
public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
    if (low > high) return -1;
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) return mid;
    if (arr[mid] < target) return binarySearchRecursive(arr, mid + 1, high, target);
    return binarySearchRecursive(arr, low, mid - 1, target);
}
```

#### Using Java's Built-in
```java
Arrays.sort(arr);
int index = Arrays.binarySearch(arr, target); // Returns index or negative if absent
```

| Property | Value |
|---|---|
| Time — Best | O(1) |
| Time — Worst | O(log n) |
| Time — Average | O(log n) |
| Space (iterative) | O(1) |
| Space (recursive) | O(log n) — call stack |
| Requires sorted? | **Yes** |

**When to use**: Large sorted arrays, repeated searches.

---

### 8.3 Jump Search

**Concept**: Jump ahead by fixed steps of size √n. When a jump overshoots the target, do a linear search in the previous block.

```java
public static int jumpSearch(int[] arr, int target) {
    int n = arr.length;
    int step = (int) Math.sqrt(n);
    int prev = 0;
    while (arr[Math.min(step, n) - 1] < target) {
        prev = step;
        step += (int) Math.sqrt(n);
        if (prev >= n) return -1;
    }
    while (arr[prev] < target) {
        prev++;
        if (prev == Math.min(step, n)) return -1;
    }
    return (arr[prev] == target) ? prev : -1;
}
```

| Property | Value |
|---|---|
| Time | O(√n) |
| Space | O(1) |
| Requires sorted? | Yes |

---

### 8.4 Interpolation Search

**Concept**: Improvement over binary search for uniformly distributed data. Instead of checking the middle, it estimates the position of the target using interpolation formula.

```java
public static int interpolationSearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high && target >= arr[low] && target <= arr[high]) {
        if (low == high) {
            if (arr[low] == target) return low;
            return -1;
        }
        int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);
        if (arr[pos] == target) return pos;
        if (arr[pos] < target) low = pos + 1;
        else high = pos - 1;
    }
    return -1;
}
```

| Property | Value |
|---|---|
| Time — Best/Average (uniform) | O(log log n) |
| Time — Worst | O(n) |
| Space | O(1) |
| Requires sorted? | Yes |

---

### 8.5 Exponential Search

**Concept**: Find the range where the target might exist (by doubling the index), then apply binary search within that range. Useful for unbounded/infinite arrays.

```java
public static int exponentialSearch(int[] arr, int target) {
    if (arr[0] == target) return 0;
    int i = 1;
    while (i < arr.length && arr[i] <= target) i *= 2;
    return binarySearchRecursive(arr, i / 2, Math.min(i, arr.length - 1), target);
}
```

| Property | Value |
|---|---|
| Time | O(log n) |
| Space | O(log n) |
| Requires sorted? | Yes |

---

## 9. Sorting Algorithms

---

### 9.1 Bubble Sort

**Concept**: Repeatedly step through the list, compare adjacent elements, and swap if out of order. Largest elements "bubble up" to the end.

```java
public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break; // Optimization: already sorted
    }
}
```

| Property | Value |
|---|---|
| Time — Best | O(n) — already sorted (with swap flag) |
| Time — Average | O(n²) |
| Time — Worst | O(n²) |
| Space | O(1) |
| Stable? | Yes |
| In-place? | Yes |

**When to use**: Educational purposes; small datasets; nearly-sorted arrays.

---

### 9.2 Selection Sort

**Concept**: Divide the array into sorted and unsorted parts. Repeatedly find the minimum element in the unsorted part and place it at the beginning of the unsorted part.

```java
public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) minIdx = j;
        }
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
}
```

| Property | Value |
|---|---|
| Time — All cases | O(n²) |
| Space | O(1) |
| Stable? | No |
| In-place? | Yes |

**When to use**: Small arrays; when memory writes are costly (minimal swaps: always n-1).

---

### 9.3 Insertion Sort

**Concept**: Build the sorted array one element at a time. For each element, find its correct position by shifting larger elements to the right.

```java
public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

| Property | Value |
|---|---|
| Time — Best | O(n) — already sorted |
| Time — Average | O(n²) |
| Time — Worst | O(n²) |
| Space | O(1) |
| Stable? | Yes |
| In-place? | Yes |

**When to use**: Small arrays; nearly-sorted data; online sorting (elements arriving one by one).

---

### 9.4 Merge Sort

**Concept**: Divide-and-conquer. Recursively split the array into two halves, sort each half, then merge the two sorted halves.

```java
public static void mergeSort(int[] arr, int left, int right) {
    if (left >= right) return;
    int mid = left + (right - left) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

private static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1, n2 = right - mid;
    int[] L = new int[n1], R = new int[n2];
    System.arraycopy(arr, left, L, 0, n1);
    System.arraycopy(arr, mid + 1, R, 0, n2);

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) arr[k++] = L[i++];
        else arr[k++] = R[j++];
    }
    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
}

// Call: mergeSort(arr, 0, arr.length - 1);
```

| Property | Value |
|---|---|
| Time — All cases | O(n log n) |
| Space | O(n) — auxiliary arrays |
| Stable? | Yes |
| In-place? | No |

**When to use**: Large datasets; linked lists (natural fit); when stability is required; external sorting.

---

### 9.5 Quick Sort

**Concept**: Divide-and-conquer. Pick a pivot, partition the array so elements smaller than pivot are on the left and larger on the right. Recursively sort both sides.

```java
public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high]; // Choose last element as pivot
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        }
    }
    int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
    return i + 1;
}

// Call: quickSort(arr, 0, arr.length - 1);
```

#### Pivot Strategies
- **Last element**: Simple but O(n²) on sorted arrays.
- **Random pivot**: `swap(arr, low + rand.nextInt(high - low + 1), high)` — expected O(n log n).
- **Median-of-three**: Use median of first, mid, last — most robust.

| Property | Value |
|---|---|
| Time — Best | O(n log n) |
| Time — Average | O(n log n) |
| Time — Worst | O(n²) — sorted array with bad pivot |
| Space | O(log n) — call stack |
| Stable? | No |
| In-place? | Yes |

**When to use**: General-purpose sorting; in-memory sorting where average case matters; Java's `Arrays.sort()` uses Dual-Pivot Quicksort internally for primitives.

---

### 9.6 Heap Sort

**Concept**: Build a max-heap from the array. Repeatedly extract the maximum (root) and place it at the end, reducing heap size each time.

```java
public static void heapSort(int[] arr) {
    int n = arr.length;
    // Build max-heap
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
    // Extract elements from heap
    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp; // Swap root with last
        heapify(arr, i, 0);
    }
}

private static void heapify(int[] arr, int n, int i) {
    int largest = i, left = 2 * i + 1, right = 2 * i + 2;
    if (left < n && arr[left] > arr[largest]) largest = left;
    if (right < n && arr[right] > arr[largest]) largest = right;
    if (largest != i) {
        int temp = arr[i]; arr[i] = arr[largest]; arr[largest] = temp;
        heapify(arr, n, largest);
    }
}
```

| Property | Value |
|---|---|
| Time — All cases | O(n log n) |
| Space | O(1) |
| Stable? | No |
| In-place? | Yes |

**When to use**: When consistent O(n log n) in worst case is needed with O(1) space; priority queue operations.

---

### 9.7 Counting Sort

**Concept**: Non-comparison sort. Count the frequency of each element, compute prefix sums, then build the sorted output array. Only works for integer (or discrete) data with a known range.

```java
public static void countingSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    int[] count = new int[max + 1];
    for (int val : arr) count[val]++;
    // Cumulative count
    for (int i = 1; i <= max; i++) count[i] += count[i - 1];
    int[] output = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
        output[--count[arr[i]]] = arr[i];
    }
    System.arraycopy(output, 0, arr, 0, arr.length);
}
```

| Property | Value |
|---|---|
| Time | O(n + k) where k = range of input |
| Space | O(n + k) |
| Stable? | Yes |
| In-place? | No |

**When to use**: Integer keys with a small known range (e.g., ages, grades); as a subroutine in Radix Sort.

---

### 9.8 Radix Sort

**Concept**: Non-comparison sort. Sort digit by digit from the least significant to the most significant using a stable sub-sort (typically counting sort).

```java
public static void radixSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    for (int exp = 1; max / exp > 0; exp *= 10)
        countingSortByDigit(arr, exp);
}

private static void countingSortByDigit(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[10];
    for (int val : arr) count[(val / exp) % 10]++;
    for (int i = 1; i < 10; i++) count[i] += count[i - 1];
    for (int i = n - 1; i >= 0; i--) {
        int digit = (arr[i] / exp) % 10;
        output[--count[digit]] = arr[i];
    }
    System.arraycopy(output, 0, arr, 0, n);
}
```

| Property | Value |
|---|---|
| Time | O(d × (n + b)) where d = digits, b = base |
| Space | O(n + b) |
| Stable? | Yes |
| In-place? | No |

**When to use**: Large datasets with integer or fixed-length string keys; can outperform comparison sorts when d is small.

---

### 9.9 Shell Sort

**Concept**: Generalization of Insertion Sort. Sort elements far apart first (large gap), then reduce the gap. As the gap reduces to 1, it becomes a regular insertion sort on a nearly-sorted array.

```java
public static void shellSort(int[] arr) {
    int n = arr.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j = i;
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
    }
}
```

| Property | Value |
|---|---|
| Time — Best | O(n log n) |
| Time — Average | Depends on gap sequence |
| Time — Worst | O(n²) or O(n log² n) |
| Space | O(1) |
| Stable? | No |
| In-place? | Yes |

---

### 9.10 Tim Sort (Java's Default)

**Concept**: Hybrid of Merge Sort and Insertion Sort. Divides the array into small runs, sorts each with insertion sort, then merges runs using merge sort. This is what Java's `Arrays.sort()` uses for **object arrays** and `Collections.sort()`.

```java
// Java uses TimSort internally for:
Arrays.sort(objectArray);    // Objects — TimSort
Arrays.sort(primitiveArray); // Primitives — Dual-Pivot QuickSort
```

| Property | Value |
|---|---|
| Time — Best | O(n) |
| Time — Average | O(n log n) |
| Time — Worst | O(n log n) |
| Space | O(n) |
| Stable? | Yes |

---

## 10. Algorithm Complexity Summary

### Searching Algorithms

| Algorithm | Best | Average | Worst | Space | Sorted Required? |
|---|---|---|---|---|---|
| Linear Search | O(1) | O(n) | O(n) | O(1) | No |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) iterative | Yes |
| Jump Search | O(1) | O(√n) | O(√n) | O(1) | Yes |
| Interpolation Search | O(1) | O(log log n) | O(n) | O(1) | Yes |
| Exponential Search | O(1) | O(log n) | O(log n) | O(log n) | Yes |

### Sorting Algorithms

| Algorithm | Best | Average | Worst | Space | Stable | In-place |
|---|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ | ✅ |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | ❌ | ✅ |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ | ✅ |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ | ❌ |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ | ✅ |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) | ❌ | ✅ |
| Counting Sort | O(n+k) | O(n+k) | O(n+k) | O(n+k) | ✅ | ❌ |
| Radix Sort | O(nk) | O(nk) | O(nk) | O(n+b) | ✅ | ❌ |
| Shell Sort | O(n log n) | Varies | O(n²) | O(1) | ❌ | ✅ |
| Tim Sort | O(n) | O(n log n) | O(n log n) | O(n) | ✅ | ❌ |

### Choosing the Right Algorithm

```
Is the data sorted already?
  └─ Yes → Binary Search (O(log n))
  └─ No  → Linear Search (or sort first)

What size is the dataset?
  └─ Small (< 50) → Insertion Sort
  └─ Medium       → Quick Sort (average case best in practice)
  └─ Large        → Merge Sort (stable) or Heap Sort (O(1) space)

Are elements integers in a limited range?
  └─ Yes → Counting Sort or Radix Sort (linear time!)
  └─ No  → Comparison-based sorts

Do you need stability?
  └─ Yes → Merge Sort, Tim Sort, Counting Sort, Insertion Sort
  └─ No  → Quick Sort, Heap Sort offer better constants

Memory constrained?
  └─ Yes → Heap Sort (O(1) space, O(n log n) time)
  └─ No  → Merge Sort or Tim Sort
```

---

> **Reference**: Java SE Documentation — `java.util.Arrays`, `java.lang.System`
> All time complexities are expressed in Big-O notation. n = number of elements, k = range of values, d = number of digits, b = base.