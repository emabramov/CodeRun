import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        HorseStep steps = new HorseStep();

        int n, m, s, t, q;
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        t = scanner.nextInt();
        q = scanner.nextInt();

        int[][] matrix = new int[n + 1][m + 1];
        int[] feedPoint = new int[2];
        feedPoint[0] = s;
        feedPoint[1] = t;
        int fleaCount = q;
        List<FleaPos> fleaPosList = new ArrayList<>();
        for (int i = 0; i < fleaCount; i++){
            fleaPosList.add(new FleaPos(scanner.nextInt(), scanner.nextInt()));
        }

        checkStep(steps.getSteps()[0], matrix, fleaPosList.get(0).getFleaPos());

    }

    public static boolean checkStep(int[] step, int[][] matrix, int[] fleaPos){
        if(matrix[step[0]][step[1]] > 0){
            return true;
        }
        return false;
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

class FleaPos {
    private final int[] fleaPos = new int[2];

    public int[] getFleaPos() {
        return fleaPos;
    }

    public FleaPos(int x, int y){
        fleaPos[0] = x;
        fleaPos[1] = y;
    }
}