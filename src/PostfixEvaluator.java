import java.util.Stack;

public class PostfixEvaluator {
    public static void main(String[] args) {

        // Test expressions
        String exp1 = "1 2 +";
        String exp2 = "10 2 *";
        String exp3 = "5 2 -";
        String exp4 = "8 0 /"; // division by zero case
        String exp5 = "7 3 %";
        String exp6 = "2 3 4 * % ";

        // Print results
        System.out.println(exp1 + " = " + evaluatePostfix(exp1));
        System.out.println(exp2 + " = " + evaluatePostfix(exp2));
        System.out.println(exp3 + " = " + evaluatePostfix(exp3));
        System.out.println(exp4 + " = " + evaluatePostfix(exp4));
        System.out.println(exp5 + " = " + evaluatePostfix(exp5));
        System.out.println(exp6 + " = " + evaluatePostfix(exp6));
    }

    public static Integer evaluatePostfix(String expression) {

        // Check if expression is empty
        if(expression.isEmpty()){
            throw new RuntimeException("Empty expression!");
        }

        // Stack to store numbers
        Stack<Integer> operandsStack = new Stack<>();

        String[] exp = expression.split(" ");

        for (String x : exp) {

            if (Character.isDigit(x.charAt(0))) {
                operandsStack.push(Integer.parseInt(x));
            }
            else {
                // Make sure there are at least 2 numbers in stack
                if(operandsStack.size() < 2){
                    throw new RuntimeException("Invalid expression!");
                }

                Integer b = operandsStack.pop();
                Integer a = operandsStack.pop();

                Integer result = 0;

                // Perform operation based on operator
                if (x.equals("+")) {
                    result = a + b;
                }
                else if (x.equals("-")) {
                    result = a - b;
                }
                else if (x.equals("*")) {
                    result = a * b;
                }
                else if (x.equals("/")) {
                    // Check division by zero
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero!");
                    }
                    result = a / b;
                }
                else if (x.equals("%")) {
                    result = a % b;
                }
                else {
                    // Invalid operator
                    throw new RuntimeException("Invalid operation!");
                }

                // Push result back to stack
                operandsStack.push(result);
            }
        }
        // Final result (last element in stack)
        return operandsStack.pop();
    }
}