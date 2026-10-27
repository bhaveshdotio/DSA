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
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr=head;
        while(curr!=null&&curr.next!=null){
            ListNode nextcurr=curr.next;
            int value=gcd(curr.val,nextcurr.val);
            ListNode node=new ListNode(value);
            node.next=nextcurr;
            curr.next=node;
            curr=nextcurr;//or you would have done in othercase curr=curr.next;
        }
        return head;
    }
}