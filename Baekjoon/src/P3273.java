import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int target = Integer.parseInt(br.readLine());

        isCount(size, target, arr);
    }

    private static void isCount(int size, int target, int[] arr) {
        int start = 0;
        int end = size - 1;
        int result = 0;

        while(start < end) {
            int sum = arr[start] + arr[end];

            if (target == sum) {
                result++;
                start++;
                end--;
            } else if (target > sum) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(result);
    }
}
