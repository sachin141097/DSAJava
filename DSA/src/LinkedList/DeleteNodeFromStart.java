package LinkedList;

import java.util.ArrayList;
import java.util.List;

/*
Time Complexity: O(1)
 */
public class DeleteNodeFromStart {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static List<Integer> traverseSinglyLinkedList(Node head) {
        List<Integer> ans = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            ans.add(temp.data);
            temp = temp.next;
        }
        return ans;
    }

    private static Node deleteNodeFromStart(Node head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        Node n4 = new Node(7);

        //Linking the nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("Before deleting a node");
        List<Integer> result = traverseSinglyLinkedList(n1);
        System.out.println(result);
        System.out.println("After deleting a node");
        Node newHead = deleteNodeFromStart(n1);
        List<Integer> resultAfterNodeDelete = traverseSinglyLinkedList(newHead);
        System.out.println(resultAfterNodeDelete);

    }
}
