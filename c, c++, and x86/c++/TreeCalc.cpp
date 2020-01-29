/*
 *Samreen Azam (sa3tnc)
 *10/13/19
 *TreeCalc.cpp:  CS 2150 Tree Calculator method implementations */

#include "TreeCalc.h"
#include <iostream>
#include <stack>
#include <cstdlib>

using namespace std;

//Constructor
TreeCalc::TreeCalc() {
  stack<TreeNode*> mystack;
}

//Destructor- frees memory
TreeCalc::~TreeCalc() {
  mystack.empty(); //deletes all nodes   
}

//Deletes tree/frees memory
void TreeCalc::cleanTree(TreeNode* ptr) {
  //as long as there are subtrees, delete those first, then the pointer argument
  if(ptr->left != NULL)
    cleanTree(ptr->left); //empty the pointer's left subtree recursively

  if(ptr->right != NULL)
     cleanTree(ptr->right); //empty the right subtree
     
  delete ptr; //delete the pointer 
}

//Gets data from user
void TreeCalc::readInput() {
    string response;
    cout << "Enter elements one by one in postfix notation" << endl
         << "Any non-numeric or non-operator character,"
         << " e.g. #, will terminate input" << endl;
    cout << "Enter first element: ";
    cin >> response;
    //while input is legal
    while (isdigit(response[0]) || response[0]=='/' || response[0]=='*'
            || response[0]=='-' || response[0]=='+' ) {
        insert(response);
        cout << "Enter next element: ";
        cin >> response;
    }
}

//Puts value in tree stack
void TreeCalc::insert(const string& val) { //reminder to treat this as an array 
  TreeNode *n = new TreeNode(val); //initialize new node with value passed to method

  if(isdigit(val[0]) ||  isdigit(val[1]) ) 
    mystack.push(n);  //if the value is a positive or negative number, push tree node 

  else if(val[0] == '+' || val[0] == '-' || val[0] == '/' || val[0] == '*')
    {
      //For operators: Make the node to be pushed the root for the last 2 operands
      //Make new nodes to represent right and left, then pop off the operands
      TreeNode *r = mystack.top();
      mystack.pop();
      TreeNode *l = mystack.top();
      mystack.pop();
      //Make r and l the right and left subtrees of the node to insert:
      n->right = r;
      n->left = l;
      mystack.push(n);
    }
}

//Prints data in prefix form - Node, Left, Right
void TreeCalc::printPrefix(TreeNode* ptr) const {
  if(ptr == NULL) //base case - stop printing when root is null
    return; //return nothing, exit method 

  cout << ptr->value << " "; //not null, print root value

  //Recursively print subtrees:
  if(ptr->left != NULL)
    printPrefix(ptr->left);

  if(ptr->right != NULL)
    printPrefix(ptr->right);
    
}

//Prints data in infix form - Left, Node, Right- also print parentheses for operators
void TreeCalc::printInfix(TreeNode* ptr) const {
  if(ptr == NULL) 
    return;

  if(ptr->left != NULL)
    {
      cout << "("; 
      printInfix(ptr->left);
    }

  if( isdigit(ptr->value[0]) || ( (ptr->value[0] == '-') && isdigit(ptr->value[1] ) ) )
    cout << ptr->value;
  else
    cout << " " << ptr->value;

   if(ptr->right != NULL)
    {
      printInfix(ptr->right);
      cout << ")"; 
    }
  
}

//Prints data in postfix form - Left, Right, Node 
void TreeCalc::printPostfix(TreeNode* ptr) const {
  if(ptr == NULL) 
    return; 

  if(ptr->left != NULL)
    printPostfix(ptr->left);

  if(ptr->right != NULL)
    printPostfix(ptr->right);

  cout << ptr->value << " "; 
}

// Prints tree in all 3 (pre,in,post) forms

void TreeCalc::printOutput() const {
    if (mystack.size()!=0 && mystack.top()!=NULL) {
        cout << "Expression tree in postfix expression: ";
        printPostfix(mystack.top());
        cout << endl;
        cout << "Expression tree in infix expression: ";
	printInfix(mystack.top());
        cout << endl;
        cout << "Expression tree in prefix expression: ";
	printPrefix(mystack.top());
        cout << endl;
    } else
        cout<< "Size is 0." << endl;
}

//Evaluates tree, returns value
// private calculate() method
int TreeCalc::calculate(TreeNode* ptr) const {
  // Traverse the tree and calculates the result via recursion
  //store input (node value) as string and  evaluate  subtrees of nodes for operators
  string input = ptr->value;
  if(input[0] == '+')
    return ( calculate(ptr->left) + calculate(ptr->right) );

 else if(input[0] == '*')
    return ( calculate(ptr->left) * calculate(ptr->right) );
  
 else if(input[0] == '-' && !isdigit(input[1]) )
    return ( calculate(ptr->left) - calculate(ptr->right) );
  
 else if(input[0] == '/')
    return ( calculate(ptr->left) / calculate(ptr->right) );
  
 else
    return atoi(input.c_str());
}

//Calls calculate, sets the stack back to a blank stack
// public calculate() method. Hides private data from user
int TreeCalc::calculate() {
    int i = calculate(mystack.top());
    return i;
}
