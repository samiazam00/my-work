// Samreen Azam (sa3tnc)
//9/8/19     
//ListItr.cpp

#include <iostream>
#include <string>
using namespace std;
#include "ListItr.h"
#include "List.h"
#include "ListNode.h"
 
//Default constructor:     
ListItr::ListItr()
{
  current = NULL;
  current->next = NULL;
  current->previous = NULL;

}

//Copy Constructor:
ListItr::ListItr(ListNode *theNode)
{
  current = theNode;
  current->next = theNode->next;
  current->previous = theNode->previous;
}

//Implementing methods:
bool ListItr::isPastEnd() const
{
  return ( current->next == NULL);
 
}

bool ListItr::isPastBeginning() const
{
  return (current->previous == NULL);
    
}

void ListItr::moveForward()
{
  if(!isPastEnd()) //make sure next isn't null or else can't  move forward
    {
      current = current->next;
    }
}

void ListItr::moveBackward()
{
  if(!isPastBeginning()) 
    {
      current = current->previous;
    }
}

int ListItr::retrieve() const
{
  return current->value;
}
  
