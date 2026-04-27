import  java.util.Stack;
public class NextGreaterElementFinder {
    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 10};
        int[] result = findNextGreaterElement(arr);
        displayResults(arr, result);
        int[] result2 = findNextGreaterElementCircular(arr);
        displayResults(arr, result2);

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
    public static void displayResults(int[] arr, int[] result) {

        System.out.println("\nOriginal Array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println("\n\nNext Greater Element Result:");
        System.out.println("Index\tValue\tNext Greater");
        System.out.println("--------------------------------");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "\t" + arr[i] + "\t" + result[i]);
        }

        System.out.println("--------------------------------");
    }

}
