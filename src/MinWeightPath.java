import java.io.*;
import java.util.Arrays;

import static java.lang.Math.min;

public class MinWeightPath {
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

        for (int i = 0; i < 1; i++){
            for (int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    sumArray[i][j] = planeSize[i][j];
                    continue;
                }
                sumArray[i][j] = sumArray[i][j -1] + planeSize[i][j];
            }
        }

        for (int i = 0; i < n; i++){
            if(i == 0){
                continue;
            }
            sumArray[i][0] = sumArray[i-1][0] + planeSize[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++){
                sumArray[i][j] = min((planeSize[i][j] + sumArray[i-1][j]),(planeSize[i][j] + sumArray[i][j-1]));
            }
        }

        writer.write(String.valueOf(sumArray[--n][--m]));
        reader.close();
        writer.close();
    }
}