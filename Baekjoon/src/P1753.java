import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int index, cost;

    public Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}

public class P1753 {
    public static void dijkstra(List<List<Node>> graph, int start){
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int cIndex = current.index;
            int cCost = current.cost;

            if (cCost > distance[cIndex]) continue;

            for (Node next : graph.get(cIndex)){
                int nIndex = next.index;
                int nCost = distance[cIndex] + next.cost;
                if (nCost < distance[nIndex]){
                    distance[nIndex] = nCost;
                    pq.offer(new Node(nIndex, nCost));
                }
            }
        }

        for (int i = 1; i < graph.size(); i++){
            if (distance[i] == INF){
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= node; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int co = Integer.parseInt(st.nextToken());

            graph.get(n1).add(new Node(n2, co));
        }

        dijkstra(graph, startNode);
    }
}
