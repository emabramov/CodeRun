import java.io.*;

public class HorseMovement {

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
