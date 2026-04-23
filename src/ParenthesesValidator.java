import java.util.Stack;

public class ParenthesesValidator {
    public static void main(String[] args) {
        String test1 = "{[]()}";
        String test2 = "[]]";
        String test3 = "{}()";
        String test4 = "";
        String test5 = "(()[]{{}}))";
        System.out.println(isBalanced(test1));
        System.out.println(isBalanced(test2));
        System.out.println(isBalanced(test3));
        System.out.println(isBalanced(test4));
        System.out.println(isBalanced(test5));
    }

    public static String isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) return "Not Balanced";
                if (ch == ')' && stack.peek() == '(' ||
                        ch == ']' && stack.peek() == '[' ||
                        ch == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return "Not Balanced";
                }
            }
        }
        return stack.isEmpty() ? "Balanced" : "Not Balanced";
    }
}