import java.util.Stack;
public class TowerOfHanoiSolver {
    static Stack<Integer> A = new Stack<>();
    static Stack<Integer> B = new Stack<>();
    static Stack<Integer> C = new Stack<>();
    static int count = 0;
    public static void main(String[] args) {
        int n = 3;
        initializePegs(n);
        System.out.println("Initial State:");
        displayPegs();
        solveHanoi(n, 'A', 'C', 'B');

        System.out.println("Total Moves: " + count);
        System.out.println("Theoretical Minimum: " + (Math.pow(2, n) - 1));

    }
    static void initializePegs(int numDisks){
        for(int i =numDisks; i>=1;i--){
            A.push(i);
        }
    }
    static void moveDisk(char fromPeg, char toPeg){
        if(isValidMove(fromPeg, toPeg)) {//check if it valid move

        Integer disk = -1;
        // POP from source
        if(fromPeg == 'A' && !A.isEmpty()){
            disk = A.pop();
        }
        else if(fromPeg == 'B' && !B.isEmpty()){
            disk = B.pop();
        }
        else if(fromPeg == 'C' && !C.isEmpty()){
            disk = C.pop();
        }

        // PUSH to destination
        if(toPeg == 'A'){
            A.push(disk);
        }
        else if(toPeg == 'B'){
            B.push(disk);
        }
        else if(toPeg == 'C'){
            C.push(disk);
        }}
        count++;
    }
    public static Boolean isValidMove(char fromPeg, char toPeg){

        Integer disk1 = -1;
        Integer disk2 = -1;

        // source top
        if(fromPeg == 'A' && !A.isEmpty()){
            disk1 = A.peek();
        }
        else if(fromPeg == 'B' && !B.isEmpty()){
            disk1 = B.peek();
        }
        else if(fromPeg == 'C' && !C.isEmpty()){
            disk1 = C.peek();
        }

        // destination top
        if(toPeg == 'A' && !A.isEmpty()){
            disk2 = A.peek();
        }
        else if(toPeg == 'B' && !B.isEmpty()){
            disk2 = B.peek();
        }
        else if(toPeg == 'C' && !C.isEmpty()){
            disk2 = C.peek();
        }

        if(disk1 == -1) return false;   // no disk to move
        if(disk2 == -1) return true;    // empty destination

        return disk1 < disk2;
    }
    static void solveHanoi(int n, char from, char to, char aux) {
        // Base case
        if (n == 1) {
            moveDisk(from, to);
            return;
        }
        solveHanoi(n - 1, from, aux, to);
        moveDisk(from, to);
        displayPegs();
        solveHanoi(n - 1, aux, to, from);
    }
    static void displayPegs(){
        System.out.println("A peg: " + A);
        System.out.println("B peg: " + B);
        System.out.println("C peg: " + C);
    }



}
