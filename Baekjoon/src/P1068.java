import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1068 {
    static int ans = 0;

    public static void dfs(List<Integer>[] tree, int now, int delNode){
        boolean isLeaf = true;

        for (int node : tree[now]){
            if (node == delNode) continue;
            isLeaf = false;
            dfs(tree, node, delNode);
        }

        if(isLeaf) ans++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new ArrayList[node];
        for (int i=0; i<node; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] parent = new int[node];
        for (int i=0; i<node; i++){
            parent[i] = Integer.parseInt(st.nextToken());
        }

        int root = -1;
        for (int i=0; i<node; i++){
            if (parent[i] == -1) root = i;
            else tree[parent[i]].add(i);
        }

        int delNode = Integer.parseInt(br.readLine());

        if (delNode == root) System.out.print(0);
        else {
            dfs(tree, root, delNode);
            System.out.print(ans);
        }
    }
}
