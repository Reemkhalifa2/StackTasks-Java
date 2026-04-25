import java.util.*;
public class StringReversalAndPalindrome {
    public static void main(String[] args) {
        System.out.println(reverseString("Hello"));
    }
    public static String reverseString(String str){
        Stack<Character> reverse = new Stack<>();
        String result = "";
        for(int i=0 ; i<str.length(); i++){
            reverse.push(str.charAt(i));
        }

        while(!reverse.isEmpty()){
                result += reverse.pop();
            }

        return result;


    }

}
