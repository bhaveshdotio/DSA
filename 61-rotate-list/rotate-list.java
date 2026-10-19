/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0){
            return head;
        }
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr=head;
        ListNode tail=head;
        int size=0;
        //1 2 3 4 5 null
        //        c
        //size=5
        while(curr!=null){//final of list
            tail=curr;
            curr=curr.next;
            size++;
        }
        k=k%size;
        if(k==0){
            return head;
        }
        int diff=size-k;//5-2=3
        int i=0;
        curr=head;
        while(i<diff-1){
            i++;
            curr=curr.next;
        }
        ListNode prehead=curr.next;
        curr.next=null;
        tail.next=head;
        return prehead;
    }
}