import java.util.Stack;
public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Integer a = 12;
        Integer b = 45;
        Integer c = 0;
        Integer d = -7;
        Integer e = 78;
        Integer f = 5;
        System.out.println("===========================");
        System.out.printf("%-10s %-15s %-15s", "Decimal", "Binary", "Integer.toBinaryString()");
        System.out.println();
        String binary = decimalToBinary(a);
        String javaBinary = Integer.toBinaryString(a);
        System.out.printf("%-10d %-15s %-15s",a,binary, javaBinary);


    }
    public static String decimalToBinary(int decimal){
        Stack<Integer> binaryStack = new Stack<>();
        String binaryString = "";
        //Handle edge cases (zero, negative numbers)
        if(decimal==0){
            binaryString += 0;
        }
        decimal = Math.abs(decimal);
        while(decimal !=0){
            binaryStack.push(decimal%2);
            decimal = decimal/2;
        }
        while(!binaryStack.isEmpty()){
           binaryString += binaryStack.pop();
        }
        return binaryString;
    }
    public static void displayConversionProcess(int decimal){
        Stack<Integer> binaryStack = new Stack<>();
        if (decimal == 0) {
            System.out.println("0 / 2 = 0, remainder = 0");
        }
        decimal = Math.abs(decimal);
        while(decimal !=0){
            Integer quotient = decimal/2;
            System.out.println("Quotient  :"+ quotient);
            Integer remainder = decimal%2;
            binaryStack.push(remainder);
            System.out.println("Remainder : "+ remainder);
            decimal = decimal/2;
        }
        System.out.println(binaryStack);
    }
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            int digit = binary.charAt(i)-'0' ;
            decimal = decimal * 2 + digit;
        }

        return decimal;
    }

}
