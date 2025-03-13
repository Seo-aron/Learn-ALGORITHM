import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1446 {
    static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void dijkstra(List<List<Node>> graph, int start) {
        int[] distance = new int[graph.size()];
        int MAX = Integer.MAX_VALUE;
        Arrays.fill(distance, MAX);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int cIndex = current.index;
            int cCost = current.cost;

            if (cCost > distance[cIndex]) continue;

            for (Node next : graph.get(cIndex)){
                int newCost = distance[cIndex] + next.cost;
                if (newCost < distance[next.index]) {
                    distance[next.index] = newCost;
                    pq.offer(new Node(next.index, newCost));
                }
            }
        }

        System.out.println(distance[distance.length - 1]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int shortcut = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++){
            graph.get(i).add(new Node(i+1, 1));
        }

        for (int i = 0; i < shortcut; i++){
            st = new StringTokenizer(br.readLine());
            int Start = Integer.parseInt(st.nextToken());
            int End = Integer.parseInt(st.nextToken());
            int shortLength = Integer.parseInt(st.nextToken());

            if (End > length) {
                continue;
            }
            if ((End - Start) <= shortLength ) {
                continue;
            }

            graph.get(Start).add(new Node(End, shortLength));
        }
        dijkstra(graph, 0);
    }
}
