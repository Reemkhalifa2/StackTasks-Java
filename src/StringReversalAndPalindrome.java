import java.util.*;

public class StringReversalAndPalindrome {

    public static void main(String[] args) {

        // Test strings
        String str1 = "Hello";
        String str2 = "Hi";
        String str3 = "all";
        String str4 = "Mom";
        String str5 = "LOL";

        // Test case 1
        System.out.println("---------- Test Case 1 ----------------");
        System.out.println("String " + str1);
        System.out.println("Reversed String " + reverseString(str1));
        System.out.println("Palindrome Status  " + isPalindrome(str1));

        // Test case 2
        System.out.println("---------- Test Case 2 ----------------");
        System.out.println("String " + str4);
        System.out.println("Reversed String " + reverseString(str4));
        System.out.println("Palindrome Status  " + isPalindrome(str4));
    }

    // Method to reverse string using stack
    public static String reverseString(String str) {

        Stack<Character> reverse = new Stack<>(); // stack to store characters
        String result = "";

        // push each character into stack
        for (int i = 0; i < str.length(); i++) {
            reverse.push(str.charAt(i));
        }

        // pop characters to build reversed string
        while (!reverse.isEmpty()) {
            result += reverse.pop();
        }

        return result; // return reversed string
    }

    // Method to check if string is palindrome
    public static Boolean isPalindrome(String str) {

        String reversed = reverseString(str); // reverse the string

        // compare original with reversed (ignore case)
        return reversed.equalsIgnoreCase(str);
    }
}