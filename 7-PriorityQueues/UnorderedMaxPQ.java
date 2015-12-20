import java.util.*;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public UnorderedMaxPQ (int capacity) {
	this.pq = (Key[])new Comparable[capacity];
	this.N = 0;
    }

    public UnorderedMaxPQ (int capacity, Key[] a) {
	this.pq = (Key[])new Comparable[capacity];
	for (int i = 0; i < a.length; i++) {
	    pq[i] = a[i];
	}
	this.N = a.length;
    }

    public void insert (Key v) {
	pq[N++] = v;
    }

    public boolean isEmpty () {
	return N == 0;
    }

    public Key delMax () {
	int max = 0;
	for (int i = 1; i < N; i++) {
	    if (less(max, i)) {max = i;}
	}

	exch(max, N-1);
	return this.pq[--N];
    }

    private void exch(int i, int j) {
	Key tmp = this.pq[i];
	this.pq[i] = this.pq[j];
	this.pq[j] = tmp;
    }

    private boolean less (int i, int j) {
	return this.pq[i].compareTo(this.pq[j]) < 0;
    }

}