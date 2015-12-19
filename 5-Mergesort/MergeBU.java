/* This class implements Bottom-up Merge Sort.
   BU-Merge uses iteration instead of recursion to do the sort part.
*/

import java.util.*;

public class MergeBU {

    private static final int CUTOFF = 7; // Curoff size when using insertion sort 
    private static Comparable[] aux; 
    
    /** Merge Sort the given array
	@param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
	int N = a.length;
	aux = new Comparable[N];
	
	for (int sz = 1; sz < N; sz *= 2) {
	    for (int lo = 0; lo < N - sz; lo += sz) {
		merge(a, aux, lo, lo + sz - 1, Math.min(N - 1, lo + 2*sz - 1));
	    }
	}
    }

    /** Helper merge sort function to sort subarray.
	@param a the array to be sorted
	@param aux the array to store elements before sorting
	@param lo beginning index for sort
	@param hi ending index for sort
     */
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
	// for tiny subarrays (smaller than CUTOFF), using InsertionSort
	if (hi < lo + CUTOFF) {
	    Insertion.sort(a, lo, hi);
	    return;
	}

	int mid = lo + (hi - lo) / 2;
	if (!less(a[mid+1], a[mid])) {return;}

	sort(a, aux, lo, mid);
	sort(a, aux, mid+1, hi);
	merge(a, aux, lo, mid, hi);
    }

    /** Helper merge function to merget two sorted subarrays in the given array
	@param a the array to be sorted
	@param aux the array to store elements before sorting
	@param lo beginning index for first subarray
	@param mid ending index for first subarray
	@param hi ending index for second subarray
     */
    private static void merge (Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
	assert isSorted(a, lo, mid);       // precondition: a[lo..mid] is sorted
	assert isSorted(a, mid + 1, hi);   // precondition: a[mid+1..hi] is sorted

	for (int i = lo; i <= hi; i++) {aux[i] = a[i];}

	int i = lo, j = mid + 1;
	for (int k = lo; k < hi; k++) {
	    if      (i > mid)              {a[k] = aux[j++];} 
	    else if (j > hi)               {a[k] = aux[i++];} 
	    else if (less(aux[j], aux[i])) {a[k] = aux[j++];}
	    else                           {a[k] = aux[i++];}
	}

	assert isSorted(a, lo, hi); // postcondition: a[lo..hi] is sorted
    }

    /** Helper function to check whether a subarray is sorted or not
	@param a the array to be checked
	@param lo the beginning index of subarray to be check
	@param hi the endning index of subarray to be checked
     */
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
	assert (lo <= hi);
	
	for (int i = lo + 1; i <= hi; i++) {
	    if (less(a[i], a[i - 1])) {return false;}
	}
	
	return true;
    }

    private static boolean less (Comparable a, Comparable b) {
	return a.compareTo(b) < 0;
    }

}