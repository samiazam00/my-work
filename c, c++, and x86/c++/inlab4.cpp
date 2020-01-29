/* Samreen Azam (sa3tnc)
 * 9/24/19
 * inlab4.cpp 
 */
#include <iostream>
using namespace std;

int main() {
  cout << "In lab 4 part 1:\n";
  int i = 5;
  char c = 'c';
  bool b = 1;
  double d = 2.3;
  int* i2 = new int[2];
  cout << "Int: " << i << "\nChar: " << c << "\nBool: " << b << "\nDouble: " << d << "\nInt*: " << i2 << endl;
  cout << "\nEnd of part 1. Part 2:\n";
  int iarr[10] = {1,2,3,4,5,6,7,8,9,10};
  char carr[10] ={'a', 'b', 'c', '1', '2', '3', 'i', 'd', 'e', 'k'};
  int iarr2d[6][5] =
    {
      {1,2,3,4,5},
      {0,8,9,6,7},
      {5,10,15,25,30},
      {6,6,7,7,8},
      {-2,-4,0,19,12},
      {5,22,64,0,1}
    };
  char carr2d[6][5];
  cout << &(iarr2d[4][3]) << "\n"<< endl;
  cout << &(iarr2d[2][4]);

  return 0;
}
