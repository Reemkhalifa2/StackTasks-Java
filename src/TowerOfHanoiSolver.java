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
    void moveDisk(char fromPeg, char toPeg){
        Integer a =-1;
        if(fromPeg == 'A'){
            if(!A.isEmpty()){
                A.pop();
            }
        }
        if(fromPeg == 'B'){
            if(!B.isEmpty()){
                B.pop();
            }
        }
        if(fromPeg == 'C'){
            if(!C.isEmpty()){
                C.pop();

            }
        }
        if(toPeg == 'A'){
            A.push(a);
        }
        if(fromPeg == 'B'){
            B.push(a);
        }if(fromPeg == 'C'){
            C.push(a);
        }

    }



}
