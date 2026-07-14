package StackQueue;

import java.util.Stack;

public class MinStack {
    private static class Entry {
        int val;
        int min;

        Entry(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private final Stack<Entry> stack = new Stack<>();

    private void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Entry(val, val));
            return;
        }
        int currentMin = stack.peek().min;
        if (val < currentMin) {
            stack.push(new Entry(val, val));
        } else {
            stack.push(new Entry(val, currentMin));
        }
    }

    private void pop() {
        stack.pop();
    }

    private int top() {
        return stack.peek().val;
    }

    private int getMin() {
        return stack.peek().min;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(5);
        System.out.println("push(5)  -> top: " + ms.top() + " min: " + ms.getMin());

        ms.push(3);
        System.out.println("push(3)  -> top: " + ms.top() + " min: " + ms.getMin());

    }
}
