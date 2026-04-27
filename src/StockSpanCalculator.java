import java.util.Stack;
public class StockSpanCalculator {
    static Stack<Integer> indices = new Stack<>();
    public static void main(String[] args) {
        Integer [] span = calculateSpan(new int[]{100, 80, 60, 70, 60, 75, 85});
        for (Integer s : span) {
            System.out.print(s + " ");
        }

    }
    static Integer[] calculateSpan(int[] prices){

        Integer[] span = new Integer[prices.length];
        for(int i= 0; i<prices.length; i++){
            while(!indices.isEmpty() && prices[indices.peek()] <= prices[i]){
                    indices.pop();
                }
            if(indices.isEmpty() ){
                span[i] = i+1;
            } else{
                span[i] = i - indices.peek();
            }
            indices.push(i);

                    }
        return span;
    }

}
