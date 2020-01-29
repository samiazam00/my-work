/* Samreen Azam (sa3tnc)
 * 11/22/19 
 * Heap.h 
*/

#ifndef HEAP_H
#define HEAP_H
#include <vector> //vector based implementation for linear time
#include <iostream>
#include <unordered_map>
#include "HuffNode.h" //separate file for node data
using namespace std;

class Heap {
 public:
  Heap();
  Heap(vector<HuffNode*> v); 
  ~Heap();
  //methods:
  void insert(HuffNode *n);
  void deleteMin();
  HuffNode* findMin();
  int getSize();
  // void incrementSize();
  //vector<HuffNode*> getVector();
  void makeEmpty();
  bool isEmpty();
  void printData();
  void huffTree(HuffNode *n, string s);
  string charCode(char ch);
  vector<HuffNode*> h;
  unordered_map<char, string> mp;
 private:
  int size;
  void percolateUp(int hole); 
  void percolateDown(int hole);
};
#endif
