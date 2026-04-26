
import java.util.Stack;
public class InfixToPostfixConverter {
    static Stack<Character> Postfix = new Stack<>();
    public static void main(String[] args) {
        infixToPostfix("1+5*(4*8-5)-2");
        System.out.println(Postfix);


    }
    public static void infixToPostfix(String infix){
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
        System.out.println(postfix);
    }
}
