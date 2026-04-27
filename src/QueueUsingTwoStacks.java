import java.util.Stack;
public class QueueUsingTwoStacks {
    static Stack<Integer> inputStack = new Stack<>();
    static Stack<Integer> outputStack = new Stack<>();
    public static void main(String[] args) {


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

    }
}
