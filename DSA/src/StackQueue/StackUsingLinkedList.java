package StackQueue;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    private Node top;

    public LinkedListStack() {
        top = null;
    }

    //Push Operation
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println(value + " pushed to the stack");
    }

    //Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    //Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        Node temp = top;
        System.out.print("Stack ELements:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.display();

        System.out.println("Top element: " + st.peek());

        System.out.println("Popped element: " + st.pop());

        st.display();

    }
}
