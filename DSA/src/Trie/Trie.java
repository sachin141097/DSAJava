package Trie;

public class Trie {
    private static class TrieNode {
        // children[i] represents the next character.
        //
        // index 0 -> 'a'
        // index 1 -> 'b'
        // ...
        // index 25 -> 'z'
        //
        // null means that this character does not exist
        // from the current node.
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    // Root does not represent any character.
    private final TrieNode root = new TrieNode();

    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            // If this character does not exist,
            // create a new node.
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            // Move to the node representing this character.
            current = current.children[index];
        }

        // Mark the final node as the end of a complete word.
        current.isWord = true;
    }

    public boolean search(String word) {

        TrieNode node = findNode(word);

        // We need BOTH:
        //
        // 1. The path exists
        // 2. The path represents a complete word
        //
        // Otherwise "app" would incorrectly match "apple".
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {

        return findNode(prefix) != null;
    }

    private TrieNode findNode(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            // Required character is not present.
            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("appl"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("xyz"));
    }
}
