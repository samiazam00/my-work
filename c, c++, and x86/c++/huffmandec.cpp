/* Samreen Azam (sa3tnc)
 * 11/25/19
 * huffmandec.cpp
 */
// Part of this program is derived from  the skeleton code for the lab 10 in-lab.  It uses
// C++ streams for the file input, and just prints out the data when
// read in from the file

#include <iostream>
#include <fstream>
#include <sstream>
#include <stdlib.h>
#include <cstdio>
#include "HuffNode.h"
using namespace std;

//function to create huffman tree:
void huffTree(HuffNode *n, char ch, string pfx)
{

  n->val = ch;
  
  /* if(pfx.length() == 0)
    n = new HuffNode(ch, 0);
  
   else if(n->val == ' ') {
    n->val = ch;
    } */

  if(pfx[0] == '0')
    {
      if(n->left == NULL) {
	n->left = new HuffNode('\0', 0);
      }
      huffTree(n->left, ch, pfx.substr(1, pfx.length()-1));
    }
  else if(pfx[0] == '1') {
    if(n->right == NULL) {
      n->right = new HuffNode('\0', 0);
    }
    huffTree(n->right, ch, pfx.substr(1, pfx.length()-1));
  }
}


//traverse and read/print tree, return 1 to count:
int printTree(HuffNode*& root, string pfx, int indx) {
  if( (root->left == NULL) && (root->right == NULL) ) {
    cout << root->val;
  }
    
  else{
    if(pfx[indx] == '0'){
      printTree(root->left, pfx, (indx+1));
    }
    
    if(pfx[indx] == '1'){
      printTree(root->right, pfx, (indx+1));
    }
  }
  return 1;
}

// main(): we want to use parameters
int main (int argc, char **argv) {
  HuffNode *root = new HuffNode();
  double op = 0;
  // verify the correct number of parameters
  if ( argc != 2 ) {
    cout << "Must supply the input file name as the only parameter" << endl;
    exit(1);
  }
  // attempt to open the supplied file; must be opened in binary
  // mode, as otherwise whitespace is discarded
  ifstream file(argv[1], ifstream::binary);
  // report any problems opening the file and then exit
  if ( !file.is_open() ) {
    cout << "Unable to open file '" << argv[1] << "'." << endl;
    exit(2);
  }
  // read in the first section of the file: the prefix codes
  while ( true ) {
    string character, prefix;
    // read in the first token on the line
    file >> character;
    // did we hit the separator?
    if ( (character[0] == '-') && (character.length() > 1) )
      break;
    // check for space
    if ( character == "space" )
      character = " ";
    // read in the prefix code
    file >> prefix;

    huffTree(root, character[0], prefix); //store in tree
    
    // do something with the prefix code
    /*  cout << "character '" << character << "' has prefix code '"
	<< prefix << "'" << endl; */
  }
  // read in the second section of the file: the encoded message
  stringstream sstm;
  while ( true ) {
    string bits;
    // read in the next set of 1's and 0's
    file >> bits;
    // check for the separator
    if ( bits[0] == '-' )
      break;

    //add to output:
    op += printTree(root, bits, 0);
    
    //add to stringstream
    sstm << bits;
  }

  cout << "\nThere were " << op << " symbols decoded from the file." << endl;

  //cout <<"The output is: " << endl;

  //printTree(root, bits,0);
  
  /* string allbits = sstm.str();
  // at this point, all the bits are in the 'allbits' string
  cout << "All the bits: " << allbits << endl;
  // close the file before exiting */
  file.close(); 

  
    
}
