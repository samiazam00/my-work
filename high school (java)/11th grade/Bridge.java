/* Name: Azam, Samreen
 * Period 6
 * Date Created: 9/30/16
 * Pledge: Samreen Azam */


import java.util.*;
public class Bridge
{
public static void main(String args[])
  {
   System.out.println("A. 2 Axles");
   System.out.println("B. 3 Axles");
   System.out.println("C. 4-5 Axles");
   System.out.println("D. 6 Axles");
   System.out.println("E. 7 Axles");
   System.out.println("F. 8 Axles");
   System.out.println("G. 9 Axles");
   
   System.out.println("Select the Amount of Axles On Your Vehicle:\n");
   
   Scanner kbReader = new Scanner(System.in);
   String x = kbReader.nextLine();
   char y = x.charAt(0);
   
   switch(y)
   {
     case 'A':
     case 'a':
       System.out.println("The bridge toll will be $3.00");
       break;
     case 'B':
     case 'b':
       System.out.println("The bridge toll will be $5.25");
       break;
     case 'C':
     case 'c':
       System.out.println("The bridge toll will be $8.25");
       break;
     case 'D':
     case 'd':
       System.out.println("The bridge toll will be $9.25");
       break;
     case 'E':
     case 'e':
       System.out.println("The bridge toll will be $10.75");
       break;
     case 'F':
     case 'f':
       System.out.println("The bridge toll will be $12.75");
       break;
    case 'G':
    case 'g':
       System.out.println("The bridge toll will be $13.75");
       break;
    default:
       System.out.println("Please select the letter corresponding to the number of axles on your vehicle."); 
   }
                                                 
   kbReader.close(); 
 }

}