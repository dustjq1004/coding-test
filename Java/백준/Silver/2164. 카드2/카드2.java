import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        int i = 2;
        while (queue.size() > 1) {
            if (i % 2 == 0) {
                queue.poll();
            } else {
                queue.add(queue.poll());
            }
            i++;
        }

        System.out.println(queue.poll());
    }
}