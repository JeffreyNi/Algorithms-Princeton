/**********************************************************
 * Compilation:  javac RandomSeq.java
 * Execution:    java RandomSeq N lo hi
 * Dependencies: StdOut.java StdRandom.java
 * 
 * Prints N numbers between lo and hi
 * 
 * % java RandomSeq 5 100.0 200.0
 * 123.43
 * 153.13
 * 144.38
 * 155.18
 * 104.02
 * 
 **********************************************************/

/**
 * The RandomSeq class is a client that prints out a pseudorandom 
 * sequence of real numbers in a given range.
 *
 * For additional documentation, see <a href="http://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * 
 * @author Jiafeng Ni
 */

public class RandomSeq {

    /**
     * Reads in two command line arguments lo and hi and prints N 
     * uniform real numbers int [lo, hi) to standard output.
     */
    public static void main(String[] args) {
	
	int N = Integer.parseInt(args[0]); 

	// default range is [0.0, 1.0)
	if (args.length == 1) {
	    for (int i = 0; i < N; i++) {
		double x = StdRandom.uniform();
		StdOut.println(x);
	    }
	} else if (args.length == 3) {
	    double lo = Double.parseDouble(args[1]);
	    double hi = Double.parseDouble(args[2]);
	    for (int i = 0; i < N; i++) {
		double x = StdRandom.uniform(lo, hi);
		StdOut.printf("%.2f\n", x);
	    }
	} else {throw new IllegalArgumentException("Invalid number of arguments"); }
    }
}