import java.util.Stack;
public class LargestRectangleInHistogram {
    public static void main(String[] args) {

    }

    static Integer findLargestRectangle(int[] heights){
        Stack<Integer> stack = new Stack<>();
        Integer maxArea = 0;
        Integer i = 0;
        while (i < heights.length) {

            // push if stack empty OR current >= top
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                System.out.println("Push index: " + i);
                i++;
            } else {
                int top = stack.pop();
                System.out.println("Pop index: " + top);

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = heights[top] * width;
                System.out.println("Area = " + heights[top] + " * " + width + " = " + area);

                maxArea = Math.max(maxArea, area);
            }
        }

        // process remaining stack
        while (!stack.isEmpty()) {
            int top = stack.pop();

            int width;
            if (stack.isEmpty()) {
                width = i;
            } else {
                width = i - stack.peek() - 1;
            }

            int area = heights[top] * width;
            System.out.println("Final Area = " + area);

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


}

}
