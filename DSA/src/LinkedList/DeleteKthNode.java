package LinkedList;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/*
Time Complexity: O(N)
 */
public class DeleteKthNode {
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

    private static Node deleteKthNode(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        //k=1 means delete head
        if (k == 1) {
            head = head.next;
            return head;
        }
        int position = 2;
        Node prev = head;
        Node current = head.next;
        while (current != null && position < k) {
            prev = current;
            current = current.next;
            position++;
        }
        //k is greater than length of list
        if (current == null) {
            return head;
        }
        //delete kth node
        prev.next = current.next;
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
        System.out.println("Before deleting a node:");
        List<Integer> result = traverseSinglyLinkedList(n1);
        System.out.println(result);
        System.out.println("Enter value of K");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Node resultAfterDelete = deleteKthNode(n1, k);
        List<Integer> resultPostDelete = traverseSinglyLinkedList(resultAfterDelete);
        System.out.println(resultPostDelete);
        sc.close();

    }
}
