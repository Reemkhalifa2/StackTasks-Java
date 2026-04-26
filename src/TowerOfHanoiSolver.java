import java.util.Stack;
public class TowerOfHanoiSolver {
    static Stack<Integer> A = new Stack<>();
    static Stack<Integer> B = new Stack<>();
    static Stack<Integer> C = new Stack<>();
    public static void main(String[] args) {

    }
    void initializePegs(int numDisks){
        for(int i =numDisks; i!=0;i--){
            A.push(i);
        }
    }




}
