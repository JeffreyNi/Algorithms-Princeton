/* The original forest representation is improved by using an
   extra array to keep track of size of each tree and implementing
   path compression.

   An array is used to record the parent of each nod. Each 
   index represents a point, the value marks its parent's index.
   Two points are connected if they have the same root.

   This class has time complexity for both find and union O(lg(n))
 */
class WeightedQuickUnionUF_PathCompression {
    private int[] points;
    private int[] sizes;
    
    /** Constructor of this class.
	@param n the number of points
     */
    public WeightedQuickUnionUF_PathCompression (int n) {
	this.points = new int[n];
	this.sizes = new int[n];
	for (int i = 0; i < n; i++) {
	    this.points[i] = i;
	    this.sizes [i] = 1;
	}
    }

    /** Check whether two points are connected or not.
	@param p, q  indice of two points
	@return true if connected, false otherwise
     */
    public boolean connected(int p, int q) {
	return getRoot(p) == getRoot(q);
    }

    /** Connect two points by setting the level of all points 
	connected to them as the same.
	@param p, q  indice of two points
     */
    public void union (int p, int q) {
	int i = getRoot(p);
	int j = getRoot(q);
	if (sizes[i] > sizes[j]) {
	    points[j] = i;
	    sizes[i] += sizes[j];
	} else {
	    points[i] = j;
	    sizes[j] += sizes[i];
	}
    }

    /** Get the root of a point.
	@param index of the point
	@return index of the root point
     */
    private int getRoot(int p) {
	while (points[p] != p) {
	    // path compression to make the tree flat
	    points[p] = points[points[p]]; 
	    p = points[p];
	}
	return p;
    }
}