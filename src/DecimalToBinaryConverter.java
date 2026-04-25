import java.util.Stack;
public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Stack<Integer> reminders = new Stack<>();
        Integer a = 12;
        Integer b = 45;
        Integer c = 0;
        Integer d = -7;
        Integer e = 78;
        Integer f = 5;
        System.out.println(decimalToBinary(a));

    }
    public static String decimalToBinary(int decimal){
        Stack<Integer> binaryStack = new Stack<>();
        String binaryString = "";
        while(decimal !=0){
            binaryStack.push(decimal%2);
            decimal = decimal/2;
        }
        while(!binaryStack.isEmpty()){
           binaryString += binaryStack.pop();
        }
        return binaryString;
    }
}
