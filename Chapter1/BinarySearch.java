/**********************************************************
 * Compilation:  javac BinarySearch.java
 * Execution:    java BinarySearch whitelist.text < input.text
 * Dependencies: In.java StdIn.java StdOut.java
 * Datafiles:    tinyW.txt tinyT.txt largeW.txt largeT.txt
 * 
 * % java BinarySearch tinyW.txt < tinyT.txt
 * 50
 * 99
 * 13
 *
 * % java BinarySearch largeW.txt < largeT.txt
 * 499569
 * 984875
 * 295754
 * 207807
 * 140925
 * 161828
 * [367,966 total values]
 * 
 ***********************************************************/

import java.util.Arrays;

/**
 * The BinarySearch class provides a static method for binary searching
 * for an integer in a sorted array of integers.
 * 
 * The operation takes logarithmic time in the worst case.
 *
 * Original version see <a href="http://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * 
 * @author Jiafeng Ni
 */

public class BinarySearch {

    /**
     * Returns the index of specified key in an specified array.
     *
     * @param  a the array of integers, must be sorted in ascending order
     * @param  key the search key
     * @return return index of key if present; -1 otherwise
     */
    public static int indexOf(int[] a, int key) {
	int lo = 0;
	int hi = a.length - 1;
	while (lo <= hi) {
	    int mid = lo + (hi - lo) / 2;
	    if      (key > a[mid]) {lo = mid + 1;}
	    else if (key < a[mid]) {hi = mid - 1;}
	    else                   {return mid;}
	}
	return -1;
    }


    /**
     * Returns the rank of specified key in an specified array.
     * This function only consider the situation that all keys in
     * the array are distinct.
     * 
     * @param  key the search key
     * @param  a the array of integers, must be sorted in ascending order and 
     *         have no duplicates
     * @return index of a key in the array if present; -1 otherwise
     */
    public static int rank (int key, int[] a) {
	return indexOf(a, key);
    }

    /**
     * Reads in a sequence of input of integers from whitelist file, specified as 
     * a command line argument; reads in integers from standard input;
     * prints to standard output those integers that do not appears in that file.
     */
    public static void main(String[] args) {

	// read in integers from a file
	In in = new In(args[0]);
	int[] whitelist = in.readAllInts();

	// sort the array of integers
	Arrays.sort(whitelist);
	/*	for (int i : whitelist) {
	    System.out.println(i);
	    }*/

	// read integer keys form standard input; print them out if not present in whitelist
	while (!StdIn.isEmpty()) {
	    int key = StdIn.readInt();
	    //	    System.out.println("key: " + key);
	    if (BinarySearch.indexOf(whitelist, key) == -1) {
		StdOut.println(key);
	    }
	}

    }
}