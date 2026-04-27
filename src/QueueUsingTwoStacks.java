import java.util.Stack;
public class QueueUsingTwoStacks {
    static Stack<Integer> inputStack = new Stack<>();
    static Stack<Integer> outputStack = new Stack<>();
    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);

        System.out.println(dequeue());
        System.out.println(dequeue());
        enqueue(40);
        System.out.println(peek());
        System.out.println(dequeue());
        System.out.println(dequeue());

        System.out.println("InputStack: " + inputStack);
        System.out.println("OutputStack: " + outputStack);
        System.out.println("Queue Size: " + size());


    }
    static void enqueue(Integer i){
        inputStack.push(i);
    }
    static  Integer dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        while (!inputStack.isEmpty()){
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();
    }
    static Integer peek(){
        if(outputStack.isEmpty()){
            System.out.println("Queue is empty!");
        }
        return outputStack.peek();
    }
    static boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    static int size() {
        return inputStack.size() + outputStack.size();
    }
}
