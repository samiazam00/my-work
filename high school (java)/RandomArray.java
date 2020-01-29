/* Samreen Azam
 * AP CS A (Period 6)
 * Chapter 9 Test Program */

public class RandomArray
{
 public static int randomIndex(int numbers[])
 {
   return ((int) (Math.random() * (numbers.length)));
 }
  
 public static void main(String args[])
 {
   int nums[] = {1, 3, 7, 11, 16, 23, 30};
   System.out.print(nums[randomIndex(nums)]);
 }
}