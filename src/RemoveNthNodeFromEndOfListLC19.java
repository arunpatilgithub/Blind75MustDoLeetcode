/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">LC19. Remove Nth Node From End of List</a>
 */
public class RemoveNthNodeFromEndOfListLC19 {

    public static void main(String[] args) {

        //int[] head = {1, 2, 3, 4, 5};
        int[] head = {1};
        //int[] head = {1, 2};

        ListNode headNode = new ListNode(head[0], null);
        ListNode prevNode = headNode;

        for (int i = 1; i < head.length; i++) {

            ListNode newNode = new ListNode(head[i], null);
            prevNode.next = newNode;
            prevNode = newNode;
        }

        int n = 1;

        ListNode output = removeNthNode(headNode, n);

        System.out.println("Execution completed");
    }

    private static ListNode removeNthNode(ListNode head, int n) {
        int startIndex = 0;
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (startIndex < n - 1 && fastPointer != null) {
            fastPointer = fastPointer.next;
            startIndex++;
        }

        ListNode slowPointerPrevNode = null;

        while (fastPointer.next != null) {
            slowPointerPrevNode = slowPointer;
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        if (head == slowPointer) {
            head = slowPointer.next;
        } else {
            slowPointerPrevNode.next = slowPointer.next;
        }

        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }

    }

}
