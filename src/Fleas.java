import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Fleas {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n, m, s, t, q;
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt() - 1;
        t = scanner.nextInt() - 1;
        q = scanner.nextInt();

        if(n < 0 || m < 0 || s < 0 || t < 0 || q < 0){
            System.out.println("-1");
            throw new IOException();
        }

        int[][] matrix = new int[n][m], distances = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int fleaCount = q;
        int[][] horseMove = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        for (int[] distance : distances) {
            Arrays.fill(distance, INF);
        }

        Queue<int[]> queue = new LinkedList<>();
        distances[s][t] = 0;
        visited[s][t] = true;
        queue.add(new int[]{s, t});

        while (!queue.isEmpty()) {
            if (queue.peek() == null) break;
            int[] coord = queue.poll();
            for (int[] ints : horseMove) {
                int x = ints[0];
                int y = ints[1];
                if (!isStepExist(coord, ints, matrix)) continue;

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
                countSteps += distances[fleaCoord[0] -1][fleaCoord[1] - 1];
            }
            System.out.println(countSteps);
        } else {
            System.out.println(-1);
        }
    }

    // METHOD
    static boolean isAllFeed(int[][] distances) {
        boolean isAllFeed = true;
        for (int i = 1; i < distances.length; i++) {
            for (int j = 1; j < distances[i].length; j++) {
                if (distances[i][j] == INF) {
                    isAllFeed = false;
                    break;
                }
            }
        }
        return isAllFeed;
    }

    static boolean isStepExist(int[] point, int[] step, int[][] area){
        boolean isStepExist = false;
        int nx = point[0] + step[0];
        int ny = point[1] + step[1];
        if ((nx >= 0 && ny >= 0) && (nx < area.length && ny < area.length)){
            isStepExist = true;
        }
        return isStepExist;
    }
}