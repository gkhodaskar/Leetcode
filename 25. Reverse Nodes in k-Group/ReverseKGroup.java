// Problem Description: https://leetcode.com/problems/reverse-nodes-in-k-group

class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head,int k){
        if(head==null||head.next==null||k<2)return head;

        ListNode dummy=new ListNode(0); // dummy head
        dummy.next=head;
        ListNode pointer=dummy; // pointer to dummy head

        while(pointer!=null){

            ListNode node=pointer;
            // first check whether there are k nodes to reverse
            for(int i=0;i<k &&node!=null;i++){
                node=node.next;
            }

            if(node==null)break;
            // Now we know that we have k nodes, we will start from the first node

            // Reverse list of size k iteratively
            ListNode prev=null,next=null;
            ListNode curr=pointer.next; // points to currentt list head
            for(int i=0;i<k; i++){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }

            // Link reversed link to remaining nodes of original list
            ListNode tail=pointer.next; // point to the last head before reversal
            tail.next=curr;
            pointer.next=prev;
            pointer=tail; // now points to element before the section to be reversed
        }
        return dummy.next;
    }

// public ListNode reverseList(ListNode head, int k){
//       ListNode prev = null, curr = pointer.next, next = null;
//     for (int i = 0; i < k; i++) {
//         next = curr.next;
//         curr.next = prev;
//         prev = curr;
//         curr = next;
//     }
// }
}