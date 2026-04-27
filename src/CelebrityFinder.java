import java.util.Stack;
public class CelebrityFinder {
    private static int[][] matrix;
    static Stack<Integer> people = new Stack<>();
    public static void main(String[] args) {
        matrix = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };
        System.out.println(findCelebrity(matrix.length));
        System.out.println(findCelebrityBruteForce(matrix.length));
    }

    private static Integer findCelebrity(int n) {
        for(int i=0; i< n; i++){
            people.push(i);
        }
        while (people.size() > 1){
            int a = people.pop();
            int b = people.pop();
            if(knows(a, b)){
                people.push(b);
            } else {
                people.push(a);
            }
        }
        int candidate = people.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    static boolean knows(int i, int j) {
        return matrix[i][j] == 1;
    }

    static Integer findCelebrityBruteForce(int n) {

        for (int i = 0; i < n; i++) {
            boolean isCelebrity = true;

            for (int j = 0; j < n; j++) {

                if (i != j && (knows(i, j) || !knows(j, i))) {
                    isCelebrity = false;
                    break;
                }
            }

            if (isCelebrity) {
                return i;
            }
        }

        return -1;
    }
}