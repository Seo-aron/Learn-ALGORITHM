import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2606 {
    public static int virus(List<List<Integer>> graph, int start){
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            result++;

            for (int i = 0; i < graph.get(node).size(); i++){
                int next = graph.get(node).get(i);

                if (!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

        return result - 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= node; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = virus(graph, 1);
        System.out.println(result);
    }
}
