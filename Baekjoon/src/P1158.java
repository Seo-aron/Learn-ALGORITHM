import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class P1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int person = Integer.parseInt(input[0]);
        int cnt = Integer.parseInt(input[1]);
        int current = 0;

        List<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= person; i++) {
            queue.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        while(!queue.isEmpty()){
            current = (current + cnt - 1) % queue.size();
            result.append(queue.remove(current));
            if(!queue.isEmpty()){
                result.append(", ");
            }
        }
        result.append(">");
        System.out.println(result);
    }
}
