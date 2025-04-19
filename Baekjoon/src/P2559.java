import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 전체 날짜수
        int k = Integer.parseInt(st.nextToken());   // 연속 날짜
        int[] temper = new int[n];
        List<Integer> sum = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            temper[i] = Integer.parseInt(st.nextToken());
        }

        for (int start = 0; start <= n - k; start++) {
            int end = start + k - 1;
            int tempSum = 0;

            for (int i = start; i <= end; i++) {
                tempSum += temper[i];
            }
            sum.add(tempSum);
        }

        Collections.sort(sum, Collections.reverseOrder());
        System.out.println(sum.get(0));
    }
}
