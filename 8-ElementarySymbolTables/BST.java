/* Implementation of standard Binary Search Tree.
*/
import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
	private Key key;
	private Value val;
	private Node left, right;
	private int count;

	public Node (Key key, Value val) {
	    this.key = key;
	    this.val = val;
	}
    }

    public BST () {
	this.root = null;
    }

    public Value get(Key key) {
	Node x = root;
	while (x != null){
	    int cmp = x.key.compareTo(key);
	    if      (cmp > 0) {x = x.left;}
	    else if (cmp < 0) {x = x.right;}
	    else              {return x.val;}
	}
	return null;
    }

    /** Put key-val pair into BST
	@param key the Key to be put
	@param val the val to be put
     */
    public void put (Key key, Value val) {
	root = put(key, val, root);
    }

    /** Helper function for put
	@param key the Key to be put
	@param val the val to be put
	@x the root of subBST where to put the pair
	@return the new root of the subBST
     */
    private Node put (Key key, Value val, Node x) {
	if (x == null) {return new Node(key, val);}

	int cmp = x.key.compareTo(key);
	if      (cmp > 0) { x.left = put(key, val, x.left);  }
	else if (cmp < 0) { x.right = put(key, val, x.right);}
	else              { x.val = val; }
	x.count = size(x.left) + size(x.right) + 1;
	return x;
    }

    public void delete(Key key) {
	root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
	if (x == null) {return null;}
	int cmp = key.compareTo(x.key);
	if      (cmp < 0) {return delete(x.right, key);}
	else if (cmp > 0) {return delete(x.left, key);}
	else {
	    if (x.right == null) {return x.left;}
	    if (x.left == null) {return x.right;}
	    
	    Node t = x;
	    x = min(x.right);
	    x.right = deleteMin(x.right);
	    x.left = t.left;
	}
	x.count = 1 + size(x.left) + size(x.right);
	return x;
    }

    public boolean contains (Key key) {
	return get(key) != null;
    }

    public boolean isEmpty() {
	return root == null;
    }

    public int size () {
	return size(root);
    }
    
    private int size(Node x) {
	if (x == null) {return 0;}
	return x.count;
    }

    /** Get the min Key in the BST.
	@return the minimum key in the BST
     */
    public Key min () {
	if (isEmpty()) {return null;}

	Node x = root;
	while (x.left != null) {x = x.left;}
	return x.key;
    }

    /** Get the max Key in the BST
	@return the maximum key in the BST
     */
    public Key max() {
	if (isEmpty()) {return null;}
	
	Node x = root;
	while (x.right != null) {x = x.right;}
	return x.key;
    }

    /** Get the largest key smaller than given key in the BST.
	@param key the given key
	@return the floor key
     */
    public Key floor(Key key) {
	Node x = floor(root, key);
	if (x == null) {return null;}
	return x.key;
    }

    /** Helper function for floor(Key key)
	@param x the root of subBST where to get the floor
	@param key the given key
	@return Node the node that contains the floor key
     */
    private Node floor(Node x, Key key) {
	if (x == null) {return null;}
	
	int cmp = key.compareTo(x.key);
	if (cmp == 0) {return x;}
	if (cmp < 0) {return floor(x.left, key);}
	
	Node y = floor(x.right, key);
	if (y == null) {return x;}
	else           {return y;}
    }

    /** Get the smallest key that is greater than the given key
	@param key the given key
	@return the ceiling key
     */
    public Key ceiling(Key key) {
	Node x = ceiling(root, key);
	if (x == null) {return null;}
	return x.key;
    }

    /** Helper function for ceiling(Key key)
	@param x the root of subBST where to get the ceiling
	@param key the given key
	@return Node the node that contains the ceiling key
     */
    private Node ceiling (Node x, Key key) {
	if (x == null) {return x;}
	
	int cmp = key.compareTo(x.key);
	if (cmp == 0) {return x;}
	if (cmp > 0) {return ceiling(x.right, key);}
	
	Node y = ceiling(x.left, key);
	if (y == null) {return x;}
	else           {return y;}
    }

    /** Get the number of entries that is smaller than the given key
	@param key the given key
	@return the rank of the given key
     */
    public int rank (Key key) {
	return rank(key, root);
    }

    /** Helper function for rank(Key key)
	@param key the given key
	@param x the Node of the subBST to get the rank
	@return int the rank of the given key in the subBST
     */
    private int rank (Key key, Node x) {
	if (x == null) {return 0;}

	int cmp = key.compareTo(x.key);
	if (cmp < 0)      {return rank(key, x.left);}
	else if (cmp > 0) {return 1 + size(x.left) + rank(key, x.right);}
	else              {return size(x.left);}
    }

    public Key select (int k) {

    }

    public void deleteMin() {
	root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
	if (x.left == null) {return x.right;}
	x.left = deleteMin(x.left);
	x.count = 1 + size(x.left) + size(x.right);
	return x;
    }

    public void deleteMax() {
	root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
	if (x.right == null) {return x.left;}
	x.right = deleteMax(x.right);
	x.count = 1 + size(x.left) + size(x.right);
	return x;
    }
    
    public int size (Key lo, Key hi) {
	return 0;
    }

    public Iterable<Key> keys() {
	Queue<Key> q = new Queue<Key>();
	inorder(root, q);
	return q;
    }
    
    private void inorder(Node x, Queue<Key> q) {
	if (x == null) {return;}
	inorder(x.left);
	q.add(x.key);
	inorder(x.right, q);
    }
}