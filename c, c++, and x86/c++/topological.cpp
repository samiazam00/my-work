/* Samreen Azam (sa3tnc)
 * 12/2/19
 * topological.cpp */

#include <iostream>
#include <fstream>
#include <vector>
#include <queue>
#include <stdlib.h>
#include <string>
using namespace std;

/*!
  @brief The Vertex class creates vertices of a graph
*/
class Vertex {
public: 
string name;   //!< vertex name 
int indegree;   //!< number of edges 
  /**@brief Vertex constructor
   * @param string vn is the vertex name
   * @details Instantiate Vertex object, initialize data members by passing the name & setting indegree to 0 
   */
  Vertex(string vn)
  {
    name = vn;
    indegree = 0;
  }
}; //end of class 


/*!
 * @brief The Graph class creates Vertex objects & defines functions that relate them  
 */
class Graph {
public:
//Fields:
vector<Vertex*> vertices; /** vector of vertices (yay alliteration!) contained in graph */
int count; /** total number of vertices found in graph */
int max; /** max number of vertices graph can have */
vector<vector<int>> adj; /** adjacency matrix - edges between vertices */
			      
  /** @brief Graph constructor
  *@param int size (of the graph)
  *@details Instantiate a Graph by setting max = to the size value passed, starting with 0 vertices counted, and edge value = null
  **/  
Graph(int size){  //Constructor
 max = size;
 count = 0;
 vertices.resize(size); //call resize function to accomodate the num of vertices that can be held in graph
 //set all vertices equal to null
 for(int i = 0; i < size; i++){
   vertices[i] = NULL; 
 }
 int row = size; 
 int col = size; 
 adj.resize(row, vector<int>(col,0)); //resize
}
  /**@brief function name - insert
   *@details Void return type, add a Vertex object to the graph
   *@param Vertex* vtxPtr is a pointer to add to graph
   */
 void insert(Vertex* vtxPtr){  
    bool isIn = true; //!< true if the vertex is successfully added 
    for(int x = 0; x < max; x++) {
      if(vertices[x] != NULL) {
         if((vertices[x]->name) == (vtxPtr->name)) { //check if already in graph
	   vtxPtr = vertices[x];
           isIn = false; //not inserted if that is the case, so this becomes false
	}
      }
    }
    
    if(isIn == true) { //if it was inserted
      vertices[count] = vtxPtr;
      for(int k = 0; k < max; k++){
        adj[count][k] = 0; 
      }
      count++; //increment num of vertices
    }
  }

  /**@brief function name - makeEdge
   *@details Create edge and insert into graph
   *@param v1 = initial vertex
   *@param v2 = end vertex
   */
  void makeEdge(Vertex* v1, Vertex* v2){ 
    this->insert(v1);
    this->insert(v2); //start by inserting the 2 vertices into graph
    int row = atIndx(v1); //!< num of rows is currently just the index of v1
    int col = atIndx(v2); //!< num of columns is currently just index of v2
    adj[row][col] = 1;
    vertices[col]->indegree++; //increment num of edges 
  }
  /**@brief function name - atIndx
   *@details Determines index of a given vertex in the graph
   *@return the index number of vtx (-1 if not found)
   *@param Vertex *vtx - the vertex whose index must be found
   */
  int atIndx(Vertex* vtx){
    int j = 0; //!< looping variable, start at indx 0
    while(j < count){
      if((vertices[j]->name) == (vtx->name)){ //same name = vertex is found
	return j;
      }
      j++;
    }
    return -1; //not found
  }


  /**@brief function name - findWeight
   *@details determine whether the edge is created between two vertexs
   *@return 1 if edge exists, else ret 0
   *@param v1 = starting vertex
   *@param v2 = ending vertex
   *@todo v1 and v2 have to already exist in Graph
   */
  int findWeight(Vertex*& v1, Vertex*& v2){
    int row = atIndx(v1);
    int col = atIndx(v2);
    return adj[row][col]; // will either be 1 if theres an edge or 0 if not
  }
  /**@brief function name - topSort
   *@details Find topological sort of graph
   *No parameters, void return type
   */
  void topSort(){
    queue<Vertex*> vSort; //!< queue structure to store the sorted order of vertices
    int total = 0;  //!< keeps track of how many vertices pushed (to check if it will equal the graph count at the end)
    Vertex* v1,*v2;
    for(int y = 0; y < count; y++){
      v1 = vertices[y];
      if(v1->indegree == 0){
	vSort.push(v1);
      }
    } //Vertex with indegree of 0 at the front
    while(!vSort.empty()){
      v1 = vSort.front();  
      cout << v1->name << " ";
      vSort.pop();
      total++;
      for(int i = 0; i < count; i++){
	v2 = vertices[i];
	if(findWeight(v1,v2) == 1) {
	  v2->indegree--;
	  if(v2->indegree == 0) {
	    vSort.push(v2);
	  }
	}
      }
    }
    cout << endl;

    if(total != count){ 
      cout << "Cycle found here." << endl;
    }
  }

};

/**
 * @brief Main method for running the topological sort on a Graph
 * @param argc - num of paramters passed (should be 2 only)
 * @param argv - input file 
 */
int main (int argc, char **argv) {
  //note that some of the parts (like opening the file) of the code were influenced by code
  //provided by instructors in previous labs

  // check for correct number of parameters
  if ( argc != 2 ) {
    cout << "Must supply the input file name as the one and only parameter" << endl; 
    exit(1);
  }
  // attempt to open the supplied file
  ifstream fp(argv[1], ifstream::binary); //!< use ifstream to create fp, a file, that we must read
  // output error message if file can't be read
  if ( !fp.is_open() ) {
    cout << "Unable to open file '" << argv[1] << "'." << endl;
    exit(2);
  }

  Graph g = Graph(100); //!< create a Graph object with a size of 100
  string s1, s2; //!< strings to be read, part of file
  while( !fp.eof()){ //not end of file
    fp >> s1;
    fp >> s2;
   
    if((s1 == "0")&&(s2 == "0")){
      break;
    }

    //!< Initialize 2 vertices and create an edge between them:
    Vertex* v1 = new Vertex(s1); 
    Vertex* v2 = new Vertex(s2);
    g.makeEdge(v1,v2);
  }

  g.topSort(); //call topSort function to sort the vertices
  fp.close(); //close file prior to exiting
    
}
