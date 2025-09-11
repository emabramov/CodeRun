import java.io.*;
import java.util.Arrays;

public class HorseMovement {
// TODO:
//  Дана прямоугольная доска N×M N строк и M столбцов.
//  В левом верхнем углу находится шахматный конь,
//  которого необходимо переместить в правый нижний угол доски.
//  В данной задаче конь может перемещаться на две клетки вниз
//  и одну клетку вправо или на одну клетку вниз и две клетки вправо.
//  Необходимо определить, сколько существует различных маршрутов,
//  ведущих из левого верхнего в правый нижний угол.
//  Формат ввода
//  Входной файл содержит два натуральных числа N и M
//  Формат вывода
//  В выходной файл выведите единственное число — количество способов добраться конём до правого нижнего угла доски.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = reader.readLine().split(" ");
        int x = Integer.parseInt(size[0]);
        int y = Integer.parseInt(size[1]);
        int[][] area = new int[x + 1][y + 1];
        area[1][1] = 1;

        for (int i = 2; i <= x; i++)
            for (int j = 2; j <= y; j++)
                area[i][j] = area[i - 1][j - 2] + area[i - 2][j - 1];

        System.out.println(area[x][y]);

        reader.close();
        writer.close();
    }
}
