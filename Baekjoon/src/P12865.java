import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int item = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        int[] bagWeight = new int[item+1];
        int[] bagValue = new int[item+1];
        int[][] dp = new int[item+1][weight+1];

        for (int i = 1; i <= item; i++){
            st = new StringTokenizer(br.readLine());
            bagWeight[i] = Integer.parseInt(st.nextToken());
            bagValue[i] = Integer.parseInt(st.nextToken());
        }

        // DP start
        for (int i = 1; i <= item; i++){
            for (int w = 0; w <= weight; w++){
                // 현재 아이템을 넣지 않는 경우
                dp[i][w] = dp[i - 1][w];

                // 현재 아이템을 넣을 수 있는 경우
                if (w >= bagWeight[i]){
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - bagWeight[i]] + bagValue[i]);
                }
            }
        }

        System.out.println(dp[item][weight]);

    }
}
