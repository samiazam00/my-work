/*Samreen Azam (sa3tnc)
 *9/15/19
 *testPostfixCalculator.cpp
 */

#include <stack>
#include <iostream>
#include <string>
#include <cstdlib>
#include "postfixCalculator.h"
using namespace std;

//Testing:
int main() {
  postfixCalculator p;  
  string input;

  /* 
  postfixCalculator p2; //test subtraction
  postfixCalculator p3; //test multiplication
  postfixCalculator p4; //test division
  postfixCalculator p5; //test negation
  */
  
  cout << "Enter integers and operators, press Enter and Ctrl + D when finished." << endl; 
  while(cin >> input)
    {
      if(input == "+")
	p.add();
      else if(input == "-")
	p.sub();
      else if(input == "*")
	p.mult();
      else if(input == "/")
	p.div();
      else if(input == "~")
	p.negate();
      else
	p.addNum( atoi( input.c_str() ) );
    }
  cout << "Calculated Result: " << p.displayTop() << endl;


  /*-----------------------------------------------------------------old tests
  //Test 2: Subtracting
  p2.addNum(20);
  p2.addNum(10);
  p2.sub();
  p2.addNum(-3);
  p2.addNum(10);
  p2.sub();
  p2.sub();
  p2.addNum(2);
  p2.sub();

  cout << "Test 2: Subtraction Result: " << p2.displayTop() << endl; //should return 21

  //Test 3:
  p3.addNum(-1);
  p3.addNum(-2);
  p3.addNum(-5);
  p3.addNum(3);
  p3.mult();
  p3.addNum(2);
  p3.addNum(-2);
  p3.mult();
  p3.mult();
  p3.mult();
  p3.mult();
  cout << "Test 3: Multiplication Result: " << p3.displayTop() << endl; //should return 120

  //Test 4:
  p4.addNum(-1512);
  p4.addNum(-12);
  p4.addNum(-2);
  p4.div();
  p4.div();
  p4.addNum(-2);
  p4.div();
  p4.addNum(3);
  p4.div();
  cout << "Test 4: Division Result: " << p4.displayTop() << endl; //should return 42
  
  //Test 5:
  p5.addNum(-1);
  p5.negate();
  p5.negate();
  p5.negate();
  cout << "Test 5: Negation Result: " << p5.displayTop() << endl; //should return -1 */

  return 0;
}
