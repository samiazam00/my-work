/* Samreen Azam
 * 9/14/17
 * AP CS Period 6 */

public class Player 
{
  
  PlayingCard players = new PlayingCard();
  public int computerDraws()
  {
    int compcard = players.cardDealt();
    String ryl = players.checkCard(compcard);
    
    if(ryl.equals(""))      
      System.out.println("Computer got a(n) " + compcard);
    else
      System.out.println("Computer got a(n) " + ryl);
    
    return compcard;   
  }
  
  public int youDraw()
  {
    int yourcard = players.cardDealt();
    String royalty = players.checkCard(yourcard);
    
    if(royalty.equals(""))      
      System.out.println("You got a(n) " + yourcard);
    else
      System.out.println("You got a(n) " + royalty);
    
    return yourcard;
  }
}
