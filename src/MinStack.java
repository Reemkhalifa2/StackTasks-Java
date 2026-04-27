import java.util.Stack;

public class MinStack {

    static Stack<Integer> mainStack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {


    }

    static void push(int value) {
        mainStack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }

    }
    static Integer pop() {

        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        minStack.pop();


        return mainStack.pop();
    }


}