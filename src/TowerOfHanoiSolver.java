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
                disk1=A.pop();
            }
        }
        if(fromPeg == 'B'){
            if(!B.isEmpty()){
                disk1= B.pop();
            }
        }
        if(fromPeg == 'C'){
            if(!C.isEmpty()){
                disk1=C.pop();

            }
        }

        Integer disk2 =-1;
        if(toPeg == 'A'){
            if(!A.isEmpty()){
                disk2=A.pop();
            }
        }
        if(toPeg == 'B'){
            if(!B.isEmpty()){
                disk2= B.pop();
            }
        }
        if(toPeg == 'C'){
            if(!C.isEmpty()){
                disk2=C.pop();

            }
        }
        return disk2>disk1;
    }





}
