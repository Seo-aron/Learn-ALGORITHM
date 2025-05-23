import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class P12738 {
	static int lowerBound(List<Integer> list, int target) {
		int left = 0;
		int right = list.size();
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(list.get(mid) < target) left = mid + 1;
			else right = mid;
		}
		
		return left;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int a : arr) {
			int idx = lowerBound(list, a);
			if(idx == list.size()) list.add(a);
			else list.set(idx, a);
		}
		
		System.out.println(list.size());
	}
}
