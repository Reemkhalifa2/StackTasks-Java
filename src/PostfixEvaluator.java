import java.util.Stack;

public class PostfixEvaluator {
    public static void main(String[] args) {
        String exp1 = "1 2 +";
        String exp2 = "10 2 *";
        String exp3 = "5 2 -";
        String exp4 = "8 0 /";
        String exp5 = "7 3 %";
        String exp6 = "2 3 4 * % ";

        System.out.println(exp1 + " = " + evaluatePostfix(exp1));
        System.out.println(exp2 + " = " + evaluatePostfix(exp2));
        System.out.println(exp3 + " = " + evaluatePostfix(exp3));
        System.out.println(exp4 + " = " + evaluatePostfix(exp4));
        System.out.println(exp5 + " = " + evaluatePostfix(exp5));
        System.out.println(exp6 + " = " + evaluatePostfix(exp6));

    }
    public static Integer evaluatePostfix(String expression) {

        if(expression.isEmpty()){
            throw new RuntimeException("Empty expression!");
        }
        Stack<Integer> operandsStack = new Stack<>();
        String[] exp = expression.split(" ");
        for (String x : exp) {
            if (Character.isDigit(x.charAt(0))) {
                operandsStack.push(Integer.parseInt(x));
            } else {
                if(operandsStack.isEmpty()){

                }
                Integer b = operandsStack.pop();
                Integer a = operandsStack.pop();
                Integer result = 0;
                if (x.equals("+")) {
                    result = a + b;
                } else if (x.equals("-")) {
                    result = a - b;
                } else if (x.equals("*")) {
                    result = a * b;
                } else if (x.equals("/")) {
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero!");
                    }
                    result = a / b;
                } else if (x.equals("%")) {
                    result = a % b;
                }else{
                    throw new RuntimeException("Invalid operation!");
                }
                operandsStack.push(result);
            }
        }
        return operandsStack.pop();

    }
}