/* Implementation of Priority Queue using Max Heap.
*/

import java.util.*;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    /** Constructs an empty priority queue
	@param capacity the size of the priority queue
     */
    public MaxPQ (int capacity) {
	this.pq = (Key[]) new Comparable[capacity];
	this.N = 0;
    }

    /** Insert a new key into pq
	@param v the key to be inserted
     */
    public void insert (Key v) {
	pq[++N] = v;
	swim(N);
    }

    /** Delete the max key in the priority queue
	@return the max key in pq
     */
    public Key delMax () {
	Key max = pq[1];
	exch(1, N--); 
	sink(1);
	this.pq[N + 1] = null; // prevent loitering
	return max;
    }

    /** Check is the priority queue is empty
	@return true if pq is empty
     */
    public boolean isEmpty() {
	return N == 0;
    }

    /** Swim the key up if it is greater than its parent
	@param k the index of the key to swim up
     */
    private void swim (int k) {
	while (k > 1 && less(k/2, k)) {
	    exch(k/2, k);
	    k /= 2;
	}
    }

    /** Sink the key down if it is less than its children
	@param k the index of key to be sink down
     */
    private void sink (int k) {
	while (k < N){
	    int j = k*2;
	    if (j < N && less(j, j+1)) {j++;}
	    if (!less(j, k)) {break;}

	    exch(j, k);
	    k = j;
	}
    }

    /** Exchange two keys in pq
	@param i index of first key
	@param j index of second key
     */
    private void exch (int i, int j) {
	Key temp = this.pq[i];
	this.pq[i] = this.pq[j];
	this.pq[j] = temp;
    }

    /** Check whether key at i is less than key at j in pq
	@param i index of first key
	@param j index of second key
	@return true if pq[i] < pq[j], false otherwise
     */
    private boolean less (int i, int j)  {
	return this.pq[i].compareTo(pq[j]) < 0;
    }
}
