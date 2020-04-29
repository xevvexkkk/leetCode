package q2_两数相加;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MySolution {

  static class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
          val = x;
      }

      ListNode(){};
  }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        int num1,num2 = 1 ;
        List<Integer> list1 = new LinkedList();
        List<Integer> list2 = new LinkedList();
        while(l1.next != null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        list1.add(l1.val);
        while(l2.next != null){
            list2.add(l2.val);
            l2 = l2.next;
        }
        list2.add(l2.val);
        int min = (list1.size() > list2.size() ? list2.size() : list1.size());
        List<Integer> resultList = new LinkedList();
        if(list1.size() >= list2.size()){
            for(int i=0 ; i<list1.size() ; i++){
                Integer offset = list2.size() -i-1;
                int bit = list1.get(i) + (offset >=0 ? list2.get(i) : 0);
                int oriBit = list1.get(i) + (offset >=0 ? list2.get(i) : 0);
                //如果>=10 且还有进位
                if(bit >= 10 && list1.size()-i>=2){
                    list1.set(i+1 ,list1.get(i+1) + 1);
                    bit -= 10;
                }
                //如果 >=10 且无进位
                if(bit >= 10 && i == list1.size() - 1){
                    bit -= 10;
                }
                resultList.add(bit);
                //如果 >=10 且无进位
                if(i == list1.size() - 1 && oriBit >= 10){
                    resultList.add(1);
                }
            }
        }

        if(list1.size() < list2.size()){
            for(int i=0 ; i<list2.size() ; i++){
                Integer offset = list1.size() -i-1;
                int bit = list2.get(i) + (offset >=0 ? list1.get(i) : 0);
                int oriBit = list2.get(i) +( offset >=0 ? list1.get(i) : 0);
                if(bit >= 10 && list2.size()-i>=2){
                    list2.set(i+1 ,list2.get(i+1) + 1);
                    bit -= 10;
                }
                if(bit >= 10 && i == list2.size() - 1){
                    bit -= 10;
                }
                resultList.add(bit);
                if(i == list2.size() - 1 && oriBit >= 10){
                    resultList.add(1);
                }
            }
        }
        return buildListNode(null,resultList,0);
    }

    private static ListNode buildListNode(ListNode node , List<Integer> resultList ,int i){

        if(node == null){
            node = new ListNode();

        }
        if(i == resultList.size()-1){
//            node.next = null;
            node.val = resultList.get(i);
            i++;
            return node;
        }
        node.val = resultList.get(i);
        i++;
        node.next = buildListNode(node.next , resultList , i);
        return node;
    }

    public static void main(String[] args){
//        int i = removeDuplicatesOffical(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
//        int[] nums = new int[]{1,3,5,6};
//        removeElement(nums,2);
//        searchInsert(nums,5);
//        System.out.println(Arrays.toString(nums));
        ListNode a = new ListNode(1);
//        ListNode a1 = new ListNode(4);
//        ListNode a2 = new ListNode(3);
//        a.next = a1;
//        a1.next = a2;
        ListNode b = new ListNode(9);
        ListNode b1 = new ListNode(9);
//        ListNode b2 = new ListNode(4);
        b.next = b1;
//        b1.next = b2;
        addTwoNumbers(a,b);
    }
}