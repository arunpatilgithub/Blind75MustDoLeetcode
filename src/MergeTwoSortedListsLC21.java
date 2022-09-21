/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">LC21. Merge Two Sorted Lists</a>
 */
public class MergeTwoSortedListsLC21 {

    public static void main(String[] args) {

        //int[] list1 = {1, 2, 4};
        //int[] list2 = {1, 3, 4};
        int[] list1 = {};
        int[] list2 = {0};

        ListNode listNode1 = null;
//        ListNode listNode1 = new ListNode(list1[0], null);
//        ListNode list1PrevNode = listNode1;
//
//        for (int i = 1; i < list1.length; i++) {
//
//            ListNode newNode = new ListNode(list1[i], null);
//            list1PrevNode.next = newNode;
//            list1PrevNode = newNode;
//        }

        ListNode listNode2 = new ListNode(list2[0], null);
        ListNode list2PrevNode = listNode2;

        for (int j = 1; j < list2.length; j++) {

            ListNode newNode = new ListNode(list2[j], null);
            list2PrevNode.next = newNode;
            list2PrevNode = newNode;
        }

        ListNode mergedNode = mergeTwoLists(listNode1, listNode2);
        System.out.println(mergedNode);

    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(0);
        ListNode prevNode = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prevNode.next = list1;
                list1 = list1.next;
            } else {
                prevNode.next = list2;
                list2 = list2.next;
            }

            prevNode = prevNode.next;
        }

        if (list1 != null) {
            prevNode.next = list1;
        } else if (list2 != null) {
            prevNode.next = list2;
        }

        return head.next;
    }


}
