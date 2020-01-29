/* Samreen Azam (sa3tnc)
 * 12/3/19
 * traveling.cpp */

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>

using namespace std;

#include "middleearth.h"

float computeDistance (MiddleEarth &me, string start, vector<string> dests);
void printRoute (string start, vector<string> dests);

int main (int argc, char **argv) {
    // check the number of parameters
    if ( argc != 6 ) {
        cout << "Usage: " << argv[0] << " <world_height> <world_width> "
             << "<num_cities> <random_seed> <cities_to_visit>" << endl;
        exit(0);
    }
    // we'll assume the parameters are all well-formed
    int width, height, num_cities, rand_seed, cities_to_visit;
    sscanf (argv[1], "%d", &width);
    sscanf (argv[2], "%d", &height);
    sscanf (argv[3], "%d", &num_cities);
    sscanf (argv[4], "%d", &rand_seed);
    sscanf (argv[5], "%d", &cities_to_visit);
    // Create the world, and select your itinerary
    MiddleEarth me(width, height, num_cities, rand_seed);
    vector<string> dests = me.getItinerary(cities_to_visit);
    
    // YOUR CODE HERE:
    string start = dests[0]; //!< name of the starting city
    //excluding the first city, sort the destinations:
    sort((dests.begin() + 1), dests.end());
    vector<string> result = dests; //!< Copy dests to new vector for storing result
    float shortest = computeDistance(me, start, dests); //!< Store the shortest path distance

    while(next_permutation(dests.begin()+1, dests.end())) {
      float current = computeDistance(me, start, dests); //!< store the distance b/w current 2 cities
        if(current < shortest) {
            shortest = current;
            result = dests;
        }
    }

    cout << "Your journey will take you along the path ";
    printRoute(start, result);
    cout << "and will have length " << shortest << endl;

    return 0;
}

/**@brief Method to compute the full distance of the cycle
 * @details Cycle  starts  at the 'start' parameter, goes to each of the cities  * in the dests vector IN ORDER, and ends back at the 'start' parameter. 
 * @param me = MiddleEarth object
 * @param start = city to start at
 * @param dests = vector of all the cities to go to
 * @return float to represent the distance b/w cities
*/
float computeDistance (MiddleEarth &me, string start, vector<string> dests) {
  float dist = 0.0; //!< this is the distance to be calculated and returned
  for(int i = 0; i < dests.size(); i++) //loop through vector
    {
      dist += me.getDistance(start, dests[i]); 
      start = dests[i]; //change start to go to next city
    }
  dist += me.getDistance(dests[dests.size()-1], dests[0]);
  //add dist b/w last and first cities, then return
  return dist; 
}

/** @brief This method will print the entire route, starting and ending at the
 * 'start' parameter.
 *  @details The output should be of the form:
 *  Erebor -> Khazad-dum -> Michel Delving -> Bree -> Cirith Ungol -> Erebor 
 *  @param start
 *  @param dests
*/
void printRoute (string start, vector<string> dests) {
  int x = 0; //!< use this variable to loop through vector
  while(x < dests.size()) {
    cout << dests[x] << " -> ";
    x++;
  }
  cout << start << endl; //lastly, print the starting city
}
