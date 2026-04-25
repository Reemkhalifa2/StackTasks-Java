import java.util.Stack;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {

        // Test decimal numbers
        Integer a = 12;
        Integer b = 45;
        Integer c = 0;
        Integer d = -7;
        Integer e = 78;
        Integer f = 5;

        // Print table header
        System.out.println("===========================");
        System.out.printf("%-10s %-15s %-15s", "Decimal", "Binary", "Integer.toBinaryString()");
        System.out.println();

        // Convert first number to binary using custom method
        String binary = decimalToBinary(a);

        // Convert using Java built-in method for comparison
        String javaBinary = Integer.toBinaryString(a);

        // Print result row
        System.out.printf("%-10d %-15s %-15s", a, binary, javaBinary);
    }

    public static String decimalToBinary(int decimal) {

        // Stack to store remainders (0s and 1s)
        Stack<Integer> binaryStack = new Stack<>();

        String binaryString = "";

        // Handle edge case: if number is zero
        if (decimal == 0) {
            binaryString += 0;
        }

        // Make number positive (handling negative values)
        decimal = Math.abs(decimal);

        // Step 1: divide by 2 and store remainders in stack
        while (decimal != 0) {
            binaryStack.push(decimal % 2); // push remainder
            decimal = decimal / 2;         // update quotient
        }

        // Step 2: pop from stack to build binary string
        while (!binaryStack.isEmpty()) {
            binaryString += binaryStack.pop();
        }

        return binaryString;
    }

    public static void displayConversionProcess(int decimal) {

        // Stack to store remainders step-by-step
        Stack<Integer> binaryStack = new Stack<>();

        // Handle zero case separately
        if (decimal == 0) {
            System.out.println("0 / 2 = 0, remainder = 0");
        }

        // Convert negative numbers to positive
        decimal = Math.abs(decimal);

        // Show step-by-step division process
        while (decimal != 0) {

            Integer quotient = decimal / 2;
            System.out.println("Quotient  :" + quotient);

            Integer remainder = decimal % 2;
            binaryStack.push(remainder);

            System.out.println("Remainder : " + remainder);

            decimal = decimal / 2;
        }

        // Print final stack contents
        System.out.println(binaryStack);
    }

    public static int binaryToDecimal(String binary) {

        int decimal = 0;

        // Convert binary string to decimal
        for (int i = 0; i < binary.length(); i++) {

            int digit = binary.charAt(i) - '0';

            decimal = decimal * 2 + digit;
        }

        return decimal;
    }
}