import java.util.Stack;
public class StockSpanCalculator {
    static Stack<Integer> indices = new Stack<>();
    public static void main(String[] args) {
        Integer[] prices = {100, 80, 60, 70, 60, 75, 85};
        displayResults(prices, calculateSpan(prices));
        displayResults(prices, calculateSpanBruteForce(prices));

    }

    static Integer[] calculateSpan(Integer[] prices){
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
    static Integer[] calculateSpanBruteForce(Integer[] prices){
        Integer[] span = new Integer[prices.length];
        for(int i=0; i<prices.length; i++){
            Integer currentSpan = 1;
            for(int j =i-1; j>-1; j--){
                if(prices[j] <= prices[i]){
                    currentSpan++;
                }else{
                    break;
                }
            }
            span[i] = currentSpan;

        }
        return span;
    }
    static void displayResults(Integer[] prices, Integer[] spans){
        System.out.println("\nPrices:");
        for (int p : prices) {
            System.out.print(p + " ");
        }
        System.out.println("\nSpans:");
        for (int s : spans) {
            System.out.print(s + " ");
        }
    }





}
