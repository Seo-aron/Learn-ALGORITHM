import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182 {
    static int n;
    static int s;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            isBrute(i+1, sum);
        }

        System.out.println(cnt);
    }

    private static void isBrute(int i, int sum) {
        if (i == n){
            if (sum == s) {
                cnt++;
            }
            return;
        }

        isBrute(i+1, sum + arr[i]);
        isBrute(i+1, sum);
    }

}
