import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int student = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[student+1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= student; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        for (int i = 1; i <= student; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (int n : graph.get(now)) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    queue.offer(n);
                }
            }
        }
    }
}
