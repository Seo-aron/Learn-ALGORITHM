import java.util.Scanner;

public class P9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] dp = new int[15];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 11; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for (int i = 0; i < t; i++){
            int num = sc.nextInt();
            System.out.println(dp[num]);
        }
    }
}
