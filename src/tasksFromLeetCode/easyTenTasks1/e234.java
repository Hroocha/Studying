package tasksFromLeetCode.easyTenTasks1;

import java.util.ArrayList;
import java.util.Collections;

public class e234 {
    /* 234. Palindrome Linked List*/

    public static void main(String[] args) {
        ListNode n4 = new ListNode(1);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);
        System.out.println(isPalindrome(n4));
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> arrayList = new ArrayList<>();
        do {
            arrayList.add(head);
            head = head.next;
        } while (head != null);
        ArrayList<ListNode> halfOneOfList;
        ArrayList<ListNode> halfTwoOfList;
        if (arrayList.size() % 2 != 0) {
            halfOneOfList = new ArrayList<>(arrayList.subList(0, arrayList.size() / 2 + 1));
            halfTwoOfList = new ArrayList<>(arrayList.subList(arrayList.size() / 2, arrayList.size()));
        } else {
            halfOneOfList = new ArrayList<>(arrayList.subList(0, arrayList.size() / 2));
            halfTwoOfList = new ArrayList<>(arrayList.subList(arrayList.size() / 2, arrayList.size()));
        }
        Collections.reverse(halfTwoOfList);

        boolean result = false;
        if (halfOneOfList.size() == halfTwoOfList.size()) {
            result = true;
            for (int i = 0; i < halfOneOfList.size(); i++) {
                if (halfOneOfList.get(i).val != halfTwoOfList.get(i).val) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
