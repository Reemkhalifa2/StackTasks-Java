import  java.util.Stack;
public class NextGreaterElementFinder {
    public static void main(String[] args) {

    }
    public static int[] findNextGreaterElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // Pop smaller or equal elements from stack
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            // If stack is empty, no greater element to the right
            result[i] = st.isEmpty() ? -1 : arr[st.peek()];

            // Push current index onto the stack
            st.push(i);
        }
        return result;
    }

}
