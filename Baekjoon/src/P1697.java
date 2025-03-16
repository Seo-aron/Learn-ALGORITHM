import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1697 {
    static boolean[] visited;

    public static void bfs(int subin, int sister){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{subin, 0});
        visited[subin] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int node = now[0];
            int time = now[1];

            if (node == sister){
                System.out.println(time);
                return;
            }

            int[] nextSubin = {node - 1, node + 1, node * 2};
            for (int next : nextSubin){
                if (next >= 0 && next <= 100000 && !visited[next]){
                    visited[next] = true;
                    queue.add(new int[]{next, time + 1});
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int sister = sc.nextInt();
        visited = new boolean[100001];

        bfs(subin, sister);
    }
}
