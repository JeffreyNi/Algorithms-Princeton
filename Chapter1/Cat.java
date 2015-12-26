/***************************************************************
 *  Compilation:  javac Cat.java
 *  Execution:    java Cat input0.txt input1.txt ... output.txt
 *  Dependencies: In.java Out.java
 *
 *  Reads in text files specified as the first command-line 
 *  arguments, concatenates them, and writes the result to
 *  filename specified as the last command-line arguments.
 *
 *  % more in1.txt
 *  This is
 *
 *  % more in2.txt 
 *  a tiny
 *  test.
 * 
 *  % java Cat in1.txt in2.txt out.txt
 *
 *  % more out.txt
 *  This is
 *  a tiny
 *  test.
 *
 ***************************************************************/

/**
 * The class provides a client for concatenating the results of 
 * several text files.
 *
 * For additional documentation, see <a href="http://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 *
 * @author Jiafeng Ni
 */

public class Cat {

    public static void main(String[] args) {
	Out out = new Out(args[args.length - 1]);
	for (int i = 0; i < args.length - 1; i++) {
	    In in = new In(args[i]);
	    String str = in.readAll();
	    out.println(str);
	    in.close();
	}
	out.close();
    }
}