
import java.util.Stack;
public class InfixExpressionEvaluator {
    static Stack<Double> operandStack = new Stack<>();
    static Stack<Character> operatorStack = new Stack<>();
    public static void main(String[] args) {
        String exp = "3+4*2";
        System.out.println("Expression: " + exp);
        System.out.println("Result: " + evaluate(exp));

    }
    public static Double evaluate(String expression){for (int i = 0; i < expression.length(); i++) {
        char ch = expression.charAt(i);
        if (ch == ' ') continue;
        if (isNumber(ch)) {
            StringBuilder num = new StringBuilder();
            while (i < expression.length() && isNumber(expression.charAt(i))) {
                num.append(expression.charAt(i));
                i++;
            }
            i--;
            operandStack.push(Double.parseDouble(num.toString()));
        }
        else if (ch == '(') {
            operatorStack.push(ch);
        }
        else if (ch == ')') {
            while (operatorStack.peek() != '(') {
                char op = operatorStack.pop();
                double b = operandStack.pop();
                double a = operandStack.pop();
                operandStack.push(applyOperation(a, b, op));
            }
            operatorStack.pop();
        }

        else if (isOperator(ch)) {

            while (!operatorStack.isEmpty()
                    && operatorStack.peek() != '('
                    && getPrecedence(operatorStack.peek()) >= getPrecedence(ch)) {

                char op = operatorStack.pop();

                double b = operandStack.pop();
                double a = operandStack.pop();

                operandStack.push(applyOperation(a, b, op));
            }

            operatorStack.push(ch);
        }
    }
        while (!operatorStack.isEmpty()) {

            char op = operatorStack.pop();

            double b = operandStack.pop();
            double a = operandStack.pop();

            operandStack.push(applyOperation(a, b, op));
        }

        return operandStack.pop();

    }

    static double applyOperation(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            case '^': return Math.pow(a, b);
            case '%': return a % b;
        }

        throw new RuntimeException("Invalid operator");
    }
    static Integer getPrecedence(char operator){
        int precedence = -1;
        if(operator =='^'){
            precedence=3;
        }
        else if(operator=='/'||operator=='*'||operator=='%'){
            precedence = 2;
        }else if(operator=='+'||operator=='-'){
            precedence = 1;
        }
        return precedence;
    }
    static Boolean isOperator(char ch){
        return (ch=='+'||ch=='-'||ch=='/'||ch=='*'||ch=='%'||ch=='^');
    }
    static Boolean isNumber(char ch){
        return Character.isDigit(ch);
    }


}
