import java.util.Stack;
public class PostfixEvaluator {
    public static void main(String[] args) {
        String exp1 = "3 4 +";
        String exp2 = "10 2 *";
        String exp3 = "5 2 -";
        String exp4 = "8 4 /";
        String exp5 = "7 3 %";
        String exp6 = "2 3 4 * +";

        System.out.println("Result: " + evaluatePostfix(exp1));
        System.out.println("Result: " + evaluatePostfix(exp2));
        System.out.println("Result: " + evaluatePostfix(exp3));
        System.out.println("Result: " + evaluatePostfix(exp4));
        System.out.println("Result: " + evaluatePostfix(exp5));
        System.out.println("Result: " + evaluatePostfix(exp6));
    }
    public static Integer evaluatePostfix(String expression) {
        Stack<Integer> operandsStack = new Stack<>();

        for(int i = 0 ; i > expression.length();i++){
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                operandsStack.push(Integer.parseInt(String.valueOf(ch)));
            }
            else {
                int b = operandsStack.pop();
                int a = operandsStack.pop();
                int result = 0;
                if(ch =='+' ) {
                    result = a + b;
                }else if(ch == '-'){ result = a - b;}
                else if(ch == '*'){ result = a * b;}
                else if(ch == '/'){ result = a / b;}

                operandsStack.push(result);
            }
        }


        return operandsStack.pop();
    }
}