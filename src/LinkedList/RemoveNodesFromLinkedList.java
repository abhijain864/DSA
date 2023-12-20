package LinkedList;

public class RemoveNodesFromLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNodes(ListNode head) {
        ListNode curr = reverseList(head);
        ListNode tail = null;
        int currMax = 0;
        while (curr!=null) {
            ListNode temp = curr.next;
            if (curr.val >= currMax) {
                currMax = curr.val;
                curr.next = tail;
                tail = curr;
            }
            curr = temp;
        }
        return tail;
    }

    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while (head!=null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }

}
