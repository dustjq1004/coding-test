import java.util.*;

class Solution {
    // enemy_len은 배열 enemy의 길이입니다.
    public int solution(int n, int k, int enemy[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;
        for (int en : enemy) {
            pq.offer(en);
            n -= en;
            if (n < 0) {
                if (k <= 0) {
                    return answer;
                }

                int largestNumber = pq.poll();
                // 무적권을 사용한 경우
                n += largestNumber;
                k--;
            }
            answer++;
        }

        return answer;
    }
}