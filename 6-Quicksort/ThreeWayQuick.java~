/* This class implements the Dijkstra 3-Way Quick Sort and Quick select.
*/
import java.util.*;

public class ThreeWayQuick {
    private static final int CUTOFF = 10;

    public static void sort (Comparable[] a) {
	// actually we need a random shuffle here to ensure good performance
	sort(a, 0, a.length - 1);
    }

    public static Comparable select (Comparable[] a, int k) {
	// actually we need a random shuffle here to ensure good performance
	int lo = 0, hi = a.length - 1;
	while (lo < hi) {
	    int j = partition(a, lo, hi);
	    if      (j < k) {lo = j + 1;}
	    else if (j > k) {hi = j - 1;}
	    else            {return a[k];}
	}
	return a[k];
    }

    private static void sort (Comparable[] a, int lo, int hi) {
	if (hi < lo + CUTOFF) {
	    Insertion.sort(a, lo, hi);
	    return;
	}

	int lt = lo, gt = hi;
	Comparable v = a[lo];
	int i = lo;
	while (i < gt) {
	    int c = a[i].compareTo(v);
	    if      (c < 0) { exch(a, lt++, i++); }
	    else if (c > 0) { exch(a, i, gt--);   }
	    else            { i++; }
	}
	
	sort(a, lo, lt - 1);
	sort(a, gt + 1, hi);
    }

    private static int partition (Comparable[] a, int lo, int hi) {
	int i = lo, j = hi+1;
	while (true) {
	    // find item on left to swap
	    while (less(a[++i], a[lo])) {
		if (i == hi) {break;}
	    }

	    // find item on right to swap
	    while (less(a[lo], a[--j])) {
		// redundant here, because if j == lo, then less(a[lo], a[j]) would be false
		/*		if (j == lo) {break;} */  
	    }
	    
	    if (i >=j) {break;} // check if pointers cross
	    exch(a, i, j);  // swap
	}
	
	exch(a, lo, j);
	return j;
    }

    private static void exch(Comparable[] a, int i, int j) {
	Comparable tmp = a[i];
	a[i] = a[j];
	a[j] = tmp;
    }

    private static boolean less (Comparable a, Comparable b) {
	return a.compareTo(b) < 0;
    }
}