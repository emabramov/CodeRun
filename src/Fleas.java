import com.sun.jdi.BooleanValue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
В первой строке входного файла находится 5 чисел, разделенных пробелом: N, M, S, T, Q.
N, M — размеры доски (отсчет начинается с 1);
S, T — координаты клетки — кормушки (номер строки и столбца соответственно);
Q — количество блох на доске.
Далее Q строк по два числа — координаты каждой блохи.
 */

public class Fleas {
    public static void main(String[] args) throws IOException {
        File input = new File("CodeRunYandex/resources/flea.txt");

        Scanner scanner = new Scanner(input);

        int n, m, s, t, q;
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        t = scanner.nextInt();
        q = scanner.nextInt();

        int[][] matrix = new int[n][m], distances = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] feedPoint = new int[2];
        feedPoint[0] = s;
        feedPoint[1] = t;
        int fleaCount = q;
        int[][] horseMove = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}