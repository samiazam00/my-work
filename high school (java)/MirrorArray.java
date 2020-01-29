/* Samreen Azam
 * Date: 1/12/18
 * AP CS A Period 6
 * Mirror Array Program */

public class MirrorArray
{
 public static void main (String args[])
 {
   // declare/initialize array of 7 random integers (call random method of Math class, scale by multiplying by 20, & convert to integer) 
   int mirrorArray[] = new int[] {((int)(Math.random() * (20))), ((int)(Math.random() * (20))), ((int)(Math.random() * (20))),
                               ((int)(Math.random() * (20))), ((int)(Math.random() * (20))), ((int)(Math.random() * (20))),
                               ((int)(Math.random() * (20)))};
   
   for(int indx = 0; indx < mirrorArray.length; indx++) //loop to traverse & print array
   {
    System.out.println(mirrorArray[indx]); 
   }
   
   for(int reverseIndx = (mirrorArray.length - 1); reverseIndx > -1; reverseIndx--) //print array in reverse
   {
    System.out.println(mirrorArray[reverseIndx]); 
   }  
 }  
}