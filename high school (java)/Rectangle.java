/* Samreen Azam
 * AP CS A (Period 6)
 * Exercise 10 (Rectangle Program) */

public class Rectangle
{
  private int width;
  private int height;
  
  //constructors with different numbers of parameters to create different Rectangle objects: 
  public Rectangle(int w, int h) //constructor with 2 integer parameters
  {  
    if(w < 0) //check if value is negative or positive
      w = Math.abs(w); //if it is negative, then find absolute value
    
    if(w < 0) //check if width value is negative 
      w = Math.abs(h);  //abs. value because we cannot have negative lengths
    
    width = w; 
    height = h;
  }
  
  public Rectangle(int s) //constructor with one int paramater 
  {
    if(s < 0) //check if value is negative
      s = Math.abs(s); 
    
    width = s;
    height = width; //width and height are equal, so this object will be a square
  }
  
  public Rectangle()  //constuctor with no parameters, creates default square
  {
    height = 1;
    width = 1;
  }
  
  private static boolean isSquare (Rectangle rect) //private method that takes in a Rectangle object & returns a boolean
  {
    boolean square = false;
    if(rect.width == rect.height) //rectangle is a square if width is equal to height
      square = true;
    return square;
  } 
  
  private static void quadratize(Rectangle r) //private method that takes in a Rectangle object & has a void return type
  {                                           //converts rectangles that are not squares into squares w/ the closest area
    int area = r.width * r.height;
    r.width = (int) Math.round(Math.sqrt(area)); 
    r.height = r.width; //change height & width to new integers to form a square
  }
  
  public static void main(String args[])
  {
    Rectangle rect1 = new Rectangle(4,9); //create new object from constuctor w/ paramters matching these arguments 
    System.out.println("The first rectangle: width = " + rect1.width + ", height = " + rect1.height);
    if(isSquare(rect1) == true) //calls isSquare method to check if width = height
      System.out.println("The first rectangle is a square.\n");
    else
      System.out.println("The first rectangle is NOT a square.\n");
    
    Rectangle rect2 = new Rectangle(5); //create new object from constuctor w/ parameter matching this argument 
    System.out.println("The second rectangle: width = " + rect2.width + ", height = " + rect2.height);
    System.out.println("The second rectangle is a square.\n"); //it must be a square since width = height in constructor
    
    Rectangle rect3 = new Rectangle(); //no arguments, create Rectangle object from constructor w/ no parameters 
    System.out.println("The third rectangle: width = " + rect3.width + ", height = " + rect3.height);
    System.out.println("The third rectangle is a square.\n"); //it must be a square since width = height in constructor
    
    if(isSquare(rect1) == false)
    {
     quadratize(rect1);
     System.out.println("After quadratizing the first rectangle: width = " + rect1.width + ", height = " + rect1.height);
     System.out.println("The first rectangle is now a square.");
    }
  }
}