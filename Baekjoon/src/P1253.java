import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;

        for(int i=0; i<n; i++){
            int target = arr[i];
            int left = 0;
            int right = n-1;

            while(left<right){
                // 타겟은 타겟을 제외한 서로 다른 수로만 합쳐야함
                if(left == i){
                    left++;
                    continue;
                }
                if(right==i){
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if(sum == target){
                    cnt++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}
