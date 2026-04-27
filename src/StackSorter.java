import java.util.Stack;

public class StackSorter {
    public static void main(String[] args) {
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(34);
        stack2.push(31);
        stack2.push(98);
        stack2.push(92);
        stack2.push(23);

        Stack<Integer> sortedIterative = sortStack(stack2);
        displayStack(sortedIterative, "Sorted Stack (Iterative)");

        // ================= RECURSIVE SORT =================
        Stack<Integer> stack3 = new Stack<>();
        stack3.push(34);
        stack3.push(31);
        stack3.push(98);
        stack3.push(92);
        stack3.push(23);

        sortStackRecursive(stack3);
        displayStack(stack3, "Sorted Stack (Recursive)");
    }

    static Stack<Integer> sortStack(Stack<Integer> stack) {

        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {

            int temp = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        return tempStack;
    }

    static void sortStackRecursive(Stack<Integer> stack) {

        if (!stack.isEmpty()) {

            int temp = stack.pop();

            sortStackRecursive(stack);

            insertInSortedOrder(stack, temp);
        }
    }

    static void insertInSortedOrder(Stack<Integer> stack, int value) {

        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();

        insertInSortedOrder(stack, value);

        stack.push(temp);
    }

    static void displayStack(Stack<Integer> stack, String name) {

        System.out.println("\n" + name + ":");

        if (stack.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        System.out.print("[Bottom -> Top] ");

        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }

        System.out.println();
    }
}