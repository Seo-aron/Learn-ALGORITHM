import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1654 {
	public static boolean isChecked(int K, int N, int[] arr, long mid) {
		int sum = 0;
		
		for (int i = 0; i < K; i++) {
			sum += arr[i] / mid;
		}
		
		if (sum >= N) return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long left = 1;
		long right = arr[K-1];
		long ans = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			if (isChecked(K, N, arr, mid)) {
				// 랜선의 여유가 있어서 더 길게 도전해 볼 수 있는 경우
				left = mid + 1;
				ans = mid;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
}
