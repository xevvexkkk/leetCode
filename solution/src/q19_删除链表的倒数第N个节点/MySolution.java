package q19_删除链表的倒数第N个节点;

public class MySolution {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        int i = 0;
        int length = 0;
        ListNode curr = head;
        while ( curr != null){
            length++;
            curr = curr.next;
        }
        curr = dummyHead;
        while(curr != null && i < length - n ){
            i++;
            curr.next = new ListNode(head.val);
            curr = curr.next;
            head = head.next;
        }
        if(i == length - n){
            curr.next = head.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        removeNthFromEnd(n1,2);
    }

    /**
     * 此方法对于 [1,2] 2的情况会出现错误
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndBadSolution(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode first = head;
        ListNode second = head;
        ListNode current = dummy;
        for (int i = 1; i <= n; i++) {
            second = second.next;
        }
        while (second != null) {
            current.next = new ListNode(first.val);
            current = current.next;
            if (second.next != null) {
                first = first.next;
            }
            if (second.next == null && n != 1) {
                current.next = second;
            }
            second = second.next;
        }
        return dummy.next;
    }
}
