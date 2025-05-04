import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Party implements Comparable<Party> {
    int index, cost;

    public Party(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Party o) {
        return this.cost - o.cost;
    }
}

public class P1238 {
    // 파티장 가는 길
    private static int partyHome(List<List<Party>> graph, int start, int end) {
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Party> pq = new PriorityQueue<>();
        pq.offer(new Party(start, 0));

        while (!pq.isEmpty()){
            Party current = pq.poll();
            int index = current.index;
            int cost = current.cost;

            if (cost > distance[index]) continue;

            for (Party next : graph.get(index)) {
                int newCost = distance[index] +  next.cost;
                if (newCost < distance[next.index]) {
                    distance[next.index] = newCost;
                    pq.offer(new Party(next.index, newCost));
                }
            }
        }

        return distance[end];
    }
    // 집가는 길
    private static int goHome(List<List<Party>> graph, int start, int end) {
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Party> pq = new PriorityQueue<>();
        pq.offer(new Party(start, 0));

        while (!pq.isEmpty()){
            Party current = pq.poll();
            int index = current.index;
            int cost = current.cost;

            if (cost > distance[index]) continue;

            for (Party next : graph.get(index)) {
                int newCost = distance[index] +  next.cost;
                if (newCost < distance[next.index]) {
                    distance[next.index] = newCost;
                    pq.offer(new Party(next.index, newCost));
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        List<List<Party>> graph = new ArrayList<>();

        for (int i = 0; i <= node; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Party(end, cost));
        }

        int max = 0;
        int[] total = new int[node + 1];

        for (int i = 1; i <= node; i++){
            total[i] = partyHome(graph, i, target);
        }
        for (int i = 1; i <= node; i++){
            total[i] += goHome(graph, target, i);

            if (max < total[i]) max = total[i];
        }

        System.out.println(max);
    }
}
