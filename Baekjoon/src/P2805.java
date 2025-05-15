import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805 {

    public static boolean isChecked(int[] arr, int n, int m, int mid){
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > mid) sum += arr[i] - mid;
        }

        return sum >= m;
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
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isChecked(arr, N, M, mid)){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
