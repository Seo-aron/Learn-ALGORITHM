import java.io.*;
import java.util.*;

public class P1149 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] home = new int[n+1][3];
		int[][] dp = new int[n+1][3];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][0] = home[1][0];
		dp[1][1] = home[1][1];
		dp[1][2] = home[1][2];
		
		for(int i=2; i<=n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + home[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + home[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + home[i][2];
		}
		
		int ans = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
		
		System.out.println(ans);
	}
}
