import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

/** Class BinaryHeap **/
class BinaryHeap
{
    /** The number of children of each node **/
    private static final int d = 2;
    private ArrayList<Integer> heap;

    //Constructor
    public BinaryHeap()
    {
        heap = new ArrayList<>();
    }

    /** Function to check if heap is empty **/
    public boolean isEmpty( )
    {
        return heap.isEmpty();
    }

    /** Function to clear heap */
    public void makeEmpty( )
    {
        heap.clear();
    }

    /** Function to  get index parent of i **/
    private int parent(int i)
    {
        return (i - 1)/d;
    }

    /** Function to get index of kth child of i **/
    private int kthChild(int i, int k)
    {
        return d * i + k;
    }

    /** Function to insert element */
    /*
     * Approach:
     *  1. add the parameter 'x' to the end of the heap
     *  2. call the heapifyUp() method, passing one less than the heapSize as the parameter
     */
    public void insert(int x)
    {
    	
    }

    /** Function to find least element; least element is always stored at the zero index of the heap **/
    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return heap.get(0);
    }

    /** Function to delete min element **/
    /*
     * Approach:
     *  1. store the first element of the heap (index 0)
     *  2. call delete on the first element of the heap (zero index)
     *  3. return the stored value of the first element
     */
    public int deleteMin()
    {
    	return 0;
    }

    /** Function to delete element at an index **/
    /*
     * Explanation:
     *  This method sets the index of the heap to the last element of the heap, then
     *  delete the last element of the heap. Effectively moving the last element to the first
     *  element and then decreasing the size by 1. Once this is complete heapifyDown() is called
     */
    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap.get(ind);
        heap.set(ind, heap.get(heap.size() - 1));
        heap.remove(heap.get(heap.size() - 1));
        heapifyDown(ind);
        return keyItem;
    }

    /** Function heapifyUp  **/
    /*
     * Approach:
     *  1. Store value located at the 'childInd' index of the heap to some variable, for the sake of explanation lets call this variable 'tmp'
     *  2. Loop while 'childInd' is greater than zero and while 'tmp' is less than the value stored at the parent of the childInd index (call parent(childInd))
     *      3. In this loop, set the value at 'childInd' to the value stored in the child's parent index (again this index can be found by calling parent(childInd))
     *      4. Also in this loop, after setting the value of 'childInd', update 'childInd' to be the location of it's parent (parent(childIn))
      * 5. After the loop is done, set 'childInd' to the value stored in 'tmp'
     */
    private void heapifyUp(int childInd)
    {
    	
    }

    /** Function heapifyDown **/
    /*
     * Approach:
     *  1. declare a variable 'child'
     *  2. store the value of the 'ind' element as variable 'tmp' (heap.get(ind))
     *  3. Loop while kthChild(ind,1) is less than the size of the heap
     *      4. In the loop, set 'child' to minChild(ind)
     *      5. Also in the loop set the element at 'ind' to the value stored in the 'child' element of the heap (heap.get(child)) if value stored in the 'child element' is less than 'tmp'
     *      6. If the condition in step 5 above is not met, break from the loop
     *      7. The last action within the loop is setting ind = child
     *  8. After the loop is done, set the 'ind' element to the value stored in 'temp'
     */
    private void heapifyDown(int ind)
    {
    	int child; 
    }

    /** Function to get smallest child **/
    /*
     * This function returns the location of the smallest child of the value stored at the 'ind' index
     */
    private int minChild(int ind)
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heap.size()))
        {
            if (heap.get(pos) < heap.get(bestChild))
                bestChild = pos;
            pos = kthChild(ind, k++);
        }
        return bestChild;
    }

    /** Function to print heap **/
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heap.size(); i++)
            System.out.print(heap.get(i) +" ");
        System.out.println();
    }

    /*
     * This function creates an ArrayList of input data. You may specify the size and
     * max number in the list. Use this to create data to insert into your PriorityQueue
     * when testing run time.
     */
    public ArrayList<Integer> createInput(int size, int maxNum){
        ArrayList<Integer> retVal = new ArrayList<>();
        for(int i = 0; i < size; i++){
            retVal.add(ThreadLocalRandom.current().nextInt(0, maxNum + 1));
        }
        return  retVal;
    }

    public static void main(String[] args)
    {
        System.out.println("Binary Heap Test\n\n");
        /** Make object of BinaryHeap **/
        BinaryHeap bh = new BinaryHeap();

        char ch;
        /**  Perform Binary Heap operations  **/
        do
        {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check empty");
            System.out.println("4. clear");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    try
                    {
                        System.out.println("Enter integer element to insert");
                        bh.insert( scan.nextInt() );
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage() );
                    }
                    break;
                case 2 :
                    try
                    {
                        System.out.println("Min Element : "+ bh.deleteMin());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage() );
                    }
                    break;
                case 3 :
                    System.out.println("Empty status = "+ bh.isEmpty());
                    break;
                case 4 :
                    bh.makeEmpty();
                    System.out.println("Heap Cleared\n");
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /** Display heap **/
            bh.printHeap();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}