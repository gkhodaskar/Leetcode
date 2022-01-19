// Problem Description: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode prev = new ListNode(0);
    prev.next = head;
    ListNode slow = prev;
    ListNode fast = prev;
    int i =0;
    while(i<=n && fast!=null){
        fast = fast.next;
        i++;
    }

    while(fast!=null){
        slow=slow.next;
        fast=fast.next;
    }

    slow.next = slow.next.next;

    return prev.next;
}
