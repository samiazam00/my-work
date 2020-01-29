//Samreen Azam (sa3tnc)
//9/22/19
//prelab4.cpp

#include <iostream>
#include <limits>
using namespace std;

void sizeOfTest() //test sizeof() on different types
{
  cout << "Size of int: " << sizeof(int) << endl;
  cout << "\nSize of unsigned int: " << sizeof(unsigned int) << endl; 
  cout << "\nSize of float: " << sizeof(float) << endl;
  cout << "\nSize of double: " << sizeof(double) << endl;
  cout << "\nSize of char: " << sizeof(char) << endl; 
  cout << "\nSize of bool: " << sizeof(bool) << endl; 
  cout << "\nSize of int*: " << sizeof(int*) << endl; 
  cout << "\nSize of char*: " << sizeof(char*) << endl; 
  cout << "\nSize of double*: " << sizeof(double*) << endl; 
}

void outputBinary(unsigned int x) //print out 32-bit binary representation
{
  string s = ""; //start with a string, we will add on as the number increases
  for(int n = 31; n >= 0; n--)  //range is 0 to 31, decrement for big endian
    {
      int z = x >> n; //use right shift operator - moves x 4 bits 
      if (z & 1)    //& is a bitwise logical AND
	s += "1";   
      else
	s += "0";
    }
  cout << "32-bit binary representation of " << x << ": " << s << endl;
}

void overflow() //test what happens when adding to the max value 
{
  unsigned int k = std::numeric_limits<unsigned int>::max();
  cout << "\nMax value: " << k << endl;
  k++;
   cout << "Adding 1: " << k << endl;
  cout << "This occurs because the max value has a 1 in every place for each bit. So when something is added, the bits are flipped and you end up with the minimum value. \n";
}


int main() {
  cout << "sizeof tests:\n";
  sizeOfTest();
  int input;
  cout << "Please enter an integer: ";
  cin >> input;
  outputBinary(input);
  overflow();  
  return 0;
}
