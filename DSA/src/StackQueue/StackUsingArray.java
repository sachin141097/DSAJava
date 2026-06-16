package StackQueue;

class ArrayStack {
    private final int[] arr;
    private int top;
    private final int capacity;

    public ArrayStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;

    }

    //Push operation
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
        }
        arr[++top] = value;
        System.out.println(value + " pushed to stack");
    }

    //Pop operation
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    //peek operation
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    //check if stack isEmpty
    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        System.out.println("Stack Elements:");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        ArrayStack st = new ArrayStack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.display();
        System.out.println("Top element " + st.peek());
        System.out.println("Popped element " + st.pop());
        st.display();

    }
}
