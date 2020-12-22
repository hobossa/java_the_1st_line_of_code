package TryDataContainer;

import java.util.Stack;

public class TryStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
