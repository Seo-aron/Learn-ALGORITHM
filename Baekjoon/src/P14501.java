import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int day = Integer.parseInt(br.readLine());
		int[] date = new int[day + 2];
		int[] wage = new int[day + 2];
		
		for (int i = 1; i <= day; i++) {
			st = new StringTokenizer(br.readLine());
			date[i] = Integer.parseInt(st.nextToken());
			wage[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[day + 2];
		
		for (int i = 1; i <= day + 1; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			
			if (i + date[i] <= day + 1) {
				dp[i + date[i]] = Math.max(dp[i + date[i]], dp[i] + wage[i]);
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[day + 1]);
	}
}
