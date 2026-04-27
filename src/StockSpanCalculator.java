import java.util.Stack;
public class StockSpanCalculator {
    static Stack<Integer> indices = new Stack<>();
    public static void main(String[] args) {

    }
    static void calculateSpan(int[] prices){
        for(int i= 0; i<prices.length; i++){
            while(!indices.isEmpty() && prices[indices.peek()] <= prices[i]){
                    indices.pop();
                }
                int span =-1;
            if(indices.isEmpty() ){
                i+=1;
            } else{
                i-= indices.peek();
            }
                indices.push(i);

                    }
    }

}
