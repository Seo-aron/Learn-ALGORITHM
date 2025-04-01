import java.util.Scanner;

public class P1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count + 1];
        int[] dp = new int[count + 1];

        for (int i = 1; i <= count; i++){
            arr[i] = sc.nextInt();
        }

        dp[1] = arr[1];
        int max = dp[1];

        for (int i = 2; i <= count; i++){
            dp[i] = Math.max(arr[i], arr[i] + dp[i-1]);

            if (max < dp[i]) max = dp[i];
        }

        System.out.println(max);
    }
}
