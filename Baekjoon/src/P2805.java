import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805 {
    static int sum;

    public static boolean isChecked(int[] arr, int n, int m, int mid){
        int[] mod = new int[n];
        sum = 0;

        for (int i = 0; i < n; i++) {
            mod[i] = arr[i] - mid;
            sum += mod[i];
        }

        if (sum == m) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 나무 수
        int M = Integer.parseInt(st.nextToken());   // 가져가는 나무 길이
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N-1];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isChecked(arr, N, M, mid)){
                // M값과 일치 = 정답
                System.out.println(mid);
            } else {
                if (sum > mid) left = mid + 1;
                else if (sum < mid) right = mid - 1;
            }
        }
    }
}
