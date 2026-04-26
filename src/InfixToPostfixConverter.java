
import java.util.Stack;
public class InfixToPostfixConverter {
    static Stack<Character> Postfix = new Stack<>();
    public static void main(String[] args) {
        String result =infixToPostfix("1+5*(4*8-5)-2");

        System.out.println(evaluatePostfix(infixToPostfix(result)));


    }
    public static String infixToPostfix(String infix){
        String postfix = "";
        for(int i=0; i<infix.length(); i++){
            char ch = infix.charAt(i);
            if(Character.isDigit(ch)){
                postfix +=ch;

            }else{
                if(ch=='('){
                    Postfix.push(ch);
                } else if (ch == ')') {
                    while (!Postfix.isEmpty() && Postfix.peek() != '('){
                        postfix += Postfix.pop();
                    }
                    Postfix.pop();
                } else if (ch == '^') {
                    Postfix.push(ch);
                } else if (ch == '*' || ch =='/'|| ch =='%') {
                    while (!Postfix.isEmpty() &&
                            (Postfix.peek() == '*' || Postfix.peek() == '/' ||Postfix.peek() == '%' || Postfix.peek() == '^')) {
                        postfix += Postfix.pop();
                    }
                    Postfix.push(ch);
                }
                else if (ch == '+' || ch =='-') {
                    while (!Postfix.isEmpty() && Postfix.peek() != '('){
                        postfix += Postfix.pop();
                    }
                    Postfix.push(ch);
                    }

            }
        }
        while(!Postfix.isEmpty()){
            postfix += Postfix.pop();
        }
        return postfix;
    }
    public static Integer evaluatePostfix(String expression) {

        // Check if expression is empty
        if(expression.isEmpty()){
            throw new RuntimeException("Empty expression!");
        }

        // Stack to store numbers
        Stack<Integer> operandsStack = new Stack<>();

        String[] exp = expression.split("");

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
    static void getPrecedence(char operator){
        if(operator == '^'){
            System.out.println(operator + "operator precedence is 3");
        }if(operator == '*' || operator =='/'|| operator =='%'){
            System.out.println(operator + "operator precedence is 2");
        }if(operator == '+' || operator =='-'){
            System.out.println(operator + "operator precedence is 1");
        }
    }
    static void isOperator(char ch){
        if(ch == '*' || ch =='/'|| ch =='%'||ch == '^'|| ch == '+' || ch =='-'){
            System.out.println(ch + " is an operator");
        }else {
            System.out.println(ch + " is not an operator");

        }
    }

}
