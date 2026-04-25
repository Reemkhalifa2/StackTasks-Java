import java.util.*;
public class StringReversalAndPalindrome {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2= "Hi";
        String str3 = "all";
        String str4 = "Mom";
        String str5 = "LOL";
        System.out.println("---------- Test Case 1 ----------------");
        System.out.println("String " + str1);
        System.out.println("Reversed String " + reverseString(str1));
        System.out.println("Palindrome Status  " + isPalindrome(str1));System.out.println("String " + str1);
        System.out.println("Reversed String " + reverseString(str1));
        System.out.println("Palindrome Status  " + isPalindrome(str1));


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
    public static Boolean isPalindrome(String str){
        String reversed = reverseString(str);
        return reversed.equalsIgnoreCase(str);

    }

}
