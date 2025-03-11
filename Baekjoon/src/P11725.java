import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11725 {
    static int node;

    public static int[] dfs(List<List<Integer>> graph, int start, boolean[] visited, int[] parent){
        visited[start] = true;

        for (int current : graph.get(start)){
            if (!visited[current]){
                parent[current] = start;
                dfs(graph, current, visited, parent);
            }
        }

        return parent;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<List<Integer>> graph = new ArrayList<>();
        node = Integer.parseInt(br.readLine());

        for (int i = 0; i <= node; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < node - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] parent = dfs(graph, 1, new boolean[node+1], new int[node+1]);

        for (int i = 2; i < parent.length; i++){
            System.out.println(parent[i]);
        }
    }
}
