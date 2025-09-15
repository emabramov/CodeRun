import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
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
        HorseStep step = new HorseStep();

        int n, m, s, t, q;
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        t = scanner.nextInt();
        q = scanner.nextInt();

        int[][] matrix = new int[n + 1][m + 1];

        
    }
}

class HorseStep{
    public int[][] getSteps() {
        return steps;
    }

    private int[][] steps = {
            {-2, -1},
            {-2, 1},
            {-1, -2},
            {-1, 2},
            {1, -2},
            {1, 2},
            {2, -1},
            {2, 1}
    };

    public HorseStep(){
        this.steps = getSteps();
    }
}