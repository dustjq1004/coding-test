import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
/*
개구리를 납치할 수 있는 최대 갯수 구하기
개구리 개수 배열이 주어진다.
배열 인덱스 중 임의에 하나를 골라 선택하면서 최대로 얻을 수 있는 개수 탐색
하나를 선택하면 주변은 선택하지 못한다.

5 9 1 3 7 2

5 9 6 12 16 14

2 2 2 4 2 4 2 6 2 4


dp[n] =
* */
class Solution
{
    public static void main(String args[]) throws Exception
    {
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(bf.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test = 1; test <= T; test++) {
            int n = Integer.parseInt(bf.readLine());
            long[] arr = new long[n + 1];
            long[] dp = new long[n + 1];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp[1] = arr[1];
            dp[2] = Math.max(arr[1], arr[2]);
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
            }

            System.out.println("#" + test + " " + dp[n]);
        }
    }
}
