/* Samreen Azam
 * AP CS A
 * Period 6 */
import java.util.Scanner;
public class MFTester
{
  public static void main(String args[])
  {
    Scanner kbReader = new Scanner(System.in);
    System.out.print("Generate which term number?");
    int k = kbReader.nextInt( );
    System.out.println("Term #" + k + " is " + ModFib.modFibonacci(k));
    kbReader.close();
  }
}