
import java.util.Stack;
public class InfixExpressionEvaluator {
    static Stack<Integer> operandStack = new Stack<>();
    static Stack<Integer> operatorStack = new Stack<>();
    public static void main(String[] args) {

    }
    public static void evaluate(String expression){

    }
    static Boolean isOperator(char ch){
        return (ch=='+'||ch=='-'||ch=='/'||ch=='*'||ch=='%'||ch=='^');
    }
    static Boolean isNumber(char ch){
        return Character.isDigit(ch);
    }


}
