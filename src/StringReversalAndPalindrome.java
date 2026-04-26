import java.util.Stack;
public class StringReversalAndPalindrome {
    public static void main(String[] args) {

    }
    public static String isPalindrome(String str){
        Stack<String> reverseStack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            reverseStack.push(String.valueOf(ch));
        }
        String reverse ="";
        for(String s : reverse){
            reverse +=s;

        }
    }

}
