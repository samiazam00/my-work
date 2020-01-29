/* Name: Samreen Azam
 * Date: 9/28/17
 * HL CS Period 2 */

public class Tester
{ 
  private static PipelineNode headNode = null;
  private static PipelineNode tailNode = null;  
  
  public static void main(String args[])
  {
    //Creation of the nodes
    append(0, "Pump station");
    append(3050, "Hwy 35");
    append(4573, "Tank farm");   
    traverseAndPrint( );
    
    System.out.println("\n******* now insert a node before old node 2 ******** \n");
    insert(4040, "Cold Creek", 2);  
    traverseAndPrint();
    
    System.out.println("\n******* now insert a node before old node 1 ******** \n"); 
    insert(8080, "Hot Creek", 1); 
    traverseAndPrint();
    
    System.out.println("\n******* now insert a new head node******** \n"); 
    insert(8092, "New Head", 0); 
    traverseAndPrint(); 
    
    System.out.println("\nPress any key to continue...");
  }
  
  
  public static void insert(int pos, String descr, int indx) //add a new node in the middle of the list
  {
    PipelineNode oldNode = headNode;
    PipelineNode insertNode = new PipelineNode(pos, descr, null); //new node needs a pointer to old node, null for now
    PipelineNode prevNode = null;  //previous node that will point at inserted node, null for now
    int nodeIndex = 0; //finds current index of each node
    
    if(indx == 0)  //in case we need a new head node
    {
      headNode = insertNode;
      insertNode.nextNode = oldNode;
      nodeIndex++;
    }
    else {
      while(indx > nodeIndex) //traverses through & compares new node's index with the old node
      {
        prevNode = oldNode; 
        oldNode = oldNode.nextNode;
        nodeIndex++;
      }
      prevNode.nextNode = insertNode; //the node that pointed at oldNode now points at the inserted node
      insertNode.nextNode = oldNode;  //insertNode now points at the old node
    }
  }
  
  public static void append(int pos, String descr) //append a new node to the end of the list
  {
    PipelineNode newNode = new PipelineNode(pos, descr, null);
    if(headNode == null) 
    {
      headNode = newNode;
    }
    else
    {
      tailNode.nextNode = newNode; //update the old tailNode
    }
    tailNode = newNode; //specify a new tailNode
  }
  
  
  public static void traverseAndPrint() 
  {
    PipelineNode currentNode = headNode;
    int nodeNum = -1;
    int count = 0;
    do
    {
      nodeNum++;
      count++; //counts the number of nodes during each iteration
      System.out.println("Node number: " + nodeNum);
      System.out.println("Position: " + currentNode.position);
      System.out.println("Description: " + currentNode.description);
      System.out.println(""); //gives a blank line between nodes
      currentNode = currentNode.nextNode;
    } while(currentNode != null); //we don't need to know ahead of time how many
    System.out.println("The number of nodes in the list is: " + count);
    
  }
  
}