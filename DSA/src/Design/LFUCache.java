package Design;

import java.util.HashMap;

class TestNode {
    //original key
    int key;

    //value associated with the key
    int value;

    //Number of times this key has been accessed

    int freq = 1;

    TestNode prev;
    TestNode next;

    TestNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DLL {
    TestNode head = new TestNode(-1, -1);
    TestNode tail = new TestNode(-1, -1);
    int size;

    DLL() {
        head.next = tail;
        tail.prev = head;
    }

    void addNode(TestNode node) {
        TestNode temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
        size++;
    }

    void deleteNode(TestNode node) {
        TestNode prev = node.prev;
        TestNode next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    // Remove Least Recently Used node
    TestNode removeLast() {

        if (size == 0)
            return null;

        TestNode node = tail.prev;
        deleteNode(node);

        return node;
    }

}

public class LFUCache {
    //key->Node
    private HashMap<Integer, TestNode> keyMap;

    //frequency->DLL
    private HashMap<Integer, DLL> freqMap;

    private int capacity;

    //Smallest frequency currently present
    private int minFreq;

    LFUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;

    }

    //Move a node from its old frequency list
    // to the next frequency list
    private void updateFrequency(TestNode node) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);
        oldList.deleteNode(node);

        //If this frequency becomes empty remove it from the map
        if (oldList.size == 0) {
            freqMap.remove(oldFreq);
            if (oldFreq == minFreq) {
                minFreq++;
            }
        }
        node.freq++;
        DLL newList = freqMap.get(node.freq);
        if (newList == null) {
            newList = new DLL();
            freqMap.put(node.freq, newList);
        }
        newList.addNode(node);
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        TestNode node = keyMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyMap.containsKey(key)) {
            TestNode node = keyMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }
        //Cache is full
        if (keyMap.size() == capacity) {
            DLL minList = freqMap.get(minFreq);
            TestNode victim = minList.removeLast();
            keyMap.remove(victim.key);
            if (minList.size == 0) {
                freqMap.remove(minFreq);
            }
        }
        TestNode newNode = new TestNode(key, value);

        DLL list = freqMap.get(1);

        if (list == null) {
            list = new DLL();
            freqMap.put(1, list);
        }

        list.addNode(newNode);

        keyMap.put(key, newNode);

        // Every new node has frequency = 1
        minFreq = 1;
    }

    private void printState() {

        System.out.println("--------------------------------");

        for (Integer freq : freqMap.keySet()) {

            System.out.print("Freq " + freq + " : ");

            TestNode curr = freqMap.get(freq).head.next;

            while (curr != freqMap.get(freq).tail) {
                System.out.print("(" + curr.key + "," + curr.value + ") ");
                curr = curr.next;
            }

            System.out.println();
        }

        System.out.println("minFreq = " + minFreq);
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 10);
        cache.put(1, 20);
        cache.printState();
        cache.put(2, 20);
        cache.printState();
        cache.put(3, 30);
        cache.printState();


    }
}
