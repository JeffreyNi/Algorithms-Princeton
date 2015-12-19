import java.util.*;

public class Insertion {

    public static void sort(Comparable[] a) {
	int N = a.length;

	for (int i = 0; i < N; i++) {
	    for (int j = i; j > 0; j--) {
		if (less(a[j], a[j-1])) { exch(a, j, j-1); }
		else {break;}
	    }
	}
    }

    public static void sort(Comparable[] a, int lo, int hi) {

	for (int i = lo; i <= hi; i++) {
	    for (int j = i; j > lo; j--) {
		if (less(a[j], a[j-1])) { exch(a, j, j-1); }
		else {break;}
	    }
	}
    }

    private static boolean less (Comparable a, Comparable b) {
	return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
	Comparable tmp = a[i];
	a[i] = a[j];
	a[j] = tmp;
    }
}