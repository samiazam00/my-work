/* Samreen Azam (sa3tnc)
 *9/26/19
 *bitcounter.cpp */

#include <iostream>
using namespace std;

int bitCounter(int n)
{
  if(n <= 1) //base case
    return 1;
  else
    return 1 + bitCounter(n/2); //recursive case
}


int main(int argc, char **argv)
{
  if(argc == 1)
    return 0;
  else
    {
      cout << bitCounter( atoi(argv[1]) );
      return 0;
    }
  
}
