//DoubLyLinkedlist {tc is equal or better of dlyll as compared to sgyll}
public class DoublyLinkedList {
    DoublyLinkedList next;
    DoublyLinkedList prev;
    int val;

    public DoublyLinkedList(int x) {
        val = x;
    }
}

class MyLinkedList {
    int size;
    DoublyLinkedList head;
    DoublyLinkedList tail;

    public MyLinkedList() {
        size = 0;
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        head.next = tail;
        tail.prev = head;
    }

    // 0-1-2-3-0
    // size=3
    //index<0||index>=size
    // h 1 2 3
    //   3 2 1 t
    //jh=index+1
    //jt=size-index
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        if (index + 1 < size - index) {
            DoublyLinkedList curr = head;
            int i = 0;
            while (i < index + 1) {
                curr = curr.next;
                i++;
            }
            return curr.val;
        } else {
            DoublyLinkedList curr = tail;
            int i = 0;
            while (i < size - index) {
                curr = curr.prev;
                i++;
            }
            return curr.val;
        }
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 0-1-2-3-0
    //i 0 1 2 3
    //size=3
    //h 0 1 2 3
    //  3 2 1 0 t
    //jh=idx
    //jt=size-idx
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index < size - index) {
            DoublyLinkedList pred = head;
            int i = 0;
            while (i < index) {
                pred = pred.next;
                i++;
            }
            size++;
            DoublyLinkedList node = new DoublyLinkedList(val);
            DoublyLinkedList succ = pred.next;
            node.next = succ;
            node.prev = pred;
            pred.next = node;
            succ.prev = node;
        } else {
            DoublyLinkedList succ = tail;
            int i = 0;
            while (i < size-index) {
                succ = succ.prev;
                i++;
            }
            size++;
            DoublyLinkedList node = new DoublyLinkedList(val);
            DoublyLinkedList pred = succ.prev;
            node.next = succ;
            node.prev = pred;
            pred.next = node;
            succ.prev = node;
        }
    }
    // 0-1-2-3-0
    //size=3
    // i 0 1 2
    // i<0 i>=size
    // h 0 1 2
    //   2 1 0 t
    //jh=idx
    //jt=size-inx-1 
    public void deleteAtIndex(int index) {
        if(index<0||index>=size){
            return;
        }
        if(index<size-index-1){
            DoublyLinkedList pred=head;
            int i=0;
            while(i<index){
                pred=pred.next;
                i++;
            }
            DoublyLinkedList succ=pred.next.next;
            pred.next=succ;
            succ.prev=pred;
            size--;
        }else{
            DoublyLinkedList succ=tail;
            int i=0;
            while(i<size-index-1){
                succ=succ.prev;
                i++;
            }
            DoublyLinkedList pred=succ.prev.prev;
            pred.next=succ;
            succ.prev=pred;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */