/**
 * 
 */

/**
 * Samreen Azam
 * @author sa3tnc
 * Homework 6 
 */
public class Recursion {

	/**
	 * Main method for testing each recursive function 
	 * @param args
	 */
	public static void main(String[] args) {
		//Palindrome Tests:
		System.out.println(palindrome("madam")); //this is a palindrome, method should return "true"
		System.out.println(palindrome("hello")); //not a palindrome, method should return "false"
		System.out.println(palindrome("level")); //this is a palindrome, method should return "true"

		//reverseString Tests:
		System.out.println(reverseString("racecar")); //should print "racecar"
		System.out.println(reverseString("hello"));   //should print "olleh"
		System.out.println(reverseString("I love CS!")); //should print "!SC evol I"

		//Handshakes Tests:
		System.out.println(handshakes(0)); //should print 0
		System.out.println(handshakes(3)); //should print 3
		System.out.println(handshakes(6)); //should print 15

		//Ackermann Tests:
		System.out.println(ackermann(0,0)); //should print 1
		System.out.println(ackermann(2,0)); //should print 3
		System.out.println(ackermann(3,4)); //should print 125
	}

	/**
	 * Recursively check if a String is a palindrome (the word is exactly the same when the String is reversed)
	 * @param s
	 * @return true if palindrome 
	 */
	public static boolean palindrome(String s)
	{
		int start = 0;
		int end = s.length() - 1;
		char[] word = (s.toUpperCase()).toCharArray(); //convert string to upper case & to char array to simplify comparison process

		if(s.length() < 2) //only one character in string: nothing to reverse so return true
			return true; 

		if(word[start] != word[end]) //base case: if the character at the beginning is not equal to the char at the end of the word, then this word is not a palindrome 
			return false;           
		else
			return palindrome(s.substring(start+1,end)); //recursive case w/ reduction: continuously shorten the string to check if each character matches up 
	}													

	/**
	 * Takes in a String and recursively reverses it one char at a time
	 * @param s
	 * @return s (reversed output)
	 */
	public static String reverseString(String s) {
		if(s.length() < 1) //base case - empty string: nothing to reverse so return true
			return s;
		else
			return reverseString(s.substring(1)) + s.charAt(0);  //recursive case: shorten string by 1 and add the first char at the end to reverse it
	}

	/**
	 * Counts all the handshakes possible for a number (n) of people
	 * @param n
	 * @return
	 */
	public static int handshakes(int n) {
		if(n < 2) //base case: at least 2 people are needed to shake hands, so method will stop counting handshakes if n is less than 2
			return 0;
		else //recursive case: 
			return (n-1) + (handshakes(n-1)); //adds (n-1) so that one person shaking hands w/ themselves is not counted 
	}

	/**
	 * Solves Ackermann's function: tests how well a computer performs recursion 
	 * @param m
	 * @param n
	 * @return long value
	 */
	public static long ackermann(long m, long n) {
		if(m == 0) //base case
			return n+1;
		//Recursive cases:
		else if(m > 0 && n == 0) //reduces value of m
			return ackermann(m-1,1);
		else
			return ackermann(m-1,ackermann(m,n-1)); //reduces both m and n, recursive call within a recursive call 
	}
}


