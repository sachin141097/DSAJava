package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeFromTail {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static List<Integer> traverseSinglyLinkedList(Node head) {
        Node temp = head;
        List<Integer> ans = new ArrayList<>();
        while (temp != null) {
            ans.add(temp.data);
            temp = temp.next;
        }
        return ans;
    }

    private static Node deleteNodeFromEnd(Node head) {
        if (head == null) {
            return null;
        }
        //only one node
        if (head.next == null) {
            head = null;
            return head;
        }
        //find the second last node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        //remove the tail
        current.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        Node n4 = new Node(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("Before deleting a node from end");
        List<Integer> result = traverseSinglyLinkedList(n1);
        System.out.println(result);
        System.out.println("After deleting a node from end");
        Node newHead = deleteNodeFromEnd(n1);
        List<Integer> resultAfterNodeDelete = traverseSinglyLinkedList(newHead);
        System.out.println(resultAfterNodeDelete);
    }
}
