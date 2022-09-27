import java.util.Scanner;
public class PushDominoes_838 {
    public static char[] arrDominoes;

    public static String pushDominoes(String dominoes) {
        arrDominoes = dominoes.toCharArray();
        int index = 0;
        while (index < arrDominoes.length) {
            char domino = arrDominoes[index];
            if (domino == '.')
                index++;
            else {
                if (domino == 'L') {
                    smashleftdominos(index - 1);
                    index++;
                } else { // when domino is right 'R'

                    int leftIndex = findFirstLeft(index + 1);
                    int rightIndex = findFirstRight(index + 1);

                    if (rightIndex < leftIndex && rightIndex!=-1) {
                        smashRightdominos(index + 1);
                        index = rightIndex;
                    } else {
                        smashDominosLeftRight(index, leftIndex);
                        index = leftIndex + 1;
                    }
                }

            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : arrDominoes) {
            builder.append(c);
        }

        return builder.toString();
    }

    public static void smashDominosLeftRight(int rightIndex, int leftIndex) {
        int i = rightIndex;
        int j = leftIndex;
        boolean found = false;
        while ((j - i) > 1 && !found && leftIndex < arrDominoes.length) { // check if RL
            if (checkMoves(i, j)) { // check moves ar valid for both left and right by comparing the indexes
                arrDominoes[i + 1] = 'R';
                arrDominoes[j - 1] = 'L';
            }
            i++;
            j--;
        }
    }

    public static boolean checkMoves(int i, int j) {
        return (j - 1) != (i + 1);
    }

    // Find the first right domino starting from begin index
    public static int findFirstRight(int beginIndex) {
        boolean found = false;
        int index = beginIndex;
        while (index < arrDominoes.length && !found) {
            if (arrDominoes[index] == 'R')
                found = true;
            else
                index++;
        }
        if(!found) index=-1;
        return index;
    }

    public static int findFirstLeft(int beginIndex) {
        boolean found = false;
        int index = beginIndex;
        while (index < arrDominoes.length && !found) {
            if (arrDominoes[index] == 'L')
                found = true;
            else
                index++;
        }

        if(!found) index=-1;
        return index;
    }

    // Throw left dominos when we enconter our first left domino
    public static void smashleftdominos(int index) {
        if (index < 0 || arrDominoes[index] == 'L')
            return;
        else {
            char domino = arrDominoes[index];
            if (domino == '.')
                ;
            arrDominoes[index] = 'L';
            smashleftdominos(index - 1);
        }
    }

    public static void smashRightdominos(int index) {
        if (index < 0 || arrDominoes[index] == 'R')
            return;
        else {
            char domino = arrDominoes[index];
            if (domino == '.')
                ;
            arrDominoes[index] = 'R';
            smashleftdominos(index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(pushDominoes(sc.nextLine()));
    }
}
