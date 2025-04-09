import java.io.*;
import java.util.*;

public class P2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);

            while (!stack.isEmpty() && stack.peek()[0] < num) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek()[1]).append(" ");
            }

            stack.push(new int[]{num, i + 1});
        }

        System.out.println(sb);
    }
}
