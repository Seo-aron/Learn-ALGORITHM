import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P15666 {
	static StringBuilder sb = new StringBuilder();
	
	public static void func(int n, int m, int[] arr, List<Integer> result, int start) {
		if (result.size() == m) {
			for (int j = 0; j < result.size(); j++) {
				sb.append(result.get(j)).append(" ");	
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (i != 0 && arr[i] == arr[i-1]) continue;
			
			result.add(arr[i]);
			func(n, m, arr, result, i);
			result.remove(result.size() - 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		func(n, m, arr, new ArrayList<Integer>(), 0);
		
		System.out.println(sb);
	}
}
