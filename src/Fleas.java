import java.io.IOException;
import java.util.*;

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

        if(n <= 0 || m <= 0 || s < 0 || t < 0 || q <= 0){
            System.out.println(-1);
            throw new IOException();
        }

        int[][] matrix = new int[n][m], distances = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int fleaCount = q;
        int[][] fleaCoordinates = new int[fleaCount][2];
        for (int i = 0; i < fleaCount; i++) {
            fleaCoordinates[i][0] = scanner.nextInt();
            fleaCoordinates[i][1] = scanner.nextInt();
        }
        int[][] horseMove = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {2, 1}, {1, 2}};
        for (int[] distance : distances) {
            Arrays.fill(distance, INF);
        }

        Queue<int[]> queue = new LinkedList<>();
        distances[s][t] = 0;
        visited[s][t] = true;
        queue.add(new int[]{s, t});

        while (!queue.isEmpty()) {
            if (queue.peek() == null) break;
            int[] coordinates = queue.poll();
            for (int[] ints : horseMove) {
                int x = ints[0];
                int y = ints[1];
                if (!isStepExist(coordinates, ints, matrix)) continue;

                int newX = x + coordinates[0];
                int newY = y + coordinates[1];
                if (!visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    distances[newX][newY] = distances[coordinates[0]][coordinates[1]] + 1;
                }
            }
        }

        System.out.println(sumOfSteps(distances, fleaCoordinates));
    }

    // METHODS
    // SUM OF STEPS
    static int sumOfSteps(int[][] distances, int[][] fleaCoordinates){
        int result = 0;
        for (int i = 0; i < fleaCoordinates.length; i++) {
            int fx = fleaCoordinates[i][0] - 1;
            int fy = fleaCoordinates[i][1] - 1;
            if (distances[fx][fy] == INF){
                result = -1;
                break;
            }
            result += distances[fx][fy];
        }
        return result;
    }

    // CHECK NEXT STEP
    static boolean isStepExist(int[] point, int[] step, int[][] area){
        boolean isStepExist = false;
        int nx = point[0] + step[0];
        int ny = point[1] + step[1];
        if ((nx >= 0 && ny >= 0) && (nx < area.length && ny < area[0].length)){
            isStepExist = true;
        }
        return isStepExist;
    }
}