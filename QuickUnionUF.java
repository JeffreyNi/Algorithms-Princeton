/* This class is forest representation of Union-Find problem.
   An array is used to record the parent of each nod. Each 
   index represents a point, the value marks its parent's index.
   Two points are connected if they have the same root.

   This class tries to optimize Union operation but actually 
   very slow, since getRoot is O(n).
 */
class QuickUnionUF {
    private int[] points;
    
    /** Constructor of this class.
	@param n the number of points
     */
    public QuickUnionUF (int n) {
	this.points = new int[n];
	for (int i = 0; i < n; i++) {
	    this.points[i] = i;
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
	points[i] = j;
    }

    /** Get the root of a point.
	@param index of the point
	@return index of the root point
     */
    private int getRoot(int p) {
	while (points[p] != p) {p = points[p];}
	return p;
    }
}