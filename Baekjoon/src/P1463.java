import java.util.Scanner;

public class P1463 {
    static int[] dp;

    // top down (시간초과)
//    public static int top(int num){
//        if (num == 1) return 0;
//        if (dp[num] != 0) return dp[num];
//
//        dp[num] = top(num - 1) + 1;
//        if (num % 2 == 0) dp[num] = Math.min(dp[num], top(num/2) + 1);
//        if (num % 3 == 0) dp[num] = Math.min(dp[num], top(num/3) + 1);
//
//        return dp[num];
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        dp = new int[num+1];
        dp[1] = 0;

        for (int i = 2; i <= num; i++){
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[num]);
    }
}
