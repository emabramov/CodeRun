import javax.swing.plaf.IconUIResource;
import java.io.*;

import static java.lang.Math.max;

public class TraceRouteTurtleMaxNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dimension = reader.readLine().split(" ");
        int n = Integer.parseInt(dimension[0]);
        int m = Integer.parseInt(dimension[1]);
        int x, y;
        int[][] planeSize = new int[n][m];
        int[][] sumArray = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] line = input.split(" ");
            for (int j = 0; j < m; j++) {
                planeSize[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < m; i++){
                if(i == 0){
                    sumArray[0][i] = planeSize[0][i];
                    continue;
                }
                sumArray[i][i] = sumArray[i][i -1] + planeSize[i][i];
        }

        for (int i = 0; i < n; i++){
            if(i == 0){
                continue;
            }
            sumArray[i][0] = sumArray[i-1][0] + planeSize[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++){
                x = planeSize[i][j] + sumArray[i-1][j];
                y = planeSize[i][j] + sumArray[i][j-1];
                sumArray[i][j] = max(x, y);
            }
        }

        x = n-1;
        y = m-1;
        int chars = x + y;
        char[] reversePath = new char[chars];
        for (int i = chars; i > 0; i--){
            if(x == 0){
                reversePath[i-1] = 'R';
                y--;
                continue;
            }
            if(y == 0){
                reversePath[i-1] = 'D';
                x--;
                continue;
            }
            if(sumArray[x-1][y] > sumArray[x][y-1]){
                reversePath[i-1] = 'D';
                x--;
            } else {
                reversePath[i-1] = 'R';
                y--;
            }
        }

        String path = "";
        for (int i = reversePath.length; i > 0; i--) {
            path = path.concat(String.valueOf(reversePath[i-1]));
            path = path.concat(" ");
        }

        path = path.trim();
        writer.write(sumArray[n - 1][m - 1] + "\n" + path);
        reader.close();
        writer.close();
    }
}
