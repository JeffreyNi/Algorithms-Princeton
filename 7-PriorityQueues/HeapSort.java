/* Implements HeapSort algorithm.
*/

import java.util.*;

public class HeapSort {

    public static void sort (Comparable[] a) {
	int N = a.length;
	// build the MaxHeap bottom-up
	for (int k = N / 2; k >= 1; k--) {
	    sink(a, k, N);
	}

	while (N > 1) {
	    exch(a, 1, N--);
	    sink(a, 1, N);
	}
    }

    private static void sink (Comparable[] a, int k, int N) {
	while (k * 2 <= N) {
	    int j = 2 * k;
	    if (j < N && less(a, j, j+1)) { j++; }
	    if (!less(a, k, j))           { break; }
	    
	    exch(a, k, j);
	    k *= 2;
	}
    }

    private static boolean less(Comparable[] a, int i, int j) {
	return a[i-1].compareTo(a[j-1]) < 0;
    }

    private static void exch (Comparable[] a, int i, int j) {
	Comparable tmp = a[i-1];
	a[i-1] = a[j-1];
	a[j-1] = tmp;
    }

}