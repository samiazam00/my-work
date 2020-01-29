/* Samreen Azam (sa3ntc)
 * 11/22/19
 *linkedlist.c */

#include <stdio.h>
#include <stdlib.h>

struct node { //struct for creating a new node for list
  struct node *next;
  int data; //value that each node holds
};

struct linked_list { //create the list with a head
  struct node *head;
};

int main() {
  int n; //how many values for list
  printf("Enter how many values to input :");
  scanf("%d", &n);

  struct linked_list *list = (struct linked_list*) malloc(sizeof (struct linked_list));
  list->head = NULL;
  struct node *node;
  
  for(int i = 0; i < n; i++) //add n nodes and initialize
    {
      int num;
      printf("Enter value %d: ", i);
      scanf("%d", &num);
      node = (struct node*) malloc(sizeof(struct node));
      node->data = num;
      node->next = list->head;
      list->head = node;
    }
	
  //print using iterator
  struct node *itr;
  itr = list->head;
  for (int i = 0; i < n; i++)
    {
      printf("%d\n",itr->data);
      itr = itr->next;
    }
  
  free(list);
  free(node);
  
  return 0;
}
