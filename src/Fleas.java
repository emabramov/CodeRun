import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line  = reader.readLine();
        line = line.replace(" ", "");


        int n, m, s, t, q;
        n = Integer.parseInt(String.valueOf(line.charAt(0)));
        m = Integer.parseInt(String.valueOf(line.charAt(1)));
        s = Integer.parseInt(String.valueOf(line.charAt(2)));
        t = Integer.parseInt(String.valueOf(line.charAt(3)));
        q = Integer.parseInt(String.valueOf(line.charAt(4)));

        int[][] matrix = new int[n + 1][m + 1];

        
    }
}
