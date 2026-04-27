import java.util.Stack;

public class MinStack {

    static Stack<Integer> mainStack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        push(5);
        push(2);
        push(8);
        pop();
        push(1);

        display();


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

    static Integer peek() {

        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return mainStack.peek();
    }
    static int getMin() {

        if (minStack.isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }

        return minStack.peek();
    }

    static void display() {

        System.out.println("Main Stack: " + mainStack);
        System.out.println("Min Stack : " + minStack);
        System.out.println("Current Min: " + getMin());
        System.out.println("----------------------");
    }



}