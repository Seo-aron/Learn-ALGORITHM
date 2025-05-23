import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] num;
	static int[] opr;
	
	static void operator(int sum, int k) {
		if(k == n) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		// +
		if(opr[0] > 0) {
			opr[0]--;
			operator(sum+num[k], k+1);
			opr[0]++;
		}
		// -
		if(opr[1] > 0) {
			opr[1]--;
			operator(sum-num[k], k+1);
			opr[1]++;}
		// *
		if(opr[2] > 0) {
			opr[2]--;
			operator(sum*num[k], k+1);
			opr[2]++;
		}
		// /
		if(opr[3] > 0) {
			opr[3]--;
			operator(sum/num[k], k+1);
			opr[3]++;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		opr = new int[4];	// 0번인덱스부터 순서대로  + - * /
		
		// 피연산자
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		// 연산자
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			opr[i] = Integer.parseInt(st.nextToken());
		}
		
		operator(num[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
}
