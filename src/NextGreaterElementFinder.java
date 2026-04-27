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
    public static int[] findNextGreaterElementCircular(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
        }
        for (int i = 2 * arr.length - 1; i >= 0; i--) {

            int current = arr[i % arr.length];

            while (!st.isEmpty() && current >= arr[st.peek()]) {
                st.pop();
            }
            if (i < arr.length) {
                if (!st.isEmpty()) {
                    result[i] = arr[st.peek()];
                }
            }

            st.push(i % arr.length);
        }

        return result;
    }
    displayResults(int[] arr, int[] result

}
