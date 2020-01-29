/* Samreen Azam (sa3tnc)
 * 11/22/19
 *HuffNode.cpp */

#include <iostream>
#include <string>
#include "HuffNode.h"
using namespace std;


HuffNode::HuffNode() {
  val = ' ';
  freq = 0;
  pfx = "";
  left = NULL;
  right = NULL; 
} 

HuffNode::HuffNode(const char &c, const int &x) {
  val = c;
  freq = x;
  pfx = "";
  left = NULL;
  right = NULL;
}

HuffNode::~HuffNode() {
  delete left;
  delete right;
}

char HuffNode::getVal() {
  return val;
}

HuffNode*& HuffNode::getLeft(){
  return left;
}

HuffNode*& HuffNode::getRight(){
  return right;
}
