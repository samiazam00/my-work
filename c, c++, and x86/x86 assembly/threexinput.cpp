/* Samreen Azam (sa3tnc)
 * 11/17/19
 * threexinput.cpp
 */

#include <iostream>
#include <cstdlib>
#include "timer.h"
using namespace std;

extern "C" int threexplusone(int);

int main()
{
  int num, calls, result;
  double avg;
  timer t;

  cout << "Enter your favorite number: ";
  cin >> num;
  cout << "Enter the number of function calls: ";
  cin >> calls;

  t.start();
  for(int x; x < calls; x++) {
    threexplusone(num);
  }
  t.stop();

  result = threexplusone(num);
  avg = (t.getTime()*1000) / calls;
  cout << "Total Steps: " << result << endl;
  cout << "Average Time per Call: " << avg << " ms" << endl;

  return 0;
}
