import java.util.Scanner;

public class EscapeAlargeMage {

    public static int X = 1000;
    public static int Y = 100;

    public static char[][] maze = new char[X][Y];

    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        addBlockedSourceTragetPositions(blocked, source, target);
        boolean res = backtrack(source);
        displayTable();
        return res;
    }

    public static boolean backtrack(int[] source) {
        return i_backtrack(source[0], source[1]);
    }

    public static boolean i_backtrack(int i, int j) {
        if (isMoveDown(i, j)) {
            if (isWinningMove(i + 1, j))
                return true;
            else {
                move(i + 1, j);
                boolean found = i_backtrack(i + 1, j);
                if (!found){
                    unMove(i + 1, j);
                }
                else
                    return true;
            }
        }

        if (isMoveUp(i, j)) {
            if (isWinningMove(i - 1, j))
                return true;
            else {
                move(i - 1, j);
                boolean found = i_backtrack(i - 1, j);
                if (!found)
                    unMove(i - 1, j);
                else
                    return true;
            }
        }

        if (isMoveLeft(i, j)) {
            if (isWinningMove(i, j - 1))
                return true;
            else {
                move(i, j - 1);
                boolean found = i_backtrack(i, j - 1);
                if (!found)
                    unMove(i, j - 1);
                else
                    return true;
            }
        }

        if (isMoveRight(i, j)) {

            if (isWinningMove(i, j + 1))
                return true;
            else {
                move(i, j + 1);
                boolean found = i_backtrack(i, j + 1);
                if (!found)
                    unMove(i, j + 1);
                else
                    return true;
            }
        }
        return false;
    }

    public static boolean isMoveUp(int i, int j) {
        if (!isValidIndex(i - 1, j))
            return false;
        return (maze[i - 1][j] == 'O' && !isBlocked(i - 1, j) && !visited(i-1, j)) || isWinningMove(i-1, j);

    }

    public static boolean isMoveLeft(int i, int j) {
        if (!isValidIndex(i, j - 1))
            return false;
        return (maze[i][j - 1] == 'O' && !isBlocked(i, j - 1) && !visited(i, j-1)) || isWinningMove(i, j-1);
    }

    public static boolean isMoveRight(int i, int j) {
        if (!isValidIndex(i, j + 1))
            return false;
        return (maze[i][j + 1] == 'O' && !isBlocked(i, j + 1) && !visited(i, j+1)) || isWinningMove(i, j+1);
    }

    public static boolean isMoveDown(int i, int j) {
        if (!isValidIndex(i + 1, j))
            return false;
        boolean res = (maze[i + 1][j] == 'O' && !isBlocked(i + 1, j) && !visited(i+1, j)) || isWinningMove(i+1, j);
        return res;
    }

    public static void move(int i, int j) {
        maze[i][j] = 'V';
    }

    public static void unMove(int i, int j) {
        maze[i][j] = 'O';
    }

    public static boolean isValidIndex(int i, int j) {
        boolean res = i >= 0 && i < X && j >= 0 && j < Y;
        return res;
    }

    public static boolean isWinningMove(int i, int j) {
        return maze[i][j] == 'T';
    }

    public static boolean visited(int i, int j) {
        return maze[i][j] == 'V';
    }

    public static boolean isBlocked(int i, int j) {
        boolean res = maze[i][j] == 'X' || maze[i][j] == 'V';
        return res;
    }

    public static void addBlockedSourceTragetPositions(int[][] blocked, int[] source, int[] target) {
        for (char[] fil : maze) {
            for (int i = 0; i < fil.length; i++) {
                fil[i] = 'O';
            }
        }

        // add blocked cells
        for (int i = 0; i < blocked.length; i++) {
            maze[blocked[i][0]][blocked[i][1]] = 'X';
        }

        maze[source[0]][source[1]] = 'S'; // ADD THE SOURCE

        maze[target[0]][target[1]] = 'T';
    }

    public static void displayTable() {
        for (char[] cs : maze) {
            for (char c : cs) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] blocked = {
                { 1, 2 },
                { 2, 1 },
                { 4, 5 },
                { 2, 1 },
                { 3, 1 },
                { 3, 2 },
                { 3, 3 },
                { 3, 4 },
                { 3, 5 },
                { 3, 6 },
                { 3, 7 },
                { 3, 8 },
                { 3, 9 },
                { 3, 0 },
                { 2, 6 },
                { 7, 7 },
                { 8, 1 },
                { 8, 9 },
                { 9, 8 }
        };

        int[] source = { 0, 0 };
        int[] target = { 50, 50 };
        System.out.print(isEscapePossible(blocked, source, target));
    }

}
