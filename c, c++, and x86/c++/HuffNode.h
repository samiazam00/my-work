/* Samreen Azam (sa3tnc)
 * 11/22/19
 * HuffNode.h */

#ifndef HUFFNODE_H
#define HUFFNODE_H
#include<iostream>
#include <string>
using namespace std;

class HuffNode {
 public:
  HuffNode();
  HuffNode(const char &c, const int &x);
  ~HuffNode();
  char getVal();
  HuffNode*& getLeft();
  HuffNode*& getRight();
  HuffNode *left, *right; 
  char val;
  int freq;
  string pfx;
 
};
#endif
