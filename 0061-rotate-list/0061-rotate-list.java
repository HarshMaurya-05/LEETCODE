class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Length find karo
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Extra rotations remove karo
        k = k % length;

        if (k == 0) {
            return head;
        }

        // 3. List ko circular banao
        tail.next = head;

        // 4. New tail find karo
        int stepsToNewTail = length - k;

        ListNode newTail = tail;

        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // 5. New head
        ListNode newHead = newTail.next;

        // 6. Circle break karo
        newTail.next = null;

        return newHead;
    }
}