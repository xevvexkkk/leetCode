package q19_删除链表的倒数第N个节点;

public class OfficalSolution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        while (first != null){
            length++;
            first = first.next;
        }
        length += -n;
        first = dummy;
        while (length > 0){
            length--;
            first = first.next;
        }
        //注意此处是 用first  不要用 second
        first.next = first.next.next;
        return dummy.next;
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

        removeNthFromEnd3(n1,2);
    }

    //解法2 双指针
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i=1 ; i<=n+1 ; i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    // 记录倒数节点数。
    static int nums = 0;
    public static ListNode removeNthFromEnd3(ListNode head, int n) {

        // 如果节点为空，直接返回并初始化计数器为 0 。
        if(head == null){
            nums = 0;
            return null;
        }
        // 递归遍历每个节点的下一个节点。
        head.next = removeNthFromEnd3(head.next,n);
        // 从最后一个节点开始倒数计数。
        nums++;
        // 数到倒数第 n 个节点，则删除当前节点返回倒数第 n - 1 个节点。
        if(nums == n) {
            return head.next;
        }
        return head;
    }


}
