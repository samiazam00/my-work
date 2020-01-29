/* Samreen Azam (sa3tnc)
 * 11/22/19 
 * Heap.h 
*/

#include <vector> //vector based implementation for linear time
#include <iostream>
#include <unordered_map>
#include "Heap.h"
#include "HuffNode.h" 
using namespace std;

/* Note that some of these functions were influenced by the example code
 * written by Prof. Bloomfield. Also if you're reading this, hope you have
 * a nice day. Stay hydrated :) */  

Heap::Heap() : size(0) {
    h.push_back(NULL);
}

Heap::Heap(vector<HuffNode*> vect) : size(vect.size()) {
    h = vect;
    h.push_back(h[0]);
    h[0] = 0;
    for (int i = size/2; i > 0; i--)
        percolateDown(i);
}

Heap::~Heap() { //destructor
}

void Heap::insert(HuffNode *n) {
  h.push_back(n);
  percolateUp(++size);
}

void Heap::percolateUp(int hole) {
  HuffNode *x = h[hole];
  for ( ; (hole > 1) &&(x < (h[hole/2])); hole /= 2 ){
    h[hole] = h[hole/2]; // move down parent
    }
  h[hole] = x;
}


void Heap::percolateDown(int hole) {
    HuffNode *x = h[hole];
    while ( hole*2 <= size ) {
        int child = hole*2;    
        if ( ((child + 1) <= size) && ((h[child+1]) < (h[child])) )
            child++;

        if ( x > h[child] ) {
            h[hole] = h[child]; // move child
            hole = child;            
        } else
            break;
    }
    h[hole] = x;
}

HuffNode* Heap::findMin() {
    if ( size < 1 )
        throw "findMin() called on empty heap";
    
    return h[1];
}

void Heap::deleteMin() {
  if ( size <  1 )
    throw "deleteMin() called on empty heap";
  
  h[1] = h[size-1];
  h.pop_back();
  percolateDown(1);
}

int Heap::getSize() {
    return size;
}

void Heap::makeEmpty() {
    size = 0;
}

bool Heap::isEmpty() {
  return (size == 0);
}

void Heap::printData() {
    cout << "(" << h[0] << ") ";
    for ( int i = 1; i <= size; i++ ) {
        cout << h[i]->val;
        // next line from from http://tinyurl.com/mf9tbgm
        bool isPow2 = (((i+1) & ~(i))==(i+1))? i+1 : 0;
        if ( isPow2 )
            cout << endl << "\t";
    }
    cout << endl;
}

//function to recursively build the tree:
void Heap::huffTree(HuffNode* n, string s) {
  if(n->left == NULL && n->right == NULL) {
    if(n->val == ' ')
      cout << "space" << " " << s << endl;
    else
      cout << n->val << " " << s << endl;
    //store in the map to be paired:
    mp.insert(make_pair(n->val, s));
  }
  
  if(n->left != NULL)
    huffTree(n->left, (s + "0"));
  if(n->right != NULL)
    huffTree(n->right, (s + "1"));
}

//get the code for a char from map
string Heap::charCode(char ch) {
  return mp[ch];
}
