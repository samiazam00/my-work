/* Samreen Azam (sa3tnc)
 * 9/15/19
 * postfixCalculator.h
 */


#ifndef POSTFIXCALCULATOR_H
#define POSTFIXCALCULATOR_H
#include <stack>
using namespace std;

class postfixCalculator {
 public:
  postfixCalculator(); //constructor
  //public methods:
  int displayTop(); //returns value at front of stack
  void addNum(int n); //will insert a number in the stack
  void add(); //calculates the sum of the element at top + the one after it
  void sub(); //subtracts top 2
  void mult(); //multiplies
  void div(); //divides
  void negate(); //negates top of stack

 private:
  stack<int> s; //stack we will use for the postfix calculator 
};

#endif
