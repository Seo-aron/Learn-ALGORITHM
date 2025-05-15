import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int oldRest = Integer.parseInt(st.nextToken());
		int newRest = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		int[] oldRestArr = new int[oldRest + 2];
		
		oldRestArr[0] = 0;
		oldRestArr[oldRest + 1] = length;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= oldRest; i++) {
			oldRestArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(oldRestArr);
		
		int left = 1;
		int right = length - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			
			for (int i = 1; i < oldRestArr.length; i++) {
				int dist = oldRestArr[i] - oldRestArr[i - 1];
				count += (dist - 1) / mid;
			}
			
			if (count > newRest) left = mid + 1;
            else right = mid - 1;
		}
		
		System.out.println(left);
	}
}
