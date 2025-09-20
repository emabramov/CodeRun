import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Fleas {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        int n, m, s, t, q;
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        t = scanner.nextInt();
        q = scanner.nextInt();

        int[][] matrix = new int[n + 1][m + 1], distances = new int[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];
        int fleaCount = q;
        int[][] horseMove = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        for (int[] distance : distances) {
            Arrays.fill(distance, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        distances[s][t] = 0;
        visited[s][t] = true;
        queue.add(new int[]{s, t});

        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            for (int i = 0; i < horseMove.length; i++) {
                int x = horseMove[i][0];
                int y = horseMove[i][1];
                if ((coord[0] + x <= 0 || coord[1] + y <= 0) || (coord[0] + x >= matrix.length || coord[1] + y >= matrix.length))
                    continue;

                int newX = coord[0] + x;
                int newY = coord[1] + y;
                if (!visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    distances[newX][newY] = distances[coord[0]][coord[1]] + 1;
                }
            }
        }

        if (isAllFeed(distances)) {
            int countSteps = 0;
            for (int i = 0; i < fleaCount; i++){
                int[] fleaCoord = new int[2];
                fleaCoord[0] = scanner.nextInt();
                fleaCoord[1] = scanner.nextInt();
                countSteps += distances[fleaCoord[0]][fleaCoord[1]];
            }
            System.out.println(countSteps);
        } else {
            System.out.println(-1);
        }
    }


    // METHODS
    static int sumOfDistances(int[][] distances) {
        int sum = 0;
        for (int i = 1; i < distances.length; i++) {
            for (int j = 1; j < distances[i].length; j++) {
                sum += distances[i][j];
            }
        }
        return sum;
    }

    static boolean isAllFeed(int[][] distances) {
        boolean isAllFeed = true;
        for (int i = 1; i < distances.length; i++) {
            for (int j = 1; j < distances[i].length; j++) {
                if (distances[i][j] == -1) {
                    isAllFeed = false;
                    break;
                }
            }
        }
        return isAllFeed;
    }
}