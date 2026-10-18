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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode phead=new ListNode(0);
        ListNode l1=list1;
        ListNode l2=list2;
        ListNode l3=phead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                l3.next=l1;
                l1=l1.next;
                l3=l3.next;
            }else{
                l3.next=l2;
                l2=l2.next;
                l3=l3.next;
            }
        }
        if(l1==null){
            l3.next=l2;
        }else{
            l3.next=l1;
        }
        return phead.next;
    }
}