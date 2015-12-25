/*******************************************************************
 * Compilation:  javac Average.java
 * Execution:    java Average < data.txt
 * Dependencies: StdIn.java StdOut.java
 *  
 * Reads in a sequence of real numbers, and computes their average.
 *
 * % java Average
 * 10.0 5.0 6.0
 * 3.0 7.0 32.0
 * [Ctrl-d]
 * Average is 10.5
 *
 * Note [Ctrl-d] signifies the end of file on Unix.
 * On windows use [Ctrl-z].
 *
 *******************************************************************/

/**
 * The Average class provides a client for reading in a sequence of 
 * real numbers and printing out their average.
 *
 * For additional documentation, see <a href="http://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 *
 * @author Jiafeng Ni
 */
public class Average { 
    
    /**
     * Reads in a sequence of real numebrs from standard input and prints
     * their average into standard output.
     */
    public static void main(String[] args) {
	int count = 0;       // number of inputs
	double sum = 0.0;    // sum of inputs
	
	while(!StdIn.isEmpty()) {
	    double val = StdIn.readDouble();
	    sum += val;
	    count++;
	} 
	
	double average = sum / count;

	StdOut.println("The average is: " + average);
    }
}