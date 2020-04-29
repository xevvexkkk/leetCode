package q2_两数相加;

public class OfficalSolution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(){};
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        //进位
        int carry = 0;
        //对dummyHead的两个引用 curr会重置 但是 dummyHead 不会
        ListNode curr = dummyHead;
        while (p != null || q != null){
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }
        if(carry > 0 ){
            curr.next = new ListNode(1);
        }
        //头结点是0 所以去next过滤
        return dummyHead.next;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(2);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        a.next = a1;
        a1.next = a2;
        ListNode b = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(7);
        b.next = b1;
        b1.next = b2;
        addTwoNumbers(a,b);
    }
}
