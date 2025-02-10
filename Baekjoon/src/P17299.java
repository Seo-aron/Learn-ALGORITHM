import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] input = new int[size];
        int[] count = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++){
            input[i] = Integer.parseInt(st.nextToken());
            count[input[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            while(!stack.isEmpty() && count[input[stack.peek()]] < count[input[i]]){
                result[stack.pop()] = input[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
