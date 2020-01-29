/* Azam, Samreen
 * Period 6 SL
 * Date: 11/3/16 */

import java.io.*;
import java.util.*;

public class FileNerd
{
  public static void main(String args [])throws IOException
   
  {
  
    Scanner xyz = new Scanner(new File("NerdData.txt"));
    int abc = -1;
    
    String s[] = new String[10];
 
    while(xyz.hasNext())
     {
      abc++;
      s[abc] = xyz.nextLine();  
      if(s[abc].startsWith("The"))
       {
         System.out.println(s[abc++]);
       }
     }
     xyz.close();
  }
}
  