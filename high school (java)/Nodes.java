/* Samreen Azam
 * 12/4/17
 * Period 2 (HL)
 * Reverse List Stack Program (Nodes Class) */


public class Nodes
{
  int value; 
  Nodes nextNode; 
  public Nodes(int val, Nodes point) //constructor: each node has a value (determined by user) & a pointer
  {  
    this.value = val; 
    this.nextNode = point; 
  }
}