package LinkedList;

import java.util.ArrayList;
import java.util.List;

/*
Time Complexity: O(N)
 */
class ListNode {
    int data;
    ListNode next;

    ListNode(int x) {
        data = x;
        next = null;
    }
}

public class TraverseSinglyLinkedList {
    private static List<Integer> traverseSinglyLinkedList(ListNode head) {
        ListNode temp = head;
        List<Integer> ans = new ArrayList<>();
        while (temp != null) {
            ans.add(temp.data);
            temp = temp.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(7);

        //Linking the nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        List<Integer> result = traverseSinglyLinkedList(n1);
        System.out.println(result);
    }
}
