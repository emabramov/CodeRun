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

        int[][] matrix = new int[n + 1][m + 1], distances = new int[n + 1][m + 1], visited = new int[n + 1][m + 1];
        int[] feedPoint = new int[2];
        feedPoint[0] = s;
        feedPoint[1] = t;
        int fleaCount = q;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[0][j] = j;
            }
            matrix[i][0] = i;
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[i].length; j++){
                matrix[i][j] = -1;
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < distances.length; i++){
            for (int j = 0; j < distances[i].length; j++){
                System.out.print(distances[i][j]);
            }
            System.out.println();
        }
    }
}