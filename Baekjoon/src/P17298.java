import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] result = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // 시간초과 이슈로 스택사용
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && array[stack.peek()] < array[i]){
                int idx = stack.pop();
                result[idx] = array[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
