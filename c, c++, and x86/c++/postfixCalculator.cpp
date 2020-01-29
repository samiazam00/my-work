/*Samreen Azam (sa3tnc)
 *9/15/19
 *postfixCalculator.cpp
 */

#include <stack>
#include <iostream>
#include <string>
#include "postfixCalculator.h"
using namespace std;

postfixCalculator::postfixCalculator() //implement constructor
{
  stack<int> s;
}

int postfixCalculator::displayTop()
{
  return s.top();
}

void postfixCalculator::addNum(int n)
{
  s.push(n);
}

void postfixCalculator::add()
{
  int n1 = displayTop(); //get the top of the stack
  s.pop(); //now remove it
  int n2 = displayTop(); //get the new top
  s.pop(); //remove that too
  s.push( n1 + n2 ); //insert their sum to the stack
}

void postfixCalculator::sub()
{
  int n1 = displayTop(); //get the top of the stack
  s.pop(); 
  int n2 = displayTop(); //get the new top
  s.pop(); 
  s.push( n2 - n1 ); //insert their difference to the stack
}

void postfixCalculator::mult()
{
  int n1 = displayTop(); 
  s.pop(); 
  int n2 = displayTop(); 
  s.pop(); 
  s.push(n2*n1); //insert their product to the stack
}

void postfixCalculator::div()
{
  int n1 = displayTop(); 
  s.pop(); 
  int n2 = displayTop(); 
  s.pop(); 
  s.push(n2/n1); //insert their quotient to the stack
}

void postfixCalculator::negate()
{
  int n = displayTop(); //get top
  s.pop(); 
  s.push(-1*n); //negate & insert into stack
}
