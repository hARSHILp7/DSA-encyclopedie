# Java Data Structures

A quick reference guide with one-line descriptions of all major Java data structures.

---

## Arrays

| Data Structure | Description |
|---|---|
| **Array** | Fixed-size, indexed sequence of elements of the same type. |

---

## Lists

| Data Structure | Description |
|---|---|
| **ArrayList** | Resizable array implementation; fast random access, slow insert/delete in the middle. |
| **LinkedList** | Doubly linked list; fast insert/delete at ends, slow random access. |
| **Vector** | Thread-safe, resizable array similar to ArrayList (legacy). |
| **Stack** | LIFO (Last-In-First-Out) structure built on top of Vector (legacy). |

---

## Sets

| Data Structure | Description |
|---|---|
| **HashSet** | Unordered set backed by a hash table; O(1) average add/remove/lookup. |
| **LinkedHashSet** | Hash set that preserves insertion order. |
| **TreeSet** | Sorted set backed by a red-black tree; O(log n) operations. |
| **EnumSet** | High-performance set optimized for use with enum values. |

---

## Queues & Deques

| Data Structure | Description |
|---|---|
| **PriorityQueue** | Min-heap based queue where elements are ordered by natural order or a comparator. |
| **ArrayDeque** | Resizable double-ended queue; faster alternative to Stack and LinkedList as a queue. |
| **LinkedList** | Also implements Queue and Deque interfaces for FIFO or double-ended access. |

---

## Maps

| Data Structure | Description |
|---|---|
| **HashMap** | Unordered key-value map backed by a hash table; O(1) average get/put. |
| **LinkedHashMap** | Hash map that maintains insertion order of entries. |
| **TreeMap** | Sorted key-value map backed by a red-black tree; O(log n) operations. |
| **Hashtable** | Thread-safe key-value map; does not allow null keys or values (legacy). |
| **EnumMap** | Highly efficient map with enum keys. |
| **WeakHashMap** | Map where keys are held by weak references and can be garbage collected. |
| **IdentityHashMap** | Map that uses reference equality (`==`) instead of `.equals()` for key comparison. |

---

## Concurrent Data Structures

| Data Structure | Description |
|---|---|
| **ConcurrentHashMap** | Thread-safe, high-throughput hash map using segment-level locking. |
| **CopyOnWriteArrayList** | Thread-safe list that creates a fresh copy of the array on every write. |
| **CopyOnWriteArraySet** | Thread-safe set backed by a CopyOnWriteArrayList. |
| **ArrayBlockingQueue** | Bounded blocking queue backed by an array; blocks on full/empty. |
| **LinkedBlockingQueue** | Optionally bounded blocking queue backed by linked nodes. |
| **PriorityBlockingQueue** | Unbounded blocking queue with priority ordering. |
| **ConcurrentLinkedQueue** | Lock-free, thread-safe unbounded FIFO queue. |
| **ConcurrentSkipListMap** | Thread-safe, sorted key-value map using a skip list. |
| **ConcurrentSkipListSet** | Thread-safe, sorted set using a skip list. |

---

## Trees

| Data Structure | Description |
|---|---|
| **Binary Tree** | Hierarchical structure where each node has at most two children (left and right). |
| **Binary Search Tree (BST)** | Binary tree where left child < parent < right child; enables O(log n) search on average. |
| **TreeMap** | Built-in balanced BST (red-black tree) storing sorted key-value pairs; O(log n) operations. |
| **TreeSet** | Built-in balanced BST (red-black tree) storing sorted unique elements; O(log n) operations. |
| **AVL Tree** | Self-balancing BST that maintains strict height balance; guarantees O(log n) operations. |
| **Red-Black Tree** | Self-balancing BST used internally by `TreeMap` and `TreeSet`; guarantees O(log n) worst case. |
| **Heap (PriorityQueue)** | Complete binary tree satisfying the heap property; used via `PriorityQueue` in Java. |
| **Trie (Prefix Tree)** | Tree where each node represents a character; efficient for prefix-based string search. |
| **Segment Tree** | Binary tree for storing intervals/ranges; supports efficient range queries and point updates. |
| **Fenwick Tree (BIT)** | Compact tree structure for efficient prefix sum queries and point updates in O(log n). |
| **B-Tree** | Balanced multi-way search tree used in databases and file systems for disk-efficient access. |
| **N-ary Tree** | Generalized tree where each node can have up to N children. |

---

## Graphs

| Data Structure | Description |
|---|---|
| **Adjacency Matrix** | 2D array where `matrix[i][j]` indicates an edge between vertex i and j; O(1) edge lookup. |
| **Adjacency List** | Array/map of lists where each entry stores the neighbors of a vertex; space-efficient for sparse graphs. |
| **Directed Graph (Digraph)** | Graph where edges have a direction from one vertex to another. |
| **Undirected Graph** | Graph where edges have no direction; connection between vertices is bidirectional. |
| **Weighted Graph** | Graph where each edge carries a numerical weight or cost. |
| **DAG (Directed Acyclic Graph)** | Directed graph with no cycles; used in scheduling, dependency resolution, and topological sort. |
| **Spanning Tree** | Subgraph that connects all vertices with no cycles; basis for Kruskal's and Prim's algorithms. |

---

## Specialized Structures

| Data Structure | Description |
|---|---|
| **BitSet** | Compact array of bits used to represent a set of boolean flags. |
| **Properties** | String-to-string key-value map used for configuration; extends Hashtable. |

---

## Quick Cheat Sheet

| Use Case | Best Choice |
|---|---|
| Fast random access | `ArrayList` |
| Fast insert/delete at ends | `ArrayDeque` / `LinkedList` |
| Unique elements, fast lookup | `HashSet` |
| Sorted unique elements | `TreeSet` |
| Key-value pairs, fast lookup | `HashMap` |
| Sorted key-value pairs | `TreeMap` |
| FIFO queue | `ArrayDeque` |
| Priority-based processing | `PriorityQueue` |
| Thread-safe map | `ConcurrentHashMap` |
| Thread-safe list | `CopyOnWriteArrayList` |
| Producer-consumer pattern | `LinkedBlockingQueue` |
| Sorted key-value / range queries | `TreeMap` |
| Prefix/autocomplete search | `Trie` |
| Priority-based tree | `PriorityQueue` (Heap) |
| Sparse graph representation | Adjacency List |
| Dense graph representation | Adjacency Matrix |
| Dependency ordering | DAG + Topological Sort |