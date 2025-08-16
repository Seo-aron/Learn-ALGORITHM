import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int left = 0; left < n; left++) {
            int sum = arr[left];
            for (int right = left; right < n; right++) {
                if (left != right) {
                    sum += arr[right];
                }

                if (target == sum) {
                    ans++;
                    break;
                } else if (target < sum) {
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
