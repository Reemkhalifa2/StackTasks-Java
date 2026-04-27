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

    public static void main(String[] args) {
        solve(4);
    }

    public static void solve(int n) {

        Stack<Position> stack = new Stack<>();
        int row = 0;
        int[] cols = new int[n];
        while (row >= 0) {

            boolean placed = false;

            while (cols[row] < n) {
                Position pos = new Position(row, cols[row]);
                if (isSafe(pos, stack)) {
                    stack.push(pos);
                    System.out.println("Push: " + pos);
                    displayBoard(stack, n);
                    cols[row]++;
                    row++;

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

    public static boolean isSafe(Position pos, Stack<Position> queens) {

        for (Position q : queens) {

            if (q.col == pos.col) return false;

            if (Math.abs(q.row - pos.row) == Math.abs(q.col - pos.col))
                return false;
        }
        return true;
    }

    public static void displayBoard(Stack<Position> queens, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                boolean found = false;

                for (Position q : queens) {
                    if (q.row == i && q.col == j) {
                        found = true;
                        break;
                    }
                }

                System.out.print(found ? " Q " : " . ");
            }
            System.out.println();
        }
        System.out.println("Stack: " + queens);
        System.out.println();
    }
}