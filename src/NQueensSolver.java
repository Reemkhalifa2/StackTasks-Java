import java.util.Stack;

public class NQueensSolver {
    static class Position {
        int row, col;

        Position(int r, int c) {
            row = r;
            col = c;
        }

        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }
    public static void solve(int n) {

        Stack<Position> stack = new Stack<>();
        int row = 0;
        int[] cols = new int[n]; // نتابع آخر عمود جربناه في كل row

        while (row >= 0) {

            boolean placed = false;

            while (cols[row] < n) {

                Position pos = new Position(row, cols[row]);

                if (isSafe(pos, stack)) {
                    stack.push(pos);
                    System.out.println("Push: " + pos);

                    displayBoard(stack, n);

                    cols[row]++; // نحفظ مكاننا
                    row++;       // ننزل للصف اللي بعده

                    if (row == n) {
                        System.out.println("✅ Solution: " + stack);
                        displayBoard(stack, n);

                        // backtrack
                        Position last = stack.pop();
                        row = last.row;
                        break;
                    }

                    placed = true;
                    break;
                } else {
                    cols[row]++;
                }
            }

            if (!placed) {
                cols[row] = 0; // reset

                if (!stack.isEmpty()) {
                    Position last = stack.pop();
                    System.out.println("Pop: " + last);

                    row = last.row;
                } else {
                    break;
                }
            }
        }
    }

}
