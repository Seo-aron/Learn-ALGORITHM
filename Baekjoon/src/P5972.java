import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Barn implements Comparable<Barn> {
    int index, cost;

    public Barn(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Barn o) {
        return this.cost - o.cost;
    }
}

public class P5972 {
    static int node;
    static int edge;

    public static void dijkstra(List<List<Barn>> graph, int start) {
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[node + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Barn> pq = new PriorityQueue<>();
        pq.offer(new Barn(start, 0));

        while (!pq.isEmpty()) {
            Barn current = pq.poll();
            int cIndex = current.index;
            int cCost = current.cost;

            if (distance[cIndex] < cCost) continue;

            for (Barn next : graph.get(cIndex)) {
                int newCost = distance[cIndex] + next.cost;
                if (distance[next.index] > newCost) {
                    distance[next.index] = newCost;
                    pq.offer(new Barn(next.index, newCost));
                }
            }
        }

        System.out.println(distance[node]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        List<List<Barn>> graph = new ArrayList<>();

        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Barn(end, cost));
            graph.get(end).add(new Barn(start, cost));
        }

        dijkstra(graph, 1);
    }
}
