/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return null;
        }
        //Node curr=head;
        Node phead = new Node();
        Node prev = phead;
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        //stack:1
        // 1<->2
        // 3
        //curr:1
        //prev:0<->1
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            curr.prev = prev;
            prev.next = curr;
            if (curr.next != null) {
                stack.add(curr.next);
            }
            if (curr.child != null) {
                stack.add(curr.child);
            }
            prev = curr;
            curr.child = null;
        }
        //but i want to remove phead node prev
        phead.next.prev = null;
        return phead.next;
    }
}