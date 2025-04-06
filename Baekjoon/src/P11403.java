import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class P11403 {
    private static void dfs(List<List<Integer>> graph, int[][] map, int startNode, List<Integer> nextNode) {
        for (int i = 0; i < nextNode.size(); i++){
            int next = nextNode.get(i);
            if (map[startNode][next] == 1) continue;
            map[startNode][next] = 1;
            dfs(graph, map, startNode, graph.get(next));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (map[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }
        int[][] resultMap = new int[n+1][n+1];
        for (int i = 1; i <= n; i++){
            dfs(graph, resultMap, i, graph.get(i));
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                sb.append(resultMap[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
