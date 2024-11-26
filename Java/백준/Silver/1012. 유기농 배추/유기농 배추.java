import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[][] board;
    static int[][] visited;
    static int[][] direction = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    static int row;
    static int col;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            String[] input = br.readLine().split(" ");
            row = Integer.parseInt(input[0]);
            col = Integer.parseInt(input[1]);
            int cabbageCount = Integer.parseInt(input[2]);
            board = new int[row][col];
            visited = new int[row][col];
            for (int i = 0; i < cabbageCount; i++) {
                input = br.readLine().split(" ");
                int r = Integer.parseInt(input[0]);
                int c = Integer.parseInt(input[1]);

                board[r][c] = 1;
            }

            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 1 && visited[i][j] == 0) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static boolean bfs(int r, int c) {
        Queue<Cabbage> queue = new ArrayDeque<>();
        queue.add(new Cabbage(r, c));
        visited[r][c] = 1;
        while (!queue.isEmpty()) {
            Cabbage cabbage = queue.poll();

            for (int i = 0; i < direction.length; i++) {
                int[] dir = direction[i];
                int currentRow = cabbage.row + dir[0];
                int currentCol = cabbage.col + dir[1];

                if (currentRow >= 0 && currentRow < row && currentCol >= 0 && currentCol < col
                        && board[currentRow][currentCol] == 1 && visited[currentRow][currentCol] == 0) {
                    queue.add(new Cabbage(currentRow, currentCol));
                    visited[currentRow][currentCol] = 1;
                }
            }
        }

        return false;
    }


}
class Cabbage {
    int row;
    int col;

    public Cabbage(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
