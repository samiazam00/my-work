import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * Test cases for BinarySearchTree class
 * Homework #7
 * @author sa3tnc
 * (Samreen Azam)
 *
 */
public class BinarySearchTreeTest {
	//Fields 
	private TreeNode<Integer> left1;
	private TreeNode<Integer> right1;
	private TreeNode<Integer> bstRoot1;
	private BinarySearchTree<Integer> bst1;
	
	//Initialize field values before using them for testing methods
	@Before 
	public void initValues() 
	{
		left1 = new TreeNode<Integer>(3); 
		right1 = new TreeNode<Integer>(9); 
		bstRoot1 = new TreeNode<Integer>(7,left1,right1); 
		bst1 = new BinarySearchTree<Integer>(bstRoot1); 
		//Add more values to test in BST:
		bst1.insert(2);
		bst1.insert(5);
		bst1.insert(8);
		bst1.insert(10);
		bst1.insert(1);
		bst1.insert(4);
		bst1.insert(6);
	}
	
	
	/**
	 * Test that post order traversal was successful 
	 */
	@Test
	public void testPostOrder()
	{
		assertTrue("BST was not traversed properly.", bst1.postOrder().equals("(1)(2)(4)(6)(5)(3)(8)(10)(9)(7)") ); //should return true 
		assertTrue(bst1.postOrder().charAt(1) == '1'); //should be true
	}
	
	/**
	 * Test if in order traversal of BST was successful
	 * Also tests toString method and inOrder methods (should have equal output) 
	 */
	@Test
	public void testInOrder()
	{
		assertTrue("BST was not traversed properly.", bst1.inOrder().equals("(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)") ); //should return true 
		assertTrue(bst1.inOrder().equals(bst1.toString())); //should be true
	}
	
	
	/**
	 * Test insert() method of BinarySearchTree, should return true for each integer
	 */
	@Test
	public void testInsert() {
		assertTrue("Value was not inserted", bst1.insert(16)); //should return true 
		assertTrue("Value was not inserted", bst1.insert(14)); //should return true 	
	}
	
	
	/**
	 * Test if size method works as intended: should return the number of nodes in BST 
	 */
	@Test
	public void testSize()
	{
		assertEquals(bst1.size(), 12); //should return 12
		bst1.insert(12);
		assertFalse("Incorrect size returned", bst1.size() == 12); //should be true because the size is no longer 12
		assertEquals(bst1.size(), 13); //should return 13
	}
	
	/**
	 * Test if correct height of binary search tree is returned 
	 */
	@Test
	public void testHeight()
	{
		assertEquals(bst1.height(), 4); //should be equal because height is 4
	}
	
	
	/**
	 * Test find method to see if values in BST can be searched for
	 */
	@Test
	public void testFind()
	{
		assertTrue("Value should have been located, but method was unsuccessful.", bst1.find(5));
		assertFalse("Incorrect value found", bst1.find(22));
	}
	
}
