
/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author sa3tnc
 * @param <Comparable> The type of data this tree node stores
 */
public class TreeNode<T extends Comparable<T>> {

	/**
	 * Reference pointer to the left subtree
	 */
	private TreeNode<T> left;

	/**
	 * Reference pointer to the right subtree
	 */
	private TreeNode<T> right;

	/**
	 * Data stored at this node
	 */
	private T data;

	/**
	 * Default Constructor
	 * 
	 * Creates a binary tree node with null data and null children
	 */
	public TreeNode(){
		this(null,null,null);
	}

	/**
	 * Data-only Constructor
	 * 
	 * Creates a binary tree node with the given data and null children
	 * 
	 * @param theData The data to store at this node
	 */
	public TreeNode(T theData){
		this(theData,null,null);
	}


	/**
	 * Full Constructor
	 * 
	 * Creates a binary tree node with the given data and child reference pointers
	 * 
	 * @param theData The data to store at this node
	 * @param leftChild A reference pointer to the left subtree
	 * @param rightChild A reference pointer to the right subtree
	 */
	public TreeNode(T theData, TreeNode<T> leftChild, TreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}


	/**
	 * Left Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the left subtree
	 */
	public TreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Left Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new left subtree's root node
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * Right Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the right subtree
	 */
	public TreeNode<T> getRight() {
		return right;
	}

	/**
	 * Right Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new right subtree's root node
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	/**
	 * Get the data at this node
	 * 
	 * @return The data stored at this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the data at this node
	 * 
	 * @param data The data to be stored at this node
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Find height of subtree with the current node as the root
	 * @return 
	 */
	public int height()
	{
		if(left == null)
			return 1;
		if(right == null)
			return 1;
		
		return 1 + Math.max(left.height(), right.height());
	}


	/**
	 * Find the size of the binary tree by summing up the number of nodes with data in the tree
	 * @return sum 
	 */
	public int size() {
		int sum = 0;
		
		if(right == null && left == null)
			sum += 1;
		
		if(left != null)
			sum += 1 + left.size(); //recursively check the rest of the tree
		
		if(right != null)
			sum += 1 + right.size();
		
		
		
		return sum;
	}

	/**
	 * Find if an element exists
	 * Compares if the value val to current node's data (recursively).  
	 * Returns true if it is and checks left or right children otherwise
	 * 
	 * @param val The value to find
	 * @return True if the tree contains the value, false otherwise
	 */
	public boolean find(T val) {
		if(val == data)
			return true;

		else if(left != null && data.compareTo(val) > 0) //if the target node's value is less than the root's data, search the left subtree 
			return left.find(val);


		else if(right != null && data.compareTo(val) < 0) //if the target node's value is greater than the root's data, search the right subtree 
			return right.find(val);

		else
			return false; //otherwise, return false if not found
	}

	/**
	 * Insert an element, check if node should be added as a left child or right child recursively 
	 * @param val The value to insert
	 * @return True on success, false otherwise
	 */
	public boolean insert(T val) {
		TreeNode<T> newNode = new TreeNode<T>(val);
		if(data == null)
		{
			data = val; 
			return true;
		}

		else if(data.compareTo(val) < 0 )
		{
			if(this.right == null)
			{
				this.setRight(newNode);
				return true;
			}
			else	
				return this.right.insert(val);
		}
		else if(data.compareTo(val) > 0 )
		{
			if(this.left == null)
			{
				this.setLeft(newNode);
				return true; 
			}
			else	
				return this.left.insert(val);
		}
		else
			return false;
	}

	/**
	 * Return post-order traversal by recursively going through each node's children 
	 * @return left child, right child, root
	 */
	public String postOrder()
	{
		String retVal = "";
		if(this.left != null)
			this.left.postOrder(); 

		if(this.right != null)
			this.right.postOrder(); 

		retVal += this.toString(); 

		return retVal;
	}
	
	/**
	 * Return in-order traversal
	 * @return left child, root, right child
	 */
	public String inOrder()
	{
		String retVal = "";
		if(this.left != null)
			retVal += this.left.inOrder();
		
		retVal += "(" + this.data + ")";
		
		if(this.right != null)
			retVal += this.right.inOrder();

		return retVal;
	}


	/**
	 * toString method
	 */
	@Override
	public String toString() {
		String retVal = "";
		if (left != null)
			retVal += left.toString(); // recursive call on left
		if (right != null) 
			retVal += right.toString(); // recursive call on right
		retVal += "("+ data +")"; // add this node's data
		return retVal;
	}


	/**
	 * Main method
	 * 
	 * For main method testing, etc
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {

	}

}