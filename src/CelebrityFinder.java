import java.util.Stack;
public class CelebrityFinder {

    private static double[][] matrix;

    public static void main(String[] args) {
        Integer[][] matrix = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };
        System.out.println(findCelebrity(matrix));

    }
    static boolean knows(int i, int j) {
        return matrix[i][j] == 1;
    }
    static Integer findCelebrity(int n) {
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
