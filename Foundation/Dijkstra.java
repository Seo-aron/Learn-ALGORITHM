/*
    Dijkstra Algorithm (다익스트라 알고리즘)

    - 다익스트라 알고리즘 : 그래프에서 한 노드에서 다른 모든 노드까지의 최단 경로를 찾는 알고리즘
                           (음의 가중치가 없을 때 사용 가능, 우선순위 큐(힙) 사용 시 O(E log V)의 시간복잡도)
    
    - 동작 방식 :
        1. 출발 노드를 기준으로 최단 거리를 저장하는 배열을 생성하고, 모든 거리를 무한대(INF)로 초기화
        2. 우선순위 큐(PriorityQueue)를 사용하여 최단 거리가 가장 짧은 노드를 먼저 선택
        3. 해당 노드를 기준으로 인접한 노드들의 최단 거리를 갱신
        4. 모든 노드에 대해 위 과정을 반복하여 최단 거리 테이블을 완성
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int index, cost;

    public Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other){
        return this.cost - other.cost;  // 비용이 작은 순으로 정렬
    }
}

public class Dijkstra {
    // 다익스트라 알고리즘 (우선순위 큐)
    public static void dijkstra(List<List<Node>> graph, int start){
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.index;
            int nowCost = current.cost;

            if (nowCost > distance[now]) continue;

            for (Node next : graph.get(now)) {
                int newCost = distance[now] + next.cost;
                if (newCost < distance[next.index]) {
                    distance[next.index] = newCost;
                    pq.offer(new Node(next.index, newCost));
                }
            }
        }

        // 최단 거리 출력
        System.out.println("최단 거리 결과");
        for (int i = 0; i < distance.length; i++){
            System.out.println("노드 " + i + "까지의 최단 거리: " + (distance[i] == INF ? "INF" : distance[i]));
        }
    }
    public static void main(String[] args) {
        int node = 6;
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < node; i++){
            graph.add(new ArrayList<>());
        }

        // 간선 정보 (노드1, 노드2, 가중치)
        graph.get(0).add(new Node(1, 2));
        graph.get(0).add(new Node(2, 5));
        graph.get(1).add(new Node(2, 1));
        graph.get(1).add(new Node(3, 3));
        graph.get(2).add(new Node(3, 8));
        graph.get(2).add(new Node(4, 7));
        graph.get(3).add(new Node(4, 2));
        graph.get(4).add(new Node(5, 5));

        System.out.println("Dijkstra");
        dijkstra(graph, 0);
    }
}
