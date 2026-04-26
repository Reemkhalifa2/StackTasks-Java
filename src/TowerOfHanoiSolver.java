import java.util.Stack;
public class TowerOfHanoiSolver {
    static Stack<Integer> A = new Stack<>();
    static Stack<Integer> B = new Stack<>();
    static Stack<Integer> C = new Stack<>();
    public static void main(String[] args) {

    }
    static void initializePegs(int numDisks){
        for(int i =numDisks; i!=0;i--){
            A.push(i);
        }
    }
    static void moveDisk(char fromPeg, char toPeg){
        Integer disk =-1;
        if(fromPeg == 'A'){
            if(!A.isEmpty()){
                disk=A.pop();
            }
        }
        if(fromPeg == 'B'){
            if(!B.isEmpty()){
                disk= B.pop();
            }
        }
        if(fromPeg == 'C'){
            if(!C.isEmpty()){
                disk=C.pop();

            }
        }
        if(toPeg == 'A'){
            A.push(disk);
        }
        if(fromPeg == 'B'){
            B.push(disk);
        }if(fromPeg == 'C'){
            C.push(disk);
        }

    }
    public static Boolean isValidMove(char fromPeg, char toPeg){
        Integer disk1 =-1;
        if(fromPeg == 'A'){
            if(!A.isEmpty()){
                disk1=A.peek();
            }
        }
        if(fromPeg == 'B'){
            if(!B.isEmpty()){
                disk1= B.peek();
            }
        }
        if(fromPeg == 'C'){
            if(!C.isEmpty()){
                disk1=C.peek();

            }
        }

        Integer disk2 =-1;
        if(toPeg == 'A'){
            if(!A.isEmpty()){
                disk2=A.peek();
            }
        }
        if(toPeg == 'B'){
            if(!B.isEmpty()){
                disk2= B.peek();
            }
        }
        if(toPeg == 'C'){
            if(!C.isEmpty()){
                disk2=C.peek();

            }
        }
        return disk2>disk1;
    }
    static void solveHanoi(int n, char from, char to, char aux) {

        // Base case
        if (n == 1) {
            moveDisk(from, to);
            return;
        }

        // Step 1: move n-1 disks from source to auxiliary
        solveHanoi(n - 1, from, aux, to);

        // Step 2: move largest disk to destination
        moveDisk(from, to);

        // Step 3: move n-1 disks from auxiliary to destination
        solveHanoi(n - 1, aux, to, from);
    }






}
