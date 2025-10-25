import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cup = Integer.parseInt(br.readLine());
        int[] podo = new int[cup+1];

        for (int i = 1; i <= cup; i++) {
            podo[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[cup+1];

        dp[1] = podo[1];
        if (cup >= 2) dp[2] = podo[1] + podo[2];

        for (int i = 3; i <= cup; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + podo[i], dp[i-3] + podo[i-1] + podo[i]));
        }

        System.out.println(dp[cup]);
    }
}
