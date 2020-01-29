/* Samreen Azam
 * 9/14/17
 * AP CS Period 6 */

import java.util.Random;

public class PlayingCard 
{
  public int cardDealt()
  {
    Random randomCard =  new Random();
    int card = randomCard.nextInt(13) + 1;
    return card; 
  }
  
  public String checkCard(int c)
  {
    String royal = "";
   
    if(c == 11) 
      royal = "Jack";
    
    else if(c == 12) 
      royal = "Queen";
    
    else if(c == 13) 
      royal = "King";
    
    else if(c == 1)
      royal = "Ace";
    
    return royal;     
  }
  
  public int aces(int f, int s) 
  {
    if ((f == 1) && ((f + 11) <= 21) )
    { 
      f += 10;
      return f;
    }
    else if((s == 1) && ((s + 11) <= 21) )  
    {
      s += 10; 
      return s;
    }
    else
      return 1;
  }
  
  public void whoWon(int yours, int comps)
  {
    int yourTotal = Math.abs(21 - yours);
    int compTotal = Math.abs(21 - comps);
    if(yourTotal < compTotal) 
    {
      System.out.println("Congratulations! You won!");
    }
    else if(yours == comps) 
    {
     System.out.println("It was a tie!");
    }
    else if(yourTotal > compTotal)
    {
      System.out.println("The computer won. Better luck next time!");
    }
  }
}