
import java.util.Stack;
public class InfixExpressionEvaluator {
    static Stack<Integer> operandStack = new Stack<>();
    static Stack<Character> operatorStack = new Stack<>();
    public static void main(String[] args) {

    }
    public static void evaluate(String expression){
        for(int i= 0 ;i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(isOperator(ch)){
                operatorStack.push(ch);
            } else if (ch == '(') {
                operatorStack.push(ch);
            }
            else if (ch == ')') {

                while (operatorStack.peek() != '(') {
                    applyOperation();
                }

                operatorStack.pop(); // remove '('
            }
            if(isNumber(ch)){
                operandStack.push(Integer.parseInt(String.valueOf(ch)));
            }
        }

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
