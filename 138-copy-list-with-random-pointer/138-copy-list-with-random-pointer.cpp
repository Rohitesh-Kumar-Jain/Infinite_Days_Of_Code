/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head==NULL) return head;
        Node* cur=head;
        Node* head2= new Node(cur->val);
        cur=cur->next;
        Node* cur2=head2;
        while(cur){
            Node* temp= new Node(cur->val);
            cur=cur->next;
            cur2->next=temp;
            cur2=temp;
        }
        cur2->next=NULL;
        // Till now the linked list with next pointer is copied successfully,now just need to copy the random pointer brother.
        Node* trv= head;
        Node* trv2= head2;
        while(trv){
            Node* ahead=trv->next;
            trv->next=trv2;
            Node* achead=trv2->next;
            trv2->next=ahead;
            trv=ahead;
            trv2=achead;
            
        }
        // The two lists have been merged successfully;
        // ie head= 7->7->13->13->11->11->10->10->1->1->NULL
        Node* pass=head;
        while(pass){
            pass->next->random=pass->random ? pass->random->next: pass->random ;
            pass=pass->next->next;
        }
        // the list have been copied successfully now we will separate the two lists.
        Node* sep1=head;
        Node* sep2=head2;
        while(sep1->next->next){
            sep1->next=sep1->next->next;
            sep2->next=sep2->next->next;
            sep1=sep1->next;
            sep2=sep2->next;
        }
        sep1->next=NULL;
        return head2;
    }
};