package me.ramswaroop.common;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * A HEAP is a specialized tree-based ABSTRACT DATA TYPE that satisfies the heap property:
 * min-heap: All non-leaf elements are either smaller than or equal to their left and right child.
 * max-heap: All non-leaf elements are either greater than or equal to their left and right child.
 * <p/>
 * Often implemented as an array, where the children of the element at index i are at index
 * 2i+1 (left child) and 2i+2 (right child).
 * <p/>
 * The first element (minimum or maximum, depending on chosen order) can be found in O(1).
 * Each successor can be found in O(log n). The algorithm in maxHeapify() takes O(log n) time
 * Therefore, buildMaxHeap() would take O(n log n) time BUT IF OBSERVED CAREFULLY IT TAKES 0(N) TIME.
 * <p/>
 * Used in the HeapSort algorithm. Also can be used to implement a PriorityQueue.
 *
 * @author: ramswaroop
 * @date: 8/2/15
 * @time: 11:57 AM
 */
public class Heap {

    public static void minHeapify(int[] a, int index) {
        int smallest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < a.length && a[index] > a[leftIndex]) {
            smallest = leftIndex;
        }
        if (rightIndex < a.length && a[smallest] > a[rightIndex]) {
            smallest = rightIndex;
        }

        if (smallest != index) {
            swap(a, index, smallest);
            minHeapify(a, smallest);
        }
    }

    /**
     * Converts array {@param a} in to a max heap.
     *
     * @param a
     */
    public static void buildMinHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            minHeapify(a, i);
        }
    }

    public static void maxHeapify(int[] a, int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < a.length && a[index] < a[leftIndex]) {
            largest = leftIndex;
        }
        if (rightIndex < a.length && a[largest] < a[rightIndex]) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(a, index, largest);
            maxHeapify(a, largest);
        }
    }

    /**
     * Converts array {@param a} in to a max heap.
     *
     * @param a
     */
    public static void buildMaxHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i);
        }
    }

    public static void swap(int[] a, int firstIndex, int secondIndex) {
        a[firstIndex] = a[firstIndex] + a[secondIndex];
        a[secondIndex] = a[firstIndex] - a[secondIndex];
        a[firstIndex] = a[firstIndex] - a[secondIndex];
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 5, 1, 6, 7, 8};
        System.out.println(Arrays.toString(a));
        buildMaxHeap(a);
        System.out.println(Arrays.toString(a));
        buildMinHeap(a);
        System.out.println(Arrays.toString(a));
    }
}
