package task.stack;

import java.util.Stack;

public class Stacks {
    public Stack<Integer> sortStackUsingStack(Stack<Integer> stack) {
        Stack<Integer> helper = new Stack<>();

        while (!stack.isEmpty()) {
            int toPush = stack.pop();
            while (!helper.isEmpty() && helper.peek() > toPush) {
                stack.push(helper.pop());
            }
            helper.push(toPush);
        }
    }
}
