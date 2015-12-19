/* This class is basic representation of Union-Find problem.
   An array is used to record if points are connected or not.
   Each index represents a point, the value marks its level.
   Two points are connected if their levels are the same.

   This class optimizes Find operation (O(1) for checking 
   whether two points are connected or not).
 */
class QuickFindUF {
    private int[] points;
    
    /** Constructor of this class.
	@param n the number of points
     */
    public QuickFindUF (int n) {
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
	return points[p] == points[q];
    }

    /** Connect two points by setting the level of all points 
	connected to them as the same.
	@param p, q  indice of two points
     */
    public void union (int p, int q) {
	if (!connected(p, q)) {
	    int tmp = points[q];
	    int lvl = points[p];
	    for (int i = 0; i < this.points.length; i++) {
		if (points[i] == tmp) {
		    points[i] = lvl;
		}
	    }
	}
    }
}