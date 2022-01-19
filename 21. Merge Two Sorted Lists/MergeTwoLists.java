// Problem Description: https://leetcode.com/problems/merge-two-sorted-lists/

class MergeTwoLists{
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode s1=l1,s2=l2;

        // Dummy node to point at head of new merged list
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy; // traversing pointer

        // TC : O(m+n)
        // SC : O(1) -> No new list created. We only reallocate pointers to create one list
        while(s1!=null&&s2!=null){

            if(s1.val<=s2.val){
                curr.next=s1;
                s1=s1.next;
            }else{
                curr.next=s2;
                s2=s2.next;
            }
            curr=curr.next;
        }

        // Link remaining elements of the larger list
        curr.next=s1==null?s2:s1;

        return dummy.next;
    }
}