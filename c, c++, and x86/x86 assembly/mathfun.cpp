/* Samreen Azam (sa3tnc)
 * 11/3/19
 * mathfun.cpp
*/

#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

extern "C" int product(int, int);
extern "C" int power(int, int);

int main() {
  int x, y, prod, pow;
  cout << "Please enter the first positive integer (x): ";
  cin >> x;
  if(x < 0) { //check for valid input
    cout << "Invalid input. Please try again.";
    return 1; //repeat procedure 
  }
  
  cout << "Please enter the second positive integer (y): ";
  cin >> y;
  if(y < 0) { //check for valid input
    cout << "Invalid input. Please try again.";
    return 1; //repeat procedure 
  }

  prod = product(x,y);
  cout << "The product of x and y  is: " << prod << endl;
  pow = power(x,y);
  cout << "x to the power of y is: " << pow << endl;    
  return 0;
}
