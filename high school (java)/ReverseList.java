/* Samreen Azam
 * 12/4/17
 * Period 2 (HL)
 * Reverse List Stack Program (Main Class) */

import java.util.*;
public class ReverseList extends Stack
{
  public static void traverseAndPrint()  //goes through the list and prints the values enetered by the user
  {
    Nodes currentNode = headNode; //start at the head
   
    System.out.print("The list is: ");
    while(currentNode != null) //traverse, print, & stop when we reach the tail
    {
      System.out.print(currentNode.value + " "); //print value & gives a blank space between values
      currentNode = currentNode.nextNode; //allows us to move to the next node
    } 

  } 
  
  public static void reverseAndPrint() //keep calling pop & print reversed list 
  {
    Nodes reverseNode = tailNode; 

    System.out.print("\nThe list reversed is: ");
    while(reverseNode != headNode)
    {
      try{
        reverseNode.value = pop(); 
        System.out.print(reverseNode.value + " "); 
      }
      catch(NullPointerException e)
      {
        System.out.println(headNode.value);
        return;
      }
    }
    
  }
  
  
  public static void main(String args[])
  {
    boolean quit = false; 
    int input;
    int count = 0; //only up to 10 values will be added to stack

    Scanner kbReader = new Scanner(System.in);
    while (quit == false) //if user enters 999 or enters tenth number, we quit. otherwise, loop continues
    {
      System.out.println("Enter an integer (999 to quit): ");   
      input = kbReader.nextInt();
      if(input == 999 || count == 10)
      {
        quit = true;
      }
      else
      {
        push(input); //add the number user entered to top of stack
        count++;
      }
    }
    traverseAndPrint(); 
    reverseAndPrint();
    kbReader.close();
  }
}