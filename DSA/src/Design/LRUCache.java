package Design;

import java.util.HashMap;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> m = new HashMap<>();
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(Node delNode) {
        Node prev = delNode.prev;
        Node next = delNode.next;
        prev.next = next;
        next.prev = prev;
    }

    private void put(int key, int value) {
        if (m.containsKey(key)) {
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);

        }
        if (m.size() == cap) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        m.put(key, head.next);
    }

    private int get(int key) {
        if (m.containsKey(key)) {
            Node resNode = m.get(key);
            int ans = resNode.val;
            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            m.put(key, head.next);
            return ans;
        }
        return -1;
    }

    private void printCache() {
        Node curr = head.next;

        System.out.print("Cache (MRU -> LRU): ");

        while (curr != tail) {
            System.out.print("(" + curr.key + "," + curr.val + ") ");
            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.put(4, 40);
        cache.printCache();
        cache.get(1);
        cache.printCache();
        cache.put(5, 50);

    }
}
