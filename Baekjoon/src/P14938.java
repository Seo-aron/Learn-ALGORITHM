import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ground implements Comparable<ground> {
    int index, cost;

    public ground (int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(ground other) {
        return this.cost - other.cost;
    }
}

public class P14938 {
    public static int sg(List<List<ground>> graph, int start, int mr, int[] item){
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<ground> pq = new PriorityQueue<>();
        pq.offer(new ground(start, 0));

        while (!pq.isEmpty()){
            ground current = pq.poll();
            int index = current.index;
            int cost = current.cost;

            if (cost > distance[index]) continue;

            for (ground next : graph.get(index)) {
                int nextCost = distance[index] + next.cost;

                if (nextCost < distance[next.index]) {
                    distance[next.index] = nextCost;
                    pq.offer(new ground(next.index, nextCost));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] <= mr) {
                ans += item[i];
            }
        }

        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int mr = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        int[] item = new int[node + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= node; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        List<List<ground>> graph = new ArrayList<>();
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(op).add(new ground(ed, dist));
            graph.get(ed).add(new ground(op, dist));
        }

        int max = 0;
        for (int i = 1; i <= node; i++) {
            int sum = sg(graph, i, mr, item);

            if (max < sum) max = sum;
        }

        System.out.println(max);
    }
}
