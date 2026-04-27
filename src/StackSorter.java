import java.util.Stack;
public class StackSorter {
    static Stack<Integer> unsortedStack = new Stack<>();
    static Stack<Integer>  temporaryStack = new Stack<>();
    public static void main(String[] args) {
        unsortedStack.push(34);
        unsortedStack.push(31);
        unsortedStack.push(98);
        unsortedStack.push(92);
        unsortedStack.push(23);
        System.out.println(sortStack(unsortedStack));

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
        static Stack<Integer> sortStackRecursive(Stack<Integer> stack){

        }


}
