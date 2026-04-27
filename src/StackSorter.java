import java.util.Stack;
public class StackSorter {
    static Stack<Integer> unsortedStack = new Stack<>();
    static Stack<Integer>  temporaryStack = new Stack<>();
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(34);
        input.push(31);
        input.push(98);
        input.push(92);
        input.push(23);
        System.out.println(sortStack(input));

    }
    static Stack<Integer> sortStack(Stack<Integer> stack){
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!temporaryStack.isEmpty() && temporaryStack.peek() > temp)
            {
                stack.push(temporaryStack.pop());
            }
            temporaryStack.push(temp);
        }
        return temporaryStack;

    }


}
