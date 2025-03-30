import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class City implements Comparable<City>{
    int index, cost;

    public City(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(City other) {
        return this.cost - other.cost;
    }
}

public class P1916 {
    public static void dijkstra(List<List<City>> graph, int start, int end){
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City current = pq.poll();
            int cIndex = current.index;
            int cCost = current.cost;

            if (cCost > distance[cIndex]) continue;

            for (City next : graph.get(cIndex)){
                int nCost = cCost + next.cost;

                if (nCost < distance[next.index]){
                    distance[next.index] = nCost;
                    pq.offer(new City(next.index, nCost));
                }
            }
        }

        System.out.println(distance[end]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        List<List<City>> graph = new ArrayList<>();
        for (int i = 0; i <= city; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < bus; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new City(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        dijkstra(graph, startCity, endCity);
    }
}
