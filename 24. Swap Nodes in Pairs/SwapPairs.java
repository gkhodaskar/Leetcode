// Problem Description: https://leetcode.com/problems/swap-nodes-in-pairs

class SwapPairs {
    public ListNode swapPairs(ListNode head){
        if(head==null||head.next==null)
            return head;

        // Get first two nodes
        ListNode first=head; // pointer to head
        ListNode second=head.next;

        // Recursive call & swap
        first.next=swapPairs(second.next);
        second.next=first; // becomes new head
        // Return new head
        return second;
    }
}