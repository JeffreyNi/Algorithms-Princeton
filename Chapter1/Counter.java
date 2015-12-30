/******************************************************************
 *  Compilation:  javac Counter.java
 *  Execution:    java Counter N T
 *  Dependencies: StdRandom.java StdOut.java
 *
 *  A mutable data type for an integer counter
 *
 *  The test clients create N counters and performs T increment
 *  operations on random counters.
 *
 *  % java Counter 6 600000
 *  0: 99870
 *  1: 99948
 *  2: 99738
 *  3: 100283
 *  4: 100185
 *  5: 99976
 *
 ******************************************************************/

/**
 * The Counter class is a mutable data type to encapsulate a counter.
 * 
 * For additional documentation,
 * see <a href="http://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne 
 *
 * @author Jiafeng Ni 
 */

public class Counter implements Comparable<Counter>{

    private final String name;  // counter name
    private int count = 0;      // current value

    /**
     * Initialize a new Counter starting at 0, with the given name.
     * @param id the given name of the counter
     */
    public Counter (String id) {
	this.name = id;
    }

    /**
     * Increments the count by 1.
     */
    public void increment() {
	this.count++;
    }

    /**
     * Returns the current value of the Counter.
     * @param the current value of the Counter.
     */
    public int tally() {
	return this.count;
    }

    /**
     * Returns a string representation of this Counter.
     * @param return a string representation of this counter.
     */
    public String toString() {
	return this.name + ": " + this.count;
    }

    /**
     * Compares this counter to a specific counter.
     * @param that the counter specified to be compared
     * @return a negative integer if this counter is less than the other counter;
     *         a positive integer if this counter is greater than the other one;
     *         0 if this counter equals the other one.
     */
    public int compareTo(Counter that) {
	if      (this.count < that.count) {return -1;}
	else if (this.count > that.count) {return 1;}
	else                              {return 0;}
    }

    /**
     * Reads two command line integers N and T, create N counters,
     * increment T counters at random, and prints results.
     */
    public static void main(String[] args) {
	int N = Integer.parseInt(args[0]);
	int T = Integer.parseInt(args[1]);

	// create N counters
	Counter[] hits = new Counter[N];
	for (int i = 0; i < N; i++) {
	    hits[i] = new Counter("counter" + i);
	}
	
	// increment T counters at random
	for (int i = 0; i < T; i++) {
	    hits[StdRandom.uniform(N)].increment();
	}

	// print all counters' values
	for (int i = 0; i < N; i++) {
	    StdOut.println(hits[i]);
	}
    }
}