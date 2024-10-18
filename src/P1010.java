import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());	// 총 테스트 케이스
		int[] res_arr = new int[T];
		int cnt;

		// 경우의 수 구하기
		for(cnt = 0; cnt < T; cnt++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int result = 1;
		
			for(int i = 1; i <= N; i++) {
				result = result * (M-i+1) / i;
			}
			res_arr[cnt] = result;

			// 각 케이스 별 경우의 수 출력
			System.out.println(res_arr[cnt]);
		}
	}
}