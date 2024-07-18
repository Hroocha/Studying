package tasksFromLeetCode.easyTenTasks4;

public class e21 {
    /*  21. Merge Two Sorted Lists */

    public static void main(String[] args) {
        ListNode n6 = new ListNode(4);
        ListNode n5 = new ListNode(3, n6);
        ListNode n4 = new ListNode(1, n5);

        ListNode n3 = new ListNode(4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode root = mergeTwoLists(n1, n4);
        while (root != null){
            System.out.println(root.val);
            root = root.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        return list1 == null ? list2 : list1;
    }

    public static class ListNode {
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
//
//    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        } else if (list2 == null) {
//            return list1;
//        }
//        int count = 1;
//        ListNode listsCount = list1;
//        while (listsCount != null) {
//            listsCount = listsCount.next;
//            count++;
//        }
//        listsCount = list2;
//        while (listsCount != null) {
//            listsCount = listsCount.next;
//            count++;
//        }
//        ListNode[] unionList = new ListNode[count];
//        unionLists(0, unionList, list1, list2);
//        int j = 0;
//        for (int i = 0; i < unionList.length + 1; i++) {
//            if (i + 1 != unionList.length + 1) {
//                if (unionList[j] != null) {
//                    unionList[j++].next = unionList[j];
//                }
//            }
//        }
//        return unionList[0];
//    }
//
//    public static void unionLists(int i, ListNode[] union, ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            while (list2 != null) {
//                union[i++] = list2;
//                list2 = list2.next;
//            }
//            return;
//        }
//        if (list2 == null) {
//            while (list1 != null) {
//                union[i++] = list1;
//                list1 = list1.next;
//            }
//            return;
//        }
//        if (list1.val <= list2.val) {
//            union[i++] = list1;
//            list1 = list1.next;
//        } else { // list1 > list2
//            union[i++] = list2;
//            list2 = list2.next;
//        }
//        unionLists(i, union, list1, list2);
//    }


}
