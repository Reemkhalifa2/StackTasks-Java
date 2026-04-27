import java.util.Stack;
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 6, 2, 3};
        int[] arr2 = {2, 4};
        int[] arr3 = {1, 1, 1, 1};
        int[] arr4 = {5, 4, 3, 2, 1};

        for (int arr : arr2) {
            displayHistogram(arr2);
            int result = findLargestRectangle(arr2);
            displayResult(arr2, result);
            System.out.println("=====================");
        }

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
    public static int calculateArea(int[] heights, int start, int end, int height) {
        return height * (end - start + 1);
    }
    public static void displayHistogram(int[] heights) {
        System.out.println("\nHistogram:");

        int max = 0;
        for (int h : heights) {
            max = Math.max(max, h);
        }

        for (int i = max; i > 0; i--) {
            for (int h : heights) {
                if (h >= i)
                    System.out.print(" █ ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }

        for (int h : heights) {
            System.out.print("---");
        }
        System.out.println();
    }

    public static void displayResult(int[] heights, int maxArea) {
        System.out.print("Array: ");
        for (int h : heights) {
            System.out.print(h + " ");
        }
        System.out.println("\nMax Area = " + maxArea);
    }



}

