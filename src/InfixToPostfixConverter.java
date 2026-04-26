
import java.util.Stack;
public class InfixToPostfixConverter {
    static Stack<Character> Postfix = new Stack<>();
    public static void main(String[] args) {

    }
    static void infixToPostfix(String infix){
        String postfix = "";
        for(int i=0; i<infix.length(); i++){
            char ch = infix.charAt(i);
            if(Character.isDigit(ch)){
                postfix +=ch;

            }else{
                if(ch=='('){
                    Postfix.push(ch);
                } else if (ch == '^') {
                    Postfix.push(ch);
                } else if (ch == '*' || ch =='/'|| ch =='%') {
                    if(Postfix.peek()=='+'||Postfix.peek()=='-'){
                        Postfix.push(ch);
                    }else {

                    }

                }
            }
        }
    }
}
