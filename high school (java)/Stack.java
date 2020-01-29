public class Stack 
{

  public static Nodes headNode = null;
  public static Nodes tailNode = null; 
  Stack nextNode;
  static int value;

  
  public static void push(int v) //add node to top of stack 
  {
    if(headNode == null) //if list is empty
    {
      value = v;
      headNode = addNode;  //add the first node
      
      tailNode = addNode;
    }
    else
    {
      value = v;
      tailNode.nextNode = addNode;
      tailNode = addNode;
    }
    
  }


 public static int pop() //returns most recently added node to reverse list & remove from top
  {
    Nodes foundNode = tailNode;
    Nodes currentNode = headNode;
    
    while(currentNode.nextNode != tailNode) //traverse list, stop at node before tail
    {
      currentNode = currentNode.nextNode;
    }
    tailNode = currentNode;
    currentNode.nextNode = null; //delete the node
    return foundNode.value; //returns node found at top of stack
  }
  
}