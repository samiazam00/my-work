import java.util.ArrayList;

/**
 * Binary Search Tree Class
 * The head class for a binary search tree implementation.
 * @author sa3tnc
 * (Samreen Azam) 
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * A reference pointer to the root of the tree
	 */
	private TreeNode<T> root;

	/**
	 * Default constructor
	 * 
	 * Creates a binary tree object with null root note (empty tree)
	 */
	public BinarySearchTree() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * Creates a binary tree object with the given node as root
	 * 
	 * @param newRoot The root of the tree
	 */
	public BinarySearchTree(TreeNode<T> newRoot) {
		this.root = newRoot;
	}

	/**
	 * Get the root of the tree
	 * 
	 * @return The root of the tree
	 */
	public TreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Set the root of the tree
	 * 
	 * @param root  The new root of this tree
	 */
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}


	/**
	 * Recursively find height of entire tree 
	 * @return
	 */
	public int height()
	{
		if(root == null) //tree is empty, so height = 0
			return 0;
		else
			return getRoot().height(); //return the height of the root node (calls height method in TreeNode class)
	}

	/**
	 * Find the size of the binary tree by summing up the number of nodes with data in the tree
	 * @return 0 if empty, otherwise returns sum of all nodes  
	 */
	public int size() {
		int sum = 0;

		if(root.getLeft() != null)
			sum += root.getLeft().size();   //recursively calls method in TreeNode class to check the rest of the tree 

		if(root.getRight() != null)
			sum += root.getRight().size();

		else
			sum += 0;

		return sum;
	}


	/**
	 * Find if an element exists
	 * 
	 * Checks to see if the value val appears in the
	 * tree (recursively).  Returns true if it appears
	 * and false otherwise.
	 * 
	 * @param val The value to find
	 * @return True if the tree contains the value, false otherwise
	 */
	public boolean find(T val) {
		if(val.equals(root.getData()))
			return true;

		else 
			return root.find(val);
	}

	/**
	 * Insert an element
	 * 
	 * Inserts val into the tree where it should appear, returning
	 * true on success and false otherwise
	 * 
	 * @param val The value to insert
	 * @return True on success, false otherwise
	 */
	public boolean insert(T val) {
		TreeNode<T> newNode = new TreeNode<T>(val); //create new node with val set as its data
		if(root == null)
		{
			root = newNode;
			return true;
		}

		else if(root.getData().compareTo(val) < 0 )
		{
			return root.getRight().insert(val);
		}
		else if(root.getData().compareTo(val) > 0 )
		{
			return root.getLeft().insert(val);
		}
		else
			return false;
	}


	/**
	 * Extra Credit:
	 * Delete an element from the tree
	 * 
	 * Deletes val from the tree if it appears, returning
	 * true on success and false otherwise
	 * 
	 * @param val The value to delete
	 * @return True on success, false otherwise
	 
	public boolean delete(T val) {
		if(root == null)
			return true;

		if(val < root.getData())
			root.getLeft().delete(val);
		else if(val > root.getData())
			root.getRight().delete(val);

	} */


	/**
	 * Return post-order traversal of tree (left child, right child, root)
	 */
	public String postOrder()
	{
		if(root == null)
			return "";

		else
			return root.postOrder(); //calls postOrder method from TreeNode class recursively
	}

	/**
	 * Return in-order traversal of tree (left child, root, right child)
	 */
	public String inOrder()
	{
		if(root == null)
			return "";

		else
			return root.inOrder(); //calls inOrder method from TreeNode class recursively
	}


	/**
	 * Build from a list
	 * 
	 * Build the tree from the given list, overwriting any tree data
	 * previously stored in this tree.  Should read from beginning to
	 * end of the list and repeatedly call insert() to build the tree.
	 * 
	 * @param list The list from which to build the tree
	 * @return True if successfully built, false otherwise
	 */
	public boolean buildFromList(ArrayList<T> list) {
		if(root != null) //empty BST if there are nodes present already
			root = null;
		
		root = new TreeNode<T>(list.get(0)); //root is now the first element of list
		
		for(int i = 1; i < list.size(); i++)
		{
			this.insert(list.get(i));
		}
		return true;
	}


	/**
	 * toString method
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.inOrder() + ""; //returns all node's data via in order traversal
	}

	/**
	 * Main method
	 * 
	 * For testing, etc
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		TreeNode<Integer> left = new TreeNode<Integer>(2); 
		TreeNode<Integer> right = new TreeNode<Integer>(5); 
		TreeNode<Integer> bstRoot = new TreeNode<Integer>(4,left,right); //create root with children
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(bstRoot); //initialize a tree object to be tested
		bst.insert(6); 
		bst.insert(1);
		bst.insert(3); 
		bst.insert(7); 
		System.out.println(bst.size()); //should return 7
		System.out.println(bst.height()); //should return 3
		System.out.println(bst.postOrder()); //Should return (1)(3)(2)(7)(6)(5)(4)
		System.out.println(bst.inOrder()); //Should return (1)(2)(3)(4)(5)(6)(7)
		System.out.println(bst.find(5)); //should return true
		System.out.println(bst.find(9)); //should return false
		
	}
}