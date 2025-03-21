import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stair = Integer.parseInt(br.readLine());

        int[] score = new int[stair + 1];
        for (int i = 1; i <= stair; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        if (stair == 1) {
            System.out.println(score[1]);
            return;
        }

        int[] dp = new int[stair + 1];
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        for (int s = 3; s <= stair; s++){
            dp[s] = score[s] + Math.max(dp[s - 2], dp[s - 3] + score[s - 1]);
        }

        System.out.println(dp[stair]);
    }
}
