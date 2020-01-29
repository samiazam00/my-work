/* Samreen Azam (sa3tnc)
 * 9/9/19
 * List.cpp
 */

#include <iostream>
#include <string>
using namespace std;
#include "List.h"
#include "ListNode.h"
#include "ListItr.h"

//Constructor(no parameters):
List::List()
{
  head = new ListNode;
  tail = new ListNode;
  head->previous = NULL; //nothing comes before head
  head->next = tail;
  tail->previous = head;
  tail->next=NULL; //nothing comes after tail
  count = 0; //start count at 0
}

//Copy constructor:
List::List(const List& source)
{
  head = new ListNode;
  tail = new ListNode;
  head->next = tail;
  tail->previous = head;
  count = 0; //start count at 0
  ListItr iter(source.head->next); //check next
  while(!iter.isPastEnd()) //make deep copy
    {
      insertAtTail(iter.retrieve());
      iter.moveForward();
    }
}

//Destructor:
List::~List()
{
  makeEmpty();
  delete head;
  delete tail;
}

//Implement methods:

List& List::operator=(const List& source) //equals method
{
  if(this == &source)
    return *this;
  else {
   this->makeEmpty();
    ListItr iter(source.head->next); //check next
    while(!iter.isPastEnd()) //iterate through
      {
	insertAtTail(iter.retrieve()); //add current at tail
	iter.moveForward(); 
      }
  }
  return *this;
} 
 
bool List::isEmpty() const
{
  return count <= 0 ; //list will be empty if there are no nodes and counter = 0 
}

void List::makeEmpty()
{
  while(!isEmpty())
    {
      remove(first().retrieve()); //keep removing first value
    }
}

ListItr List::first() 
{
  ListItr *lst = new ListItr(head->next); 
  if(lst->isPastEnd())
    {
      lst->moveBackward();
      return *lst;	}

  return *lst;
}

ListItr List::last() 
{
  ListItr *lst = new ListItr(tail->previous); 
  if(lst->isPastBeginning())
    {
      lst->moveForward();
      return *lst;	}

  return *lst;
}

void List::insertAfter(int x, ListItr position)
{
  ListNode *n = new ListNode;
  n->value = x;
  n->previous = position.current;  //new node will be after current position
  n->next = position.current->next; 
  count++; //added another node so counter increments
  //change the other nearby nodes so that two nodes' aren't pointing to the same next or previous:
  position.current->next->previous = n; //now the next node's previous pointer is pointing to n :)
  position.current->next = n;
  
}
void List::insertBefore(int x, ListItr position)
{
  ListNode *n = new ListNode;
  n->value = x;
  n->next = position.current;  //new node will come before current position
  n->previous = position.current->previous;
  position.current->previous = n;
  n->previous->next = n; 
  count++; //added another node so counter increments
}

void List::insertAtTail(int x)
{
  ListNode *n = new ListNode;
  n->value = x;
  n->next = tail;
  n->previous = tail->previous;
  n->previous = tail->previous;
  tail->previous->next = n; 
  tail->previous = n;
  count++;
}

void List::remove(int x) 
{
  ListItr *lst = new ListItr(find(x));
  lst->moveForward();
  if(!lst->isPastEnd())
    {
      lst->moveBackward();
      lst->current->previous->next = lst->current->next; //the node before the one to be removed will now point to current's next node
      lst->current->next->previous = lst->current->previous; //the node after the removed one now points to the node before current
      count--;  //removed a node so counter decrements 
    }
  delete lst; //node is deleted from memory, bye bye!
}

ListItr List::find(int x)
{
  ListItr *it = new ListItr(first());
  while(!it->isPastEnd())
    {
      if(it->current->value == x)
	return *it;
      else
       it->moveForward();
    }
  return *it;
}

int List::size() const
{
  return count;
}

void printList(List& source, bool direction)  
{
  if(direction) //direction = true
    {
      ListItr *it = new ListItr(source.first());
      while(!it->isPastEnd()) //iterate through and print out list forward
	{
	  cout << it->current->value;
	  it->moveForward();
	}
    }
  else //direction = false
    {
      ListItr *it = new ListItr(source.last());
      while(!it->isPastBeginning()) //print backwards
	{
	  cout << it->current->value << "  ";
	  it->moveBackward();
	}
      
    }
}
