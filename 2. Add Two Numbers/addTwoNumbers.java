
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // n = size(l1) + size(l2)
    // TC: O(n), SC: O(1)
    ListNode n1 = l1, n2 = l2;
    ListNode result = new ListNode(0); // create dummy node
    ListNode curr = result;
    int sum = 0;

    while(n1 != null || n2 != null){
        sum /= 10; // Used to calculate carry

        if(n1!=null){ // if list 1 still has more digits
            sum += n1.val;
            n1 = n1.next;
        }
        if(n2!=null){ // if list 2 still has more digits
            sum += n2.val;
            n2 = n2.next;
        }

        curr.next=new ListNode(sum % 10);
        curr=curr.next;

    }

    if (sum/10 == 1)
        curr.next = new ListNode(1);

    return result.next;
}
